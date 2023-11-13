package com.example.OurHome.model.Entity.dto;

import org.hibernate.validator.constraints.Length;

public class UserAuthBindingModel {
    @Length(min = 8, max = 8, message = "Please enter a valid Residential ID")
    private String residentialId;

     public String getResidentialId() {
        return residentialId;
    }

    public void setResidentialId(String residentialId) {
        this.residentialId = residentialId;
    }

    public Long parseResidentialIdToLong() {
        String rowInput = this.getResidentialId();
        for (int i = 0; i < rowInput.length(); i++) {
            if (!Character.isDigit(rowInput.charAt(i)))
                return null;
        }
        return Long.valueOf(rowInput);
    }
}
