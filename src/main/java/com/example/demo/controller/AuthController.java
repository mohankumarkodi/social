package com.example.demo.controller;

import com.example.demo.Dto.GoogleTokenInfo;
import com.example.demo.common.GoogleTokenInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;


@RestController
public class AuthController {

    @Autowired
    private GoogleTokenInfoService tokenInfoService;

    @PostMapping("/tokeninfo")
    public String getTokenInfo(@RequestBody Map<String,String> idTokenObject) {
        String idToken = idTokenObject.get("token");
        System.out.println(idToken);
        try {
            tokenInfoService.getTokenInfo(idToken);
            return "login success......";
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Token verification failed.");
        }
    }

    @GetMapping("/login")
    public String loginCheck(){
        System.out.println("called login......................");
        return "home page";
    }
}
