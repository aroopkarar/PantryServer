package com.pantryadmin.DTO;

import java.io.Serializable;

public interface ResponseDTO<T> extends Serializable {

    static final long serialVersionUID = 1L;

    Integer getCode();

    T getData();

    String getMessage();

    Integer getStatus();

    void setCode(Integer code);

    void setData(T data);

    void setMessage(String message);

    void setStatus(Integer status);
}
