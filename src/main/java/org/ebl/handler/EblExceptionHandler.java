package org.ebl.handler;

import org.ebl.domain.Result;
import org.ebl.exception.EblException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yeli on 06/07/2017.
 */
@ControllerAdvice
public class EblExceptionHandler {

    @ExceptionHandler(value = EblException.class)
    @ResponseBody
    public Result handleEblException(EblException e){
        return Result.buildFailResult(e.toString(), "");
    }

}
