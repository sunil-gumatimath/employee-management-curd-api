package com.example.employeemanagementsystem.utility;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorStructure<T> {
    private String type;
    private int status;
    private String message;

}
