package com.xjf.wemall.api.exception;

public class BaseException extends RuntimeException {
	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8458544317507845657L;

    /**
     * 暴露给venus所用的异常code
     */
    private int errorCode;

    /**
     * 各系统内部用的异常code
     */
    private String code;

    /**
     * 用于页面显示的友好异常提示信息
     */
    private String friendlyMessage = "";

    /**
     * code对应消息的参数对象数组
     */
    private Object[] messageArgs;

    /**
     * 缺省友好异常提示信息
     */
    private String defaultFriendlyMessage;

//    /**
//     * 异常类型
//     */
//    private ExceptionType expType;

    /**
     * 构造方法
     */
    public BaseException() {

    }

    /**
     * 用指定的cause异常构造一个新的BaseException
     * 
     * @param cause the exception cause
     */
    public BaseException(Throwable cause) {
        super(cause);
    }

    /**
     * 用指定的异常日志 message构造一个BaseException
     * 
     * @param logMsg the detail message
     */
    public BaseException(String logMsg) {
        super(logMsg);
    }

    /**
     * 用指定code和cause异常构造一个BaseException
     * 
     * @param code the exception code
     * @param cause the exception cause
     * 
     */
    public BaseException(String code, Throwable cause) {
        super(cause);
        revertCode(code, cause);
        this.code = code;
    }

    /**
     * 
     * 用指定的code和cause构造一个BaseException,并指定code对应message的参数值
     * 
     * @param code the exception code
     * @param cause the root cause
     * @param messageArgs the argument array of the message corresponding to code
     */
    public BaseException(String code, Throwable cause, Object[] messageArgs) {
        super(cause);
        revertCode(code, cause);
        this.code = code;
        if (null != messageArgs) {
            this.messageArgs = messageArgs.clone();
        }
    }

    /**
     * 用指定code和异常日志 message构造一个BaseException
     * 
     * @param code the exception code
     * @param logMsg the log message
     * 
     */
    public BaseException(String code, String logMsg) {
        super(logMsg);
        revertCode(code, null);
        this.code = code;
    }

    /**
     * 用指定的code和异常日志 message构造一个BaseException,并指定code对应message的参数值
     * 
     * @param code the exception code
     * @param logMsg the detail message
     * @param messageArgs the argument array of the message corresponding to code
     * 
     */
    public BaseException(String code, String logMsg, Object[] messageArgs) {
        super(logMsg);
        revertCode(code, null);
        this.code = code;
        if (null != messageArgs) {
            this.messageArgs = messageArgs.clone();
        }
    }

    /**
     * 用指定code和异常日志 message以及异常cause构造一个BaseException,
     * 
     * @param code the exception code
     * @param logMsg the detail message
     * @param cause the root cause
     */
    public BaseException(String code, String logMsg, Throwable cause) {
        super(logMsg, cause);
        revertCode(code, cause);
        this.code = code;
    }

    /**
     * 用指定的异常code和异常日志 message以及异常cause构造一个BaseException, 并传递code对应message的参数值
     * 
     * @param code the exception code
     * @param logMsg the detail message
     * @param cause the root cause
     * @param messageArgs the argument array of the message corresponding to code
     */
    public BaseException(String code, String logMsg, Throwable cause, Object[] messageArgs) {
        super(logMsg, cause);
        revertCode(code, cause);
        this.code = code;
        if (null != messageArgs) {
            this.messageArgs = messageArgs.clone();
        }
    }

    /**
     * 用指定的code和异常cause以及缺省的页面友好message构造一个BaseException
     * 
     * @param code the exception code
     * @param cause the root cause
     * @param defaultFriendlyMessage the default friendly message if the friendly message corresponding to code is not
     *            exist.
     */
    public BaseException(String code, Throwable cause, String defaultFriendlyMessage) {
        super(cause);
        revertCode(code, cause);
        this.code = code;
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    /**
     * 用指定的code和异常cause构造一个BaseException,传递code对应message的参数值， 并指定缺省的页面友好message
     * 
     * @param code the exception code
     * @param cause the root cause
     * @param messageArgs the argument array of the message corresponding to code
     * @param defaultFriendlyMessage the default friendly message if the friendly message corresponding to code is not
     *            exist.
     * 
     */
    public BaseException(String code, Throwable cause, Object[] messageArgs, String defaultFriendlyMessage) {
        super(cause);
        revertCode(code, cause);
        this.code = code;
        if (null != messageArgs) {
            this.messageArgs = messageArgs.clone();
        }
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    /**
     * 用指定的code和异常日志message构造一个BaseException,并指定缺省的页面友好message
     * 
     * @param code the exception code
     * @param logMsg the detail message
     * @param defaultFriendlyMessage the default friendly message if the friendly message corresponding to code is not
     *            exist.
     * 
     */
    public BaseException(String code, String logMsg, String defaultFriendlyMessage) {
        super(logMsg);
        revertCode(code, null);
        this.code = code;
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    /**
     * 用指定异常code和异常日志message构造一个BaseException,传递code对应message的参数值, 并指定缺省的页面友好message
     * 
     * @param code the exception code
     * @param logMsg the detail message
     * @param messageArgs the argument array of the message corresponding to code
     * @param defaultFriendlyMessage the default friendly message if the friendly message corresponding to code is not
     *            exist.
     * 
     */
    public BaseException(String code, String logMsg, Object[] messageArgs, String defaultFriendlyMessage) {
        super(logMsg);
        revertCode(code, null);
        this.code = code;
        if (null != messageArgs) {
            this.messageArgs = messageArgs.clone();
        }
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    /**
     * 用指定的code和异常日志message以及异常cause构造一个BaseException, 并指定缺省的页面友好message
     * 
     * @param code the exception code
     * @param logMsg the detail message
     * @param cause the root cause
     * @param defaultFriendlyMessage the default friendly message if the friendly message corresponding to code is not
     *            exist.
     * 
     */
    public BaseException(String code, String logMsg, Throwable cause, String defaultFriendlyMessage) {
        super(logMsg, cause);
        revertCode(code, null);
        this.code = code;
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    /**
     * 用指定异常code和异常日志message以及异常cause构造一个BaseException,传递code对应message的参数值, 并指定缺省的页面友好message
     * 
     * @param code the exception code
     * @param logMsg the detail message
     * @param cause the root cause
     * @param messageArgs the argument array of the message corresponding to code
     * @param defaultFriendlyMessage the default friendly message if the friendly message corresponding to code is not
     *            exist.
     * 
     */
    public BaseException(String code, String logMsg, Throwable cause, Object[] messageArgs,
            String defaultFriendlyMessage) {
        super(logMsg, cause);
        revertCode(code, cause);
        this.code = code;
        if (null != messageArgs) {
            this.messageArgs = messageArgs.clone();
        }
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    /**
     * Return the detail message, including the message from the nested exception if there is one.
     */
    /**
     * @Override public String getMessage() { if(code!=null && code.trim().length()>0){ StringBuilder sb = new
     * StringBuilder(); sb.append("Code: ").append(code) .append("\rMessage: ").append(super.getMessage()); return
     * sb.toString(); } return super.getMessage(); }
     */

    /**
     * 返回friendlyMessage
     * 
     * @return the friendlyMessage
     */
    public String getFriendlyMessage() {
        return friendlyMessage;
    }

    /**
     * 返回errorcode
     * 
     * @return 错误编码
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误编码
     * 
     * @param errorCode 错误编码
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 设置提示信息
     * 
     * @param friendlyMessage the friendlyMessage to set
     */
    public void setFriendlyMessage(String friendlyMessage) {
        this.friendlyMessage = friendlyMessage;
    }

    /**
     * 返回异常信息参数
     * 
     * @return the messageArgs
     */
    public Object[] getMessageArgs() {
        return messageArgs;
    }

    /**
     * 设置异常信息参数
     * 
     * @param messageArgs the messageArgs to set
     */
    public void setMessageArgs(Object[] messageArgs) {
        if (null != messageArgs) {
            this.messageArgs = messageArgs.clone();
        }
    }

    /**
     * 返回默认的提示信息
     * 
     * @return the formattedMessage
     */
    public String getDefaultFriendlyMessage() {
        return defaultFriendlyMessage;
    }

    /**
     * 设置默认的提示信息
     * 
     * @param defaultFriendlyMessage the defaultFriendlyMessage to set
     */
    public void setDefaultFriendlyMessage(String defaultFriendlyMessage) {
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

//    /**
//     * 获取异常类型
//     * 
//     * @return 异常类型
//     */
//    public ExceptionType getExpType() {
//        return expType;
//    }
//
//    /**
//     * 设置异常类型
//     * 
//     * @param expType 异常类型
//     */
//    public void setExpType(ExceptionType expType) {
//        this.expType = expType;
//    }

//    /**
//     * 构造方法
//     * 
//     * @param code 异常编码
//     * @param cause 原因
//     * @param messageArgs 异常参数
//     * @param expType 异常类型
//     */
//    public BaseException(String code, Throwable cause, Object[] messageArgs, ExceptionType expType) {
//        super(cause);
//        revertCode(code, cause);
//        this.code = code;
//        if (null != messageArgs) {
//            this.messageArgs = messageArgs.clone();
//        }
//        this.expType = expType;
//    }

    /**
     * 异常code转换 从code转换成errorcode 1.对于DB连接异常或者数据库访问异常转换成 连接异常:18008001,数据库访问异常:18008002
     * 2.对于业务异常，当业务异常在事务处理中被抛出时，会被transaction捕获包装成BaseException ,此时需要将业务异常code赋值给BaseException的ErrorCode
     * 
     * @param code 系统内部异常code
     * @param cause 原因
     */
    private void revertCode(String code, Throwable cause) {
        if (null != code) {
            if (code.trim().toLowerCase().equals("error.dal.001")) {
                /** 提供给venus的异常code,这里表示连接异常 */
                this.errorCode = 18008001;
            } else if (code.trim().toLowerCase().equals("error.dal.008")) {
                /** 提供给venus的异常code,这里表示数据库访问异常 */
                this.errorCode = 18008002;
            } else if (null != cause) {
//                /** 实现venus CodedException接口的异常需处理 */
//                if (CodedException.class.isAssignableFrom(cause.getClass())) {
//                    this.errorCode = ((CodedException) cause).getErrorCode();
//                } else {
//                    /** 通过 @ExceptionCode也需要处理 */
//                    ExceptionCode ec = cause.getClass().getAnnotation(ExceptionCode.class);
//                    if (null != ec) {
//                        this.errorCode = ec.errorCode();
//                    }
//                }
            	this.errorCode = 0;

            }
        }
    }

    /**
     * 返回系统内部错误编码
     * 
     * @return 系统内部错误编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置系统内部错误编码
     * 
     * @param code 系统内部错误编码
     */
    public void setCode(String code) {
        this.code = code;
    }
}
