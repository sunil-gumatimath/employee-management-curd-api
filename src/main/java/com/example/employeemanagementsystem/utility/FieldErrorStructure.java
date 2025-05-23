package com.example.employeemanagementsystem.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FieldErrorStructure<T> {

    private int statusCode;

    @JsonProperty("error_message")
    private String errorMessage;

    T data;
}
