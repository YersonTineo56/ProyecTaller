package com.TallerYei.MicroserviciosHospedaje.dto;

public class ApiResponse<T> {

    private T data;
    private String error;

    public ApiResponse(T data, String error) {
        this.data = data;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }
}
