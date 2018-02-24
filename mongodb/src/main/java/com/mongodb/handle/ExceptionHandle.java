package com.mongodb.handle;

import com.mongodb.domain.Result;
import com.mongodb.exception.DemoException;
import com.mongodb.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jason on 2018/1/26.
 */
@ControllerAdvice  //It makes all Exception in RequestMapping work as the following handle
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof DemoException){
            DemoException demoException = (DemoException) e;
            return ResultUtil.error(demoException.getCode(),demoException.getMessage());
        }else {
            logger.info("exception is {}",e);
            return ResultUtil.error(-1,"unknown error");
        }
    }
}
