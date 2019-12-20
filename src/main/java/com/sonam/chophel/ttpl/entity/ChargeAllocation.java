package com.sonam.chophel.ttpl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by USER on 9/5/2019.
 */
@Entity
@Table(name = "t_service_charge")
public class ChargeAllocation {
    //region private variables
    @Id
    @Column(name = "SERVICE_CHARGE_ID")
    private Integer serviceChargeId;

    @Column(name = "SERVICE_SL_NO")
    private Integer serviceId;

    @Column(name = "DOCUMENT_ID")
    private Integer documentId;

    @Column(name = "CHARGE_AMOUNT")
    private Integer chargeAmount;

    @Column(name = "IS_ACTIVE")
    private String statusTag;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    //endregion
}
