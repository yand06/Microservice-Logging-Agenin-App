package com.jdt16.agenin.logging.configuration.redis;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CacheMonitoringAspect {

    @Around("@annotation(org.springframework.cache.annotation.Cacheable)")
    public Object monitorCache(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Cache operation on {}: {}ms",
                joinPoint.getSignature().getName(), executionTime);
        return result;
    }
}
