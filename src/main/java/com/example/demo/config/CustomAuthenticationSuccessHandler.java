package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.setContentType("application/json");
//
//        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
//
//        PrintWriter writer = response.getWriter();
//        String result = mapper.writeValueAsString(modelMapper.map(CmmLoginHelper.getUser(), UserDto.Response.class));
//        log.debug("HEADER : {}", response.getHeaderNames());
//        log.debug("LOGIN SUCCESS : {}", request);
//        writer.append(result);
//        writer.flush();

        clearAuthenticationAttributes(request);
    }
}
