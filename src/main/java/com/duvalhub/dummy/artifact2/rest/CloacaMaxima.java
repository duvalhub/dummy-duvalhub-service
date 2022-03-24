//package com.duvalhub.dummy.artifact2.rest;
//
//import com.duvalhub.roleaop.artifact.aop.AuthorizationException;
//import com.duvalhub.dummy.artifact2.aop.InsufficientPermissionsException;
//import com.duvalhub.dummy.artifact2.aop.InsufficientRolesException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import javax.servlet.http.HttpServletRequest;
//import java.time.LocalDateTime;
//import java.util.LinkedHashMap;
//
//@ControllerAdvice
//public class CloacaMaxima {
//
//    @ExceptionHandler({InsufficientRolesException.class, InsufficientPermissionsException.class})
//    public ResponseEntity<Object> handleCityNotFoundException(
//            AuthorizationException e, HttpServletRequest request) {
//
//        return new ResponseEntity<>(new LinkedHashMap<>() {{
//            put("timestamp", LocalDateTime.now());
//            put("message", e.getMessage());
//            put("path", request.getRequestURI());
//        }}, HttpStatus.FORBIDDEN);
//
//    }
//
//}
