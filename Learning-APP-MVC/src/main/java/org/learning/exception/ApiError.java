package org.learning.exception;

import java.util.Date;

class ApiError {
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Integer errorCode;
    private String errorDescription;
    private Date date;

    public ApiError(Integer errorCode, String errorDescription, Date date) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.date = date;
    }
}