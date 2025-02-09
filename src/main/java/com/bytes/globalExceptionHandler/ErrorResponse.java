package com.bytes.globalExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private String message;
    private String errorCode;
    private String errorDetails;

    // Builder will automatically use this default value
    @Builder.Default
    private LocalDateTime timeStamp = LocalDateTime.now();
}
