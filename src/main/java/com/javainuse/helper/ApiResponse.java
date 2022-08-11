package com.javainuse.helper;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Md. Emran Hossain
 * @since 11 Aug, 2022
 * @version 1.1
 */
@Getter @Setter
public class ApiResponse {

    private Boolean success;
    private String message;
    private Object data;
    private Long count;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(Boolean success, String message, Object data, Long count) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(){}

}
