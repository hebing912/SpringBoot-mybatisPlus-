package com.inossem.electric.common.utils;

import cn.hutool.core.util.NumberUtil;

public class NumberStrUtil {

    public static Integer toInteger(Long arg) {
        return arg == null ? null : arg.intValue();
    }

    public static Integer toInteger(String arg) {
        return NumberUtil.isNumber(arg) ? NumberUtil.parseInt(arg) : null;
    }

    public static Long toLong(Integer arg) {
        return arg == null ? null : arg.longValue();
    }

    public static Long toLong(String arg) {
        return NumberUtil.isNumber(arg) ? NumberUtil.parseLong(arg) : null;
    }

}
