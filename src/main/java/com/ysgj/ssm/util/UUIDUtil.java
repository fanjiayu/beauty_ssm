package com.ysgj.ssm.util;

import java.util.UUID;

/**
 * Created by 331 on 2016/9/23.
 * @author fanjiayu
 */
public class UUIDUtil {

    private UUIDUtil() {
    }

    public static final String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
