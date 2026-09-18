package com.spring.boot.ams.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ActorNotFoundByNameException extends RuntimeException
{
    private String message;
}
