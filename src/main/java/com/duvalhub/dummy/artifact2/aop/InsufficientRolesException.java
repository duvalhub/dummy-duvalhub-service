//package com.duvalhub.dummy.artifact2.aop;
//
//import com.duvalhub.roleaop.artifact.aop.AuthorizationException;
//
//public class InsufficientRolesException extends AuthorizationException {
//
//    public InsufficientRolesException(String message) {
//        super(message);
//    }
//
//    public InsufficientRolesException(String format, Object... args) {
//        this(String.format(format, args));
//    }
//
//    @Override
//    public synchronized Throwable fillInStackTrace() {
//        return this;
//    }
//
//}
