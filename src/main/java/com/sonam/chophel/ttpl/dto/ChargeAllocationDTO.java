package com.sonam.chophel.ttpl.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by USER on 9/5/2019.
 */
public class ChargeAllocationDTO {

    //region private variables
    private Integer serviceChargeId;

    private Integer serviceId;

    private Integer documentId;

    @NotNull(message = "Charges (Nu) is required.")
    private Integer chargeAmount;

    private String statusTag;

    private String statusTagName;
    private String serviceName;
    private String documentName;

    //endregion

    //region setters and getters

    public Integer getServiceChargeId() {
        return serviceChargeId;
    }

    public void setServiceChargeId(Integer serviceChargeId) {
        this.serviceChargeId = serviceChargeId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Integer getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Integer chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public String getStatusTag() {
        return statusTag;
    }

    public void setStatusTag(String statusTag) {
        this.statusTag = statusTag;
    }

    public String getStatusTagName() {
        return statusTagName;
    }

    public void setStatusTagName(String statusTagName) {
        this.statusTagName = statusTagName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    //endregion
}
