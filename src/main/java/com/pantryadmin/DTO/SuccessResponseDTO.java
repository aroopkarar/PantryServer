package com.pantryadmin.DTO;

import com.pantryadmin.Constants.ApplicationConstant;

public class SuccessResponseDTO<T> implements ResponseDTO<T> {
    private Integer code = ApplicationConstant.HTTP_RESPONSE_SUCCESS_CODE;
    private Integer status = ApplicationConstant.SUCCESS_STATUS_CODE;
    private String message = "";
    private String nextCursor = "";
    private T data;

    public String getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
    }

    public SuccessResponseDTO() {
    }

    public SuccessResponseDTO(T data) {
        this.data = data;
    }

    public SuccessResponseDTO(T data2, String message2) {
        this.data = data2;
        this.message = message2;
    }

    public SuccessResponseDTO(T data2, String message2, Integer status) {
        this(data2, message2);
        this.status = status;
    }

    public SuccessResponseDTO(Integer status) {
        this.status = status;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SuccessResponseDTO{" +
                "code=" + code +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", nextCursor='" + nextCursor + '\'' +
                ", data=" + data +
                '}';
    }
}
