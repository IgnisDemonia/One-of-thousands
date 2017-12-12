package com.skobelsky.onemanagerofthousands.dto;

import java.util.Date;

/**
 * Created by Skobelsky on 10.12.2017.
 */

public class RememberDTO {
    String id;
    String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRememberDate() {
        return rememberDate;
    }

    public void setRememberDate(Date rememberDate) {
        this.rememberDate = rememberDate;
    }

    Date rememberDate;

    public RememberDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    RememberDTO(String title) {
        this.title = title;
    }
}
