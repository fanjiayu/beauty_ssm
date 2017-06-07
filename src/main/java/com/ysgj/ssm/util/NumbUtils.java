package com.ysgj.ssm.util;

/**
 * Created by fanjiayu on 2016/8/15.
 */
public class NumbUtils {

    /**
     * 加密手机号，例如：18339922767 -- 183******67
     * @param phone
     * @return
     */
    public static String encryptPhone(String phone){
        if(phone == null || phone.length() != 11){
            return null;
        }
        String midStr = phone.substring(3,9);
        return phone.replaceAll(midStr,"******");
    }

}
