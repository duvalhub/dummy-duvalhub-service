//package com.duvalhub.dummy.artifact2.aop;
//
//import com.duvalhub.dummy.artifact2.service.role.RoleAndPermissionCache;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Aspect
//@Component
//@Slf4j
//public class RoleAndPermissionAspect {
//
//    @Resource
//    RoleAndPermissionCache roleAndPermissionCache;
//
//    final ObjectMapper objectMapper;
//
//    @Autowired
//    public RoleAndPermissionAspect(ObjectMapper objectMapper) {
//
//        this.objectMapper = objectMapper;
//
//    }
//
//    @Around("execution(public * ca.philippeduval.roleaop.service..*(..)) && @target(com.duvalhub.dummy.artifact2.aop.RoleAndPermission)")
//    public void logPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Class<?> declaringClass = methodSignature.getMethod().getDeclaringClass();
//
//        if (declaringClass.isAnnotationPresent(RoleAndPermission.class)) {
//
//            RoleAndPermission annotation = AnnotationUtils.findAnnotation(declaringClass, RoleAndPermission.class);
//
//            List<String> theRoles = Stream.of(Arrays.asList(annotation.value()), Arrays.asList(annotation.roles()))
//                    .flatMap(Collection::stream)
//                    .collect(Collectors.toList());
//
//            roleAndPermissionCache
//                    .checkRoles(theRoles);
//
//            List<String> thePermissions = Arrays.asList(annotation.permissions());
//
//            roleAndPermissionCache
//                    .checkPermissions(thePermissions);
//
//        }
//
//        joinPoint.proceed();
//
//    }
//
//}
