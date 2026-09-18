package com.spring.boot.ams.responsestructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructure<Actor>
{
    private int statusCode;
    private String message;
    private Actor data;
}
