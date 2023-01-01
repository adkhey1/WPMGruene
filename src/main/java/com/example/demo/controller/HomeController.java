package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping( "/login/oauth2/code/azure" )
    public String home() {
        return String.format( "Hello welcome to the Security app");
    }

    @GetMapping( "/myProfile" )
    public String profile() {
        return "myProfile";
    }

    @GetMapping( "/dashboard" )
    public String dashboard() {
        return "dashboard";
    }

}
