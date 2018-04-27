package org.cheng.exception;

import org.cheng.pojo.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cheng
 *         2018/4/27 10:24
 */
@SuppressWarnings("ALL")
@ControllerAdvice
public class ErrExceptionHandler {

    public static final String ERROR_VIEW = "error";

    /*@ExceptionHandler(Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

        e.printStackTrace();

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(ERROR_VIEW);

        return mav;
    }*/

    @ExceptionHandler(Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

        e.printStackTrace();

        if (isAjax(request)) {
            // ajax 请求错误处理
            return JSONResult.errorException(e.getMessage());
        } else {
            // web 请求错误处理
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(ERROR_VIEW);

            return mav;
        }
    }

    /**
     * 判断是否是 ajax 请求
     *
     * @param request
     * @return
     */
    private boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With")));
    }
}
