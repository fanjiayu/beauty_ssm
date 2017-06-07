package com.ysgj.ssm.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by fanjiayu on 16/7/26.
 */
public class RSAUtil {

    private static final Logger LOG = LoggerFactory.getLogger(RSAUtil.class);
    /**
     * 私钥
     */
    private static RSAPrivateKey privateKey;

    /**
     * 公钥
     */
    private static RSAPublicKey publicKey;

//    public static RSAPrivateKey getPrivateKey() {
//        return privateKey;
//    }
//
//    public static RSAPublicKey getPublicKey() {
//        return publicKey;
//    }

    //从字符串中加载公钥
    public static void loadPublicKey(String publicKeyStr) throws Exception {
        byte[] buffer = Base64.decodeBase64(publicKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
        publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    //从文件中读取公钥
    public static void loadPublicKeyFromFile(String path) throws Exception {
        try {
            InputStream in = new FileInputStream(path);
//            BufferedReader br = new BufferedReader(new InputStreamReader(RSAUtil.class.getClassLoader().getResourceAsStream("public.pem"),"UTF-8"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            loadPublicKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("公钥数据流读取错误");
        } catch (NullPointerException e) {
            throw new Exception("公钥输入流为空");
        }
    }

    //从字符串中加载私钥
    public static void loadPrivateKey(String privateKeyStr) throws Exception {
        byte[] buffer = Base64.decodeBase64(privateKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
        privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }

    //从文件中读取私钥
    public static void loadPrivateKeyFromFile() throws Exception {
        BufferedReader br = null;
        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            br = new BufferedReader(new InputStreamReader(RSAUtil.class.getClassLoader().getResourceAsStream("private_pkcs8_20.pem"),"UTF-8"));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            loadPrivateKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("私钥数据读取错误",e);
        } catch (NullPointerException e) {
            throw new Exception("私钥输入流为空");
        }finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    LOG.error("Monitor:RSAUtil | 读取关闭异常 ", e);
                }
            }
        }

    }

    //公钥加密
    public static String encrypt(byte[] plainTextData)
            throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] enBytes = cipher.doFinal(plainTextData);
            return toHexString(enBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("RSA-publicKey-加密异常");
        } catch (NoSuchPaddingException e) {
            throw new Exception("RSA-publicKey-加密异常");
        }
    }

    //私钥解密
    public static String decrypt(byte[] cipherTextData)
            throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] deBytes = cipher.doFinal(cipherTextData);
            return new String(deBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("RSA-privateKey-解密异常");
        } catch (NoSuchPaddingException e) {
            throw new Exception("RSA-privateKey-解密异常");
        }
    }

    private static char[] HEXCHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static byte[] toBytes(String s) {
        byte[] bytes;
        bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }


    //将字节数组转换成十六进制字符串
    private static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEXCHAR[(b[i] & 0xf0) >>> 4]);
            sb.append(HEXCHAR[b[i] & 0x0f]);
        }
        return sb.toString();
    }

}
