package com.crm.model;

import com.crm.utils.BaseQuery;

import java.util.Date;

public class CustomerOrder extends BaseQuery{
    /**
     * id
     * 
     */
    private Integer id;

    /**
     * cus_id
     * 
     */
    private Integer cusId;

    /**
     * order_no
     * 订单编号
     */
    private String orderNo;

    /**
     * order_date
     * 订单日期
     */
    private Date orderDate;

    /**
     * address
     * 地址
     */
    private String address;

    /**
     * state
     * 支付状态
     */
    private Integer state;

    /**
     * create_date
     * 创建时间
     */
    private Date createDate;

    /**
     * update_date
     * 更新时间
     */
    private Date updateDate;

    /**
     * is_valid
     * 是否删除
     */
    private Integer isValid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}