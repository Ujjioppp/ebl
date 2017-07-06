package org.ebl.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yeli on 06/07/2017.
 */
@Component
@Aspect
public class ControllerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("execution(public * org.ebl.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        try{
            LOGGER.info("the args is {}" , JSONObject.toJSONString(joinPoint.getArgs()));
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.info("error is {}",e.toString());
        }
    }
}
