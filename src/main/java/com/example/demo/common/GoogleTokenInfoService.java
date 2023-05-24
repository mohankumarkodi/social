package com.example.demo.common;

import com.example.demo.Dto.GoogleTokenInfo;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class GoogleTokenInfoService {

    private static final String CLIENT_ID = "936618328047-2vmra77lq4c1lavac1uqi6f8vmmc5p90.apps.googleusercontent.com"; // Replace with your actual client ID

    public GoogleTokenInfo getTokenInfo(String idToken) throws GeneralSecurityException, IOException {
        JsonFactory jsonFactory = new JacksonFactory();
        NetHttpTransport httpTransport = new NetHttpTransport();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(httpTransport, jsonFactory)
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();

        GoogleIdToken token = verifier.verify(idToken);
        if (token != null) {
            GoogleTokenInfo tokenInfo = new GoogleTokenInfo();
            tokenInfo.setAud(token.getPayload().getAudience().toString());
            tokenInfo.setSub(token.getPayload().getSubject());
            tokenInfo.setEmail(token.getPayload().getEmail());
            System.out.println(token.getPayload().getEmailVerified());
            return tokenInfo;
        } else {
            throw new IllegalArgumentException("Invalid token.");
        }
    }
}
