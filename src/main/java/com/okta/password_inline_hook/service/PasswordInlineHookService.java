package com.okta.password_inline_hook.service;

import com.okta.password_inline_hook.dto.OktaRequest;
import com.okta.password_inline_hook.dto.OktaResponse;

public interface PasswordInlineHookService {
    OktaResponse checkCredentials(OktaRequest oktaRequest);
}
