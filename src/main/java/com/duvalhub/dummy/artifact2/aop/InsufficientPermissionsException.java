package com.duvalhub.dummy.artifact2.aop;
import com.duvalhub.roleaop.artifact.aop.AuthorizationException;
public class InsufficientPermissionsException extends AuthorizationException {

    public InsufficientPermissionsException(String message) {
        super(message);
    }

    public InsufficientPermissionsException(String format, Object... args) {
        this(String.format(format, args));
    }

}
