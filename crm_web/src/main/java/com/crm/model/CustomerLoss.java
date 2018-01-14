package com.crm.model;

import com.crm.utils.BaseQuery;

import java.util.Date;

public class CustomerLoss extends BaseQuery{
    /**
     * id
     * 
     */
    private Integer id;

    /**
     * cus_no
     * 
     */
    private String cusNo;

    /**
     * cus_name
     * 
     */
    private String cusName;

    /**
     * cus_manager
     * 
     */
    private String cusManager;

    /**
     * last_order_time
     * 
     */
    private Date lastOrderTime;

    /**
     * confirm_loss_time
     * 
     */
    private Date confirmLossTime;

    /**
     * state
     * 
     */
    private Integer state;

    /**
     * loss_reason
     * 
     */
    private String lossReason;

    /**
     * is_valid
     * 
     */
    private Integer isValid;

    /**
     * create_date
     * 
     */
    private Date createDate;

    /**
     * update_date
     * 
     */
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusManager() {
        return cusManager;
    }

    public void setCusManager(String cusManager) {
        this.cusManager = cusManager;
    }

    public Date getLastOrderTime() {
        return lastOrderTime;
    }

    public void setLastOrderTime(Date lastOrderTime) {
        this.lastOrderTime = lastOrderTime;
    }

    public Date getConfirmLossTime() {
        return confirmLossTime;
    }

    public void setConfirmLossTime(Date confirmLossTime) {
        this.confirmLossTime = confirmLossTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLossReason() {
        return lossReason;
    }

    public void setLossReason(String lossReason) {
        this.lossReason = lossReason;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}