package com.us.improve.lombok;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName User
 * @Desciption TODO
 * @Author loren
 * @Date 2019/5/16 2:01 PM
 * @Version 1.0
 **/
@Data
@Builder
public class User {

    private Integer id;

    private String name;

}
