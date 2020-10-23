//package com.example.demo.error;
//
//import org.springframework.boot.web.server.ErrorPage;
//import org.springframework.boot.web.server.ErrorPageRegistrar;
//import org.springframework.boot.web.server.ErrorPageRegistry;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ErrorConfig implements ErrorPageRegistrar {
//    @Override
//    public void registerErrorPages (ErrorPageRegistry errorPageRegistry){
//        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
//        errorPageRegistry.addErrorPages(errorPage404);
//    }
//}
