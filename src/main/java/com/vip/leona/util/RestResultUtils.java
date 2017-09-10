package com.vip.leona.util;

import com.vip.leona.venum.ResultCode;

public class RestResultUtils {


    public static Object successRet(ResultCode code, Object content) {
        return ResultUtils.getInstance(true, code.getCode(), code.name(), content);
    }

    public static Object successRet(ResultCode code, Object content, Object... strings) {
        return ResultUtils.getInstance(true, code.getCode(), code.name(), content, strings);
    }

    public static Object failedRet(ResultCode code, Object content) {
        return ResultUtils.getInstance(false, code.getCode(), code.name(), content);
    }

    public static Object failedRet(ResultCode code, Object content, Object... strings) {
        return ResultUtils.getInstance(false, code.getCode(), code.name(), content,strings);
    }
}
