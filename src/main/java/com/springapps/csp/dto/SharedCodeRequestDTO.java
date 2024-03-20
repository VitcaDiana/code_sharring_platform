package com.springapps.csp.dto;

public class SharedCodeRequestDTO {


    private String code;


    private Long viewTime;


    private Integer views;


    private boolean secret;




    public SharedCodeRequestDTO(String code, Long viewTime, Integer views, boolean secret) {
        this.code = code;
        this.viewTime = viewTime;
        this.views = views;
        this.secret = secret;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getViewTime() {
        return viewTime;
    }

    public void setViewTime(Long viewTime) {
        this.viewTime = viewTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }




}
