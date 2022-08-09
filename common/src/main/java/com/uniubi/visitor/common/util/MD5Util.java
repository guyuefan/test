package com.uniubi.visitor.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by MZS on 2018/8/3.
 */
public class MD5Util {
        public MD5Util() {
        }

        public static String encryption(String plainText) {
            String remd5 = new String();

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(plainText.getBytes());
                byte[] b = md.digest();
                StringBuffer buf = new StringBuffer("");

                for(int offset = 0; offset < b.length; ++offset) {
                    int i = b[offset];
                    if (i < 0) {
                        i += 256;
                    }

                    if (i < 16) {
                        buf.append("0");
                    }

                    buf.append(Integer.toHexString(i));
                }

                remd5 = buf.toString();
            } catch (NoSuchAlgorithmException var7) {
                var7.printStackTrace();
            }

            return remd5;
        }
}
