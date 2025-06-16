package com.pooji.user.service.UserService.payload;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class ApiResponse {

    private String message;
    private boolean success;
    public HttpStatus status;
}
