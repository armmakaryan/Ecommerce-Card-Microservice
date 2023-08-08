//package com.smartcode.wallet.configuration;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@Slf4j
//@Component
//public class JwtAuthEntryPoint implements AuthentificationEntryPoiny {
//
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response,
//                         AuthenticationException authException) throws IOException {
//        log.error(request.getMethod() + " / " + request.getRequestURI() + " - " + authException.getMessage());
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
//    }
//
//}