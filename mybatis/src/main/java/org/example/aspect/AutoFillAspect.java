package org.example.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.util.AutoFill;
import org.example.util.OperationType;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    @Pointcut("execution(* org.example.mapper.*.*(..))&& @annotation(org.example.util.AutoFill)")
    public void AutoFillPoint(){

    }

    @Before("AutoFillPoint()")
    public void AutoFill(JoinPoint joinPoint) throws InvocationTargetException,IllegalAccessError{
            Object[] args = joinPoint.getArgs();
            if(args==null || args.length==0){
                return;
            }
            Object entity = args[0];
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AutoFill annotation = method.getAnnotation(AutoFill.class);

        LocalDateTime now = LocalDateTime.now();
        OperationType value = annotation.value();

        if(value == OperationType.INSERT){
            try{
                Method createTime = entity.getClass().getDeclaredMethod("setCreateTime",LocalDateTime.class);
                Method updateTime = entity.getClass().getDeclaredMethod("setUpdateTime",LocalDateTime.class);
                createTime.invoke(entity,now);
                updateTime.invoke(entity,now);

            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if(value == OperationType.UPDATE){
            try {
                Method updateTime = entity.getClass().getDeclaredMethod("setUpdateTime",LocalDateTime.class);
                updateTime.invoke(entity,now);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }



    }
}
