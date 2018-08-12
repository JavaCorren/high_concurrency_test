package com.example.high_currency_test.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5Util工具类
 *
 * @author ZhangGR
 * @created on 2018/8/10
 **/
public class MD5Util {

    /**
     * MD5 加盐字符
     */
    private static final String salt = "1a2b3c4d";

        public static String md5(String src) {
            return DigestUtils.md5Hex(src);
        }

}
