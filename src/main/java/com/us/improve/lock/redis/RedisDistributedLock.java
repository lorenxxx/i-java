package com.us.improve.lock.redis;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisDistributedLock
 * @Desciption 基于Redis实现分布式锁
 * @Author loren
 * @Date 2020/4/16 9:44 PM
 * @Version 1.0
 **/
public class RedisDistributedLock {

    private static final String LOCK_SUCCESS = "OK";

    private static final Long RELEASE_SUCCESS = 1L;

    private static final String SET_IF_NOT_EXIST = "NX";

    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * redis 客户端
     */
    private Jedis jedis;

    /**
     * 分布式锁的键值
     */
    private String lockKey;

    /**
     * 锁的超时时间 10s
     */
    int expireTime = 10 * 1000;

    /**
     * 锁等待，防止线程饥饿
     */
    int acquireTimeout = 1 * 1000;

    /**
     * 获取指定键值的锁
     *
     * @param jedis   jedis Redis客户端
     * @param lockKey 锁的键值
     */
    public RedisDistributedLock(Jedis jedis, String lockKey) {
        this.jedis = jedis;
        this.lockKey = lockKey;
    }

    /**
     * 获取指定键值的锁,同时设置获取锁超时时间
     *
     * @param jedis          jedis Redis客户端
     * @param lockKey        锁的键值
     * @param acquireTimeout 获取锁超时时间
     */
    public RedisDistributedLock(Jedis jedis, String lockKey, int acquireTimeout) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.acquireTimeout = acquireTimeout;
    }

    /**
     * 获取指定键值的锁,同时设置获取锁超时时间和锁过期时间
     *
     * @param jedis          jedis Redis客户端
     * @param lockKey        锁的键值
     * @param acquireTimeout 获取锁超时时间
     * @param expireTime     锁失效时间
     */
    public RedisDistributedLock(Jedis jedis, String lockKey, int acquireTimeout, int expireTime) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.acquireTimeout = acquireTimeout;
        this.expireTime = expireTime;
    }

    /**
     * 加锁
     *
     * @return
     */
    public String lock() {
        try {
            // 尝试加锁的超时时间，超过这个时间则放弃获取锁
            long end = System.currentTimeMillis() + acquireTimeout;

            // 随机生成一个value
            String requireToken = UUID.randomUUID().toString();

            while (System.currentTimeMillis() < end) {
                String result = jedis.set(lockKey, requireToken, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
                if (LOCK_SUCCESS.equals(result)) {
                    return requireToken;
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    /**
     * 解锁
     *
     * @param requireToken
     * @return
     */
    public boolean release(String requireToken) {
        if (StringUtils.isBlank(requireToken)) {
            return false;
        }

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = new Object();

        try {
            result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requireToken));
            if (RELEASE_SUCCESS.equals(result)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if(jedis != null){
                jedis.close();
            }
        }

        return false;
    }

}
