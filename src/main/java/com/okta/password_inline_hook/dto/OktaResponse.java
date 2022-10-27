package com.okta.password_inline_hook.dto;

import lombok.Data;

import java.util.List;

@Data
public class OktaResponse {
    private List<Command> commands;
}
