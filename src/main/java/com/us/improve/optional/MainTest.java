package com.us.improve.optional;

import java.util.Optional;

/**
 * @ClassName MainTest
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/11/17 13:22
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) {

    }

    /*
    没有使用Optional，代码繁琐、丑陋
     */
    public static String getName(User u) {
        if (u == null) {
            return "UNKNOWN";
        }
        return u.getName();
    }

    /*
    错误的Optional使用
     */
    public static String getName2(User u) {
        Optional<User> user = Optional.ofNullable(u);
        if (!user.isPresent()) {
            return "UNKNOWN";
        }
        return user.get().getName();
    }

    /*
    正确的Optional使用
     */
    public static String getName3(User u) {
        return Optional.ofNullable(u)
            .map(user -> user.getName())
            .orElse("UNKNOWN");
    }

    /*
    没有使用Optional，代码繁琐、丑陋
     */
    public static String getChampionName(Competition comp) {
        if (comp != null) {
            Competition.Result result = comp.getResult();
            if (result != null) {
                User user = result.getUser();
                if (user != null) {
                    return user.getName();
                }
            }
        }

        throw new IllegalArgumentException("Illegal Argument.");
    }

    /*
    使用Optional
     */
    public static String getChampionName2(Competition comp) {
        return Optional.ofNullable(comp)
            .map(c -> c.getResult())
            .map(r -> r.getUser())
            .map(u -> u.getName())
            .orElseThrow(() -> new IllegalArgumentException("Illegal Argument."));
    }


}
