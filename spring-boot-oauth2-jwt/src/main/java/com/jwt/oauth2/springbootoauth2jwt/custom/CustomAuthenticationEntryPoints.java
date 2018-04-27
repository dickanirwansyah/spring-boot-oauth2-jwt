package com.jwt.oauth2.springbootoauth2jwt.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoints implements AuthenticationEntryPoint{

    private final Logger logActivity = LoggerFactory.getLogger(CustomAuthenticationEntryPoints.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException auth) throws IOException, ServletException {

            logActivity.debug("proses authenticating entry point");
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "ACCESS DENIED");
    }
}
