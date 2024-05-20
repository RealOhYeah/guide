package com.gsxy.guide.intercept;

import com.gsxy.guide.utils.JwtUtil;
import com.gsxy.guide.utils.ThreadLocalUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.err.println("hello");
        StringBuffer requestURL = request.getRequestURL();
//        System.err.println(requestURL);

        //白名单
        if (
                requestURL.toString().endsWith("/user/login")||
                        requestURL.toString().endsWith("/user/userReg")
        ) {
            return true;
        }

        String authorizationHeader = null;

        try {
            authorizationHeader = request.getHeader("Authorization");
        } catch (Exception e) {
            String errorMessage = "{\"error\": \"Unauthorized\", \"message\": \"身份验证过期\"}";
            sendErrorResponse(response, errorMessage, HttpStatus.UNAUTHORIZED);
            return false;
        }

        try {
            Map<String, Object> userInfo = JwtUtil.analysis(authorizationHeader);
            if (userInfo == null){
                String errorMessage = "{\"error\": \"Unauthorized\", \"message\": \"身份验证过期\"}";
                sendErrorResponse(response, errorMessage, HttpStatus.UNAUTHORIZED);
                return false;
            }
            ThreadLocalUtil.mapThreadLocalOfJWT.get().put("userInfo",userInfo);
        } catch (Exception e) {
            String errorMessage = "{\"error\": \"Unauthorized\", \"message\": \"身份验证过期\"}";
            sendErrorResponse(response, errorMessage, HttpStatus.UNAUTHORIZED);
            return false;
        }

        return true;
    }


    private void sendErrorResponse(HttpServletResponse response, String errorMessage, HttpStatus status) throws IOException, IOException {
        response.setStatus(status.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getOutputStream().write(errorMessage.getBytes("UTF-8"));
        response.getOutputStream().flush();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在请求处理之后调用，可以进行后置处理
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在请求完成之后调用，可以进行最终的清理工作
    }
}
