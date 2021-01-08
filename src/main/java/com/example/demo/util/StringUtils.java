package com.example.demo.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {


    /**
     * 判断字符串是不是空或者空串
     *
     * @param charSequence
     * @return
     */
    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (charSequence == null || (length = charSequence.length()) == 0) return true;
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) return false;
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    /**
     * 字符串是不是等于null
     *
     * @param charSequence
     * @return
     */
    public static boolean isEmpty(CharSequence charSequence) {
        int length;
        if (charSequence == null || (length = charSequence.length()) == 0) return true;
        return false;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    /**
     * 驼峰到下划线转换
     *
     * @param param 参数
     * @return
     */
    public static String camel4underline(String param) {
        //匹配A-Z之间的一个大大写字母
        Pattern p = Pattern.compile("[A-Z]");
        if (isBlank(param)) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
            i++;
        }

        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    /**
     * 下划线转驼峰
     *
     * @param param
     * @return
     */
    public static String underline2camel(String param) {
        //匹配下划线小写字母
        Pattern p = Pattern.compile("_[a-z]");
        if (param == null || param.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param.toLowerCase());
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() - i, mc.end() - i, mc.group(0).substring(1).toUpperCase());
            i++;
        }

        return builder.toString();
    }

    /**
     * 分转成元（修剪整元）
     *
     * @param fen 分
     * @return 元
     */
    public static String fen2yuanTrim(long fen) {
        String result = changeNumForm(fen, 100L, 2);

        // 整元去除小数部分
        result = result.replace(".00", "");

        return result;
    }

    /**
     * 分转成元
     *
     * @param fen 分
     * @return 元
     */
    public static String fen2yuan(long fen) {
        return changeNumForm(fen, 100L, 2);
    }

    /**
     * 数字转折扣
     *
     * @param num 数字
     * @return 折扣
     */
    public static String num2discount(long num) {
        return discountForm(num, 10L);
    }

    /**
     * 计算折扣
     *
     * @param sale   售价
     * @param origin 原价
     * @return 折扣
     */
    public static String discount(long sale, long origin) {
        return discountForm(sale * 10L, origin);
    }

    /**
     * 折扣值格式化
     *
     * @param num    数字
     * @param divide 折扣计算分母
     * @return 折扣
     */
    private static String discountForm(long num, long divide) {
        String result = changeNumForm(num, divide, 1);

        // 整折去除小数部分
        result = result.replace(".0", "");

        // 10折保留9.9折
        if (result.equals("10")) {
            return "9.9";
        }

        return result;
    }

    private static String changeNumForm(long num, long divide, int scale) {
        return BigDecimal.valueOf(num).divide(new BigDecimal(divide), scale, BigDecimal.ROUND_HALF_UP).toString();
    }
}
