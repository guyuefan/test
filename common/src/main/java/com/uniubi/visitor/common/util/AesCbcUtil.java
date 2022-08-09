package com.uniubi.visitor.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.Security;

@Slf4j
public class AesCbcUtil {
    /**
     * 设置加密字符集
     * 本例采用 UTF-8 字符集
     */
    private static final String CHARACTER = "UTF-8";

    /**
     * 加密算法
     */
    private static final String ENCRY_ALGORITHM = "AES";

    /**
     * 加密算法/加密模式/填充类型
     * 本例采用AES加密，ECB加密模式，PKCS5Padding填充
     */
    private static final String CIPHER_MODE = "AES/ECB/PKCS5Padding";

    /**
     * 设置加密密码处理长度。
     * 不足此长度补0；
     */
    private static final int PWD_SIZE = 16;

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * AES解密
     *
     * @param data 密文，被加密的数据
     * @param key  秘钥
     * @param iv   偏移量
     * @return
     * @throws Exception
     */
    public static String decrypt(String data, String key, String iv) {
        //被加密的数据
        byte[] dataByte = Base64.decodeBase64(data);
        //加密秘钥
        byte[] keyByte = Base64.decodeBase64(key);
        //偏移量
        byte[] ivByte = Base64.decodeBase64(iv);

        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");

            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");

            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));

            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);

            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return result;
            }
            return null;
        } catch (Exception e) {
            log.error("解密失败:{}", e);
        }
        return null;
    }

    /**
     * 原始解密
     *
     * @param cipherTextBytes 密文字节数组，待解密的字节数组
     * @param pwdBytes        解密密码字节数组
     * @return 返回解密后的明文字节数组，解密错误返回null
     */
    public static byte[] decrypt1(byte[] cipherTextBytes, byte[] pwdBytes) {

        try {
            // 1 获取解密密钥
            SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ENCRY_ALGORITHM);
            // 2 获取Cipher实例
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            // 3 初始化Cipher实例。设置执行模式以及加密密钥
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            // 4 执行
            byte[] clearTextBytes = cipher.doFinal(cipherTextBytes);
            // 5 返回明文字符集
            return clearTextBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 解密错误 返回null
        return null;
    }

    /**
     * 原始加密
     *
     * @param clearTextBytes 明文字节数组，待加密的字节数组
     * @param pwdBytes       加密密码字节数组
     * @return 返回加密后的密文字节数组，加密错误返回null
     */
    public static byte[] encrypt(byte[] clearTextBytes, byte[] pwdBytes) {
        try {
            // 1 获取加密密钥
            SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ENCRY_ALGORITHM);
            // 2 获取Cipher实例
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            // 3 初始化Cipher实例。设置执行模式以及加密密钥
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            // 4 执行
            byte[] cipherTextBytes = cipher.doFinal(clearTextBytes);
            // 5 返回密文字符集
            return cipherTextBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BASE64加密
     *
     * @param clearText 明文，待加密的内容
     * @param password  密码，加密的密码
     * @return 返回密文，加密后得到的内容。加密错误返回null
     */
    public static String encryptBase64(String clearText, String password) {
        try {
            // 1 获取加密密文字节数组
            byte[] cipherTextBytes = encrypt(clearText.getBytes(CHARACTER), pwdHandler(password));
            // 2 对密文字节数组进行BASE64 encoder 得到 BASE6输出的密文
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String cipherText = base64Encoder.encode(cipherTextBytes);
            // 3 返回BASE64输出的密文
            return cipherText;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 加密错误 返回null
        return null;
    }

    /**
     * BASE64解密
     *
     * @param cipherText 密文，带解密的内容
     * @param password   密码，解密的密码
     * @return 返回明文，解密后得到的内容。解密错误返回null
     */
    public static String decryptBase64(String cipherText, String password) {
        try {
            // 1 对 BASE64输出的密文进行BASE64 decodebuffer 得到密文字节数组
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] cipherTextBytes = base64Decoder.decodeBuffer(cipherText);
            // 2 对密文字节数组进行解密 得到明文字节数组
            byte[] clearTextBytes = decrypt1(cipherTextBytes, pwdHandler(password));
            // 3 根据 CHARACTER 转码，返回明文字符串
            return new String(clearTextBytes, CHARACTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 解密错误返回null
        return null;
    }

    /**
     * 密码处理方法
     * 如果加解密出问题，
     * 请先查看本方法，排除密码长度不足填充0字节,导致密码不一致
     *
     * @param password 待处理的密码
     * @return
     * @throws UnsupportedEncodingException
     */
    private static byte[] pwdHandler(String password) throws UnsupportedEncodingException {
        byte[] data = null;
        if (password != null) {
            byte[] bytes = password.getBytes(CHARACTER);
            if (password.length() < PWD_SIZE) {
                System.arraycopy(bytes, 0, data = new byte[PWD_SIZE], 0, bytes.length);
            } else {
                data = bytes;
            }
        }
        return data;
    }

}