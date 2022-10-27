package com.okta.password_inline_hook.controller;

import com.okta.password_inline_hook.dto.OktaRequest;
import com.okta.password_inline_hook.dto.OktaResponse;
import com.okta.password_inline_hook.service.PasswordInlineHookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCredentialsController {

    @Autowired
    private PasswordInlineHookService passwordInlineHookService;

    @PostMapping("/passwordImport")
    public OktaResponse comparePassword(@RequestBody OktaRequest oktaRequest){
        return this.passwordInlineHookService.checkCredentials(oktaRequest);
    }
}
