package com.test.csv.dto;

import java.util.List;

public class TopFormDto {

    private String form_id;

    public TopFormDto() {
    }

    public TopFormDto(String form_id) {
        this.form_id = form_id;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }
}
