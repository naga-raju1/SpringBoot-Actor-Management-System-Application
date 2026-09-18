package com.spring.boot.ams.errorstructure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ErrorStructure<String>
{
    private int errorCode;
    private String errorMessage;
    private String error;
}
