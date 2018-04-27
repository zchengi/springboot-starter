package org.cheng.exception;

import org.cheng.pojo.JSONResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cheng
 *         2018/4/27 10:34
 */
//@RestControllerAdvice
public class AjaxExceptionHandler {

    // @ExceptionHandler(Exception.class)
    public JSONResult defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

        e.printStackTrace();

        return JSONResult.errorException(e.getMessage());
    }
}
