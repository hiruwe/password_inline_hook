package com.okta.password_inline_hook.dto;

import lombok.Data;

@Data
public class Command {
    private String type;
    private Value value;
}
