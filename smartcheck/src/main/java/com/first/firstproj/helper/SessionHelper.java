package com.first.firstproj.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
// import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {
    public void removeMessageFromSession(){
        try {
            HttpSession s = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            s.removeAttribute("message");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
