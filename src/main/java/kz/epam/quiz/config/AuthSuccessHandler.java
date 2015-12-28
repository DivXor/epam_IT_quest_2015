package kz.epam.quiz.config;

import static kz.epam.quiz.entity.enums.UserRoleEnum.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        String targetUrl = "";

        if(role.contains(ADMIN.name())) {
            targetUrl = "/admin";
        } else if(role.contains(USER.name())) {
            targetUrl = "/task";
        }
        return targetUrl;
    }

}