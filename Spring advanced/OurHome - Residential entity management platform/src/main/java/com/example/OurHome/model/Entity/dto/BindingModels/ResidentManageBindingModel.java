package com.example.OurHome.model.Entity.dto.BindingModels;

public class ResidentManageBindingModel {

    private Long userId;
    private Long entityId;
    private String action;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
