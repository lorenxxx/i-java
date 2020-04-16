package com.us.improve.function;

/**
 * @ClassName AbstractConsumer
 * @Desciption TODO
 * @Author loren
 * @Date 2019/6/21 1:08 AM
 * @Version 1.0
 **/
public abstract class AbstractConsumer<K, V> {

    public abstract void consume();

    public void consume(Consume consume) {
        consume.preConsume();
        consume.doConsume();
        consume.afterConsume();
    }

}
