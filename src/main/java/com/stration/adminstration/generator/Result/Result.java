package com.stration.adminstration.generator.Result;

public class Result {
    private Integer code;
    private String message;
    private Object rows;
    private Long total;

    public Result(Integer code, String message, Object rows, Long total) {
        this.code = code;
        this.message = message;
        this.rows = rows;
        this.total = total;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, Object rows) {
        this.code = code;
        this.rows = rows;
    }

    public Result(Integer code, String message, Object rows) {
        this.code = code;
        this.message = message;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getrows() {
        return rows;
    }

    public void setrows(Object rows) {
        this.rows = rows;
    }
}
