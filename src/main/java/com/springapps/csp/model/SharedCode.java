package com.springapps.csp.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class SharedCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private Long viewTime;

    @Column
    private Integer views;

    @Column
    private boolean secret;

    @Column
    private LocalDateTime createdDate;

    public SharedCode() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return secret ;
    }

    public void setSecret(boolean secret) {
        this.secret = views != 0 || viewTime != 0;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime cretedDate) {
        this.createdDate = cretedDate;
    }


}



    

