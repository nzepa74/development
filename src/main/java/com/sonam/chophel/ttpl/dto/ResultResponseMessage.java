package com.sonam.chophel.ttpl.dto;

/**
 * Created by USER on 8/22/2019.
 */
public class ResultResponseMessage {
    private Integer responseStatus;
    private String responseText;
    private Object responseDTO;

    //endregion
    public ResultResponseMessage() {

    }

    public Integer getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Object getResponseDTO() {
        return responseDTO;
    }

    public void setResponseDTO(Object responseDTO) {
        this.responseDTO = responseDTO;
    }
}
