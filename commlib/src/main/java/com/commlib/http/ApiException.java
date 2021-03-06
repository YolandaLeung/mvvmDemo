package com.commlib.http;

/*
 *@Description: 自定义异常封装
 *@Author: hl
 *@Time: 2018/9/29 15:38
 */
public class ApiException extends RuntimeException{
    public static final int ERROR = 1;
    public static final int TOKEN = 2;
    public static final int NO_NET = 3;
    private static String message;

    public ApiException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code){
        switch (code) {
            case TOKEN:
               message = "Token过期";
                break;
            case ERROR:
                message = "请求错误";
                break;
            case NO_NET:
                message = "网络未连接";
                break;
            default:
                message = "未知错误";
        }
        return message;
    }
}