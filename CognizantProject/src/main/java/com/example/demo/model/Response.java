package com.example.demo.model;

public class Response {
    private String msg;
    private boolean status;
    public Response() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Response(String msg, boolean status) {
        super();
        this.msg = msg;
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    
}