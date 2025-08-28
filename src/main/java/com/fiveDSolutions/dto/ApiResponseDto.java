package com.fiveDSolutions.dto;

import com.fiveDSolutions.constants.EOperationStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiResponseDto<T>
{
    private String message;
    private EOperationStatus status;
    private T data;

}
