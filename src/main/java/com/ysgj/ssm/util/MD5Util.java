package com.ysgj.ssm.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.zip.CRC32;

/**
 * Created by fanjiayu on 16/7/26.
 */
public class MD5Util {

    private static final Logger LOG = LoggerFactory.getLogger(MD5Util.class);

    private static ThreadLocal<MessageDigest> MD5;
    /**
     * 对用户的password进行加盐加密。
     *
     * @param uid
     * @param password
     * @return
     */
    public static String saltPassword(long uid, String password) {
        String prefix = String.valueOf(uid);
        String suffix = String.valueOf(uid);
        if (uid > 1000) {
            prefix = prefix.substring(0, 2);
            suffix = suffix.substring(2);
        }
        prefix = String.valueOf(getCrc32(prefix));
        suffix = String.valueOf(getCrc32(suffix));
        String newPwd = new StringBuilder(32)
                .append(prefix)
                .append(password)
                .append(suffix).toString();
        try {
            return md5Digest(newPwd.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
//            logger.error(String.format("Salt password false, uid=%s", uid), e);
//            throw MatrixExceptionHelper.rpcMatrixException(UserExcepFactor.E_SERVICE_UNAVAILABLE, "Salt password false");
            LOG.error(String.format("Salt password false, uid=%s", uid), e);
            return null;
        }
    }

    private static long getCrc32(String str) {
        try {
            byte[] b = str.getBytes("utf-8");
            CRC32 crc = (CRC32)crc32Provider.get();
            crc.reset();
            crc.update(b);
            return crc.getValue();
        } catch (UnsupportedEncodingException var2) {
            return -1L;
        }
    }

    private static ThreadLocal<CRC32> crc32Provider = new ThreadLocal() {
        protected CRC32 initialValue() {
            return new CRC32();
        }
    };

    public static String md5Digest(byte[] data) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(data);
            byte[] digest = md5.digest();
            return encodeHex(digest);
        }catch (Exception e) {
            LOG.error("Monitor:MD5Util.md5Digest getInstance exception: ",e);
            return null;
        }
    }

    private static String encodeHex(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length + bytes.length);

        for(int i = 0; i < bytes.length; ++i) {
            if((bytes[i] & 255) < 16) {
                buf.append("0");
            }

            buf.append(Long.toString((long)(bytes[i] & 255), 16));
        }

        return buf.toString();
    }

}
