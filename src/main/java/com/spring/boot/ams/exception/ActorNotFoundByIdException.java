package com.spring.boot.ams.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ActorNotFoundByIdException extends RuntimeException{
    private String message;
}
