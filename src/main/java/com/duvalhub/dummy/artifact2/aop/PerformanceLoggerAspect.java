//package com.duvalhub.dummy.artifact2.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
//@Aspect
//@Component
//@Slf4j
//public class PerformanceLoggerAspect {
//
//    @Around("execution(public * ca.philippeduval.roleaop.service..*(..)) && @target(com.duvalhub.dummy.artifact2.aop.PerformanceLogger)")
//    public void logPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        joinPoint.proceed();
//        long timeTakenInMilliseconds = System.currentTimeMillis() - startTime;
//
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Class<?> declaringClass =  methodSignature.getMethod().getDeclaringClass();
//        PerformanceLogger logger = declaringClass.getAnnotation(PerformanceLogger.class);
//
//        final String timeUnit;
//        final long timeTaken;
//        switch (logger.timeUnit()) {
//            case MILLISECONDS:
//                timeUnit = "ms";
//                timeTaken = timeTakenInMilliseconds;
//                break;
//            case SECONDS:
//                timeUnit = "s";
//                timeTaken = TimeUnit.MILLISECONDS.toSeconds(timeTakenInMilliseconds);
//                break;
//            default:
//                throw new UnsupportedOperationException("timeUnit unsupported");
//        }
//
//        final String logMessage = String.format("%s method took %d %s",
//                methodSignature.getMethod().getName(), timeTaken, timeUnit);
//
//        log.info(logMessage);
//    }
//
//}
