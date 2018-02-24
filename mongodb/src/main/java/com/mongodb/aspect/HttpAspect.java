package com.mongodb.aspect;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by Jason on 2018/1/25.
 */
@Aspect
@Component
public class HttpAspect
{
    /*@Before("execution(public * com.mongodb.controller.DemoController.findAll(..))")
    public void logbefore(){
        System.out.println("log:before");
    }

    @After("execution(public * com.mongodb.controller.DemoController.findAll(..))")
    public void logAfter(){
    System.out.println("log:after");
    }*/

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.mongodb.controller.DemoController.resave(..))")
    public void log(){
        System.out.println("log");//System.out.println("log") won't be done because of Pointcut!!
    }



    @Before("log()")
    public void logbefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url = {} ",request.getRequestURL());//Logger is used instead of  System.out.println!
        logger.info("method = {}",request.getMethod());
        logger.info("ip = {}",request.getRemoteAddr());
        logger.info("class_method = {}.{}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        logger.info("args = {},{}",joinPoint.getArgs(),"ss");//It will be display as one param if it likes "("args = {}",joinPoint.getArgs())"
    }

    @After("log()")//It will be done before @AfterReturning
    public void logAfter(){
        logger.info("log:after({})");//Logger is used instead of  System.out.println!
    }

    @AfterReturning(returning = "object",pointcut = "log()")//the "object" is object of "Object object" in the following
    public void logAfterRerturning(Object object){
        logger.info("reponse = {}",object.toString());
    }
}
