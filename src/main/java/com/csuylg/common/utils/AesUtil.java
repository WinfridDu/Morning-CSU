package com.csuylg.common.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 加密解密
 *
 * @author xxx
 */
public class AesUtil {
    /**
     * 偏移量
     */
    public static final String VIPARA = "8765432187654321";
    /**
     * 私钥
     */
    private static final String AES_KEY="1234567812345678";
    /**
     * 编码方式
     */
    public static final String CODE_TYPE = "UTF-8";
    /**
     * 填充类型
     */
    public static final String AES_TYPE = "AES/CBC/PKCS5Padding";

    /**
     * 加密
     *
     * @param cleartext 明文
     * @return 密文
     */
    public static String encrypt(String cleartext) {
        //加密方式： AES128(CBC/PKCS5Padding) + Base64, 私钥：1111222233334444
        try {
            IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
            //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
            SecretKeySpec key = new SecretKeySpec(AES_KEY.getBytes(), "AES");
            //实例化加密类，参数为加密方式，要写全
            //PKCS5Padding比PKCS7Padding效率高，PKCS7Padding可支持IOS加解密
            Cipher cipher = Cipher.getInstance(AES_TYPE);
            //初始化，此方法可以采用三种方式，按加密算法要求来添加。（1）无第三个参数（2）第三个参数为SecureRandom random = new SecureRandom();中random对象，随机数。(AES不可采用这种方法)（3）采用此代码中的IVParameterSpec
            //加密时使用:ENCRYPT_MODE;  解密时使用:DECRYPT_MODE;
            //CBC类型的可以在第三个参数传递偏移量zeroIv,ECB没有偏移量
            cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
            //加密操作,返回加密后的字节数组，然后需要编码。主要编解码方式有Base64, HEX, UUE,7bit等等。此处看服务器需要什么编码方式
            byte[] encryptedData = cipher.doFinal(cleartext.getBytes(CODE_TYPE));

            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 解密
     *
     * @param encrypted 密文
     * @return 明文
     */
    public static String decrypt(String encrypted) {
        try {
            byte[] byteMi = Base64.getDecoder().decode(encrypted);
            IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
            SecretKeySpec key = new SecretKeySpec(
                    AES_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(AES_TYPE);
            //与加密时不同MODE:Cipher.DECRYPT_MODE
            //CBC类型的可以在第三个参数传递偏移量zeroIv,ECB没有偏移量
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
            byte[] decryptedData = cipher.doFinal(byteMi);
            return new String(decryptedData, CODE_TYPE);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
