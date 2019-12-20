package com.sonam.chophel.helper;

/**
 * Created by N-Zepa on 17-Jun-18.
 */
public class ResponseMessage {
    //region private variables
    private Integer responseStatus;
    private String responseText;
    private String applicationNumber;
    private String rejectReason;
    private String serviceName;
    private Object responseDTO;

    //endregion
    public ResponseMessage() {

    }

    //region setters and getters

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

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
    //endregion
}
