package com.okta.password_inline_hook.service.impl;

import com.okta.password_inline_hook.dto.McKessonRequest;
import com.okta.password_inline_hook.dto.McKessonResponse;
import com.okta.password_inline_hook.service.McKessonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class McKessonServiceImpl implements McKessonService {

    @Value("${mckesson.url}")
    private String url;
    @Value("${mckesson.auth.key}")
    private String authorizationKey;
    @Override
    public Boolean isAvailable(String username, String password) {
        url = url.replace("TEST",username);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(authorizationKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        McKessonRequest mcKessonRequest = new McKessonRequest();
        mcKessonRequest.setPassword(password);
        HttpEntity<McKessonRequest> request = new HttpEntity<>(mcKessonRequest,headers);
        ResponseEntity<McKessonResponse> response = restTemplate
                .exchange(url,HttpMethod.POST, request, McKessonResponse.class);

        return response.getBody().getSuccess();
    }
}
