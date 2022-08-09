package com.uniubi.visitor.common.util;

import java.security.SecureRandom;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NumberFormatUtil {
    /**
     * 根据规则生成流水号
     *
     * @param numberDigit 流水号的位数
     * @param numberValue 流水号的值
     * @return 流水号的值的字符串信息
     */
    public static String numberFormat(int numberDigit, int numberValue) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(numberDigit);
        formatter.setGroupingUsed(false);
        //日期前缀，这里用的是日期前缀+几位的流水号
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
        String dateString = date.format(new Date());
        return dateString + formatter.format(numberValue);
    }


    public static String getCode(int length) {
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < length; i++) {
            sb.append(getOneCode());
        }

        return sb.toString();
    }

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static final char[] RANDOM_DATA = {'2', '3', '4', '5', '6', '7', '8', '9', '1', '0'};


    private static char getOneCode() {
        return RANDOM_DATA[SECURE_RANDOM.nextInt(RANDOM_DATA.length)];
    }

}