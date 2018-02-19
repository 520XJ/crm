package com.crm.model;

import com.crm.framework.constant.CrmConstant;
import com.crm.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CustomerServe extends BaseModel{
    /**
     * id
     * id
     */
    private Integer id;

    /**
     * serve_type
     * 服务类型
     */
    private String serveType;

    /**
     * overview
     * 概要
     */
    private String overview;

    /**
     * customer
     * 客户
     */
    private String customer;

    /**
     * state
     * 状态（0未分配 1已分配）
     */
    private String state;

    /**
     * service_request
     * 服务请求
     */
    private String serviceRequest;

    /**
     * create_people
     * 创建人
     */
    private String createPeople;

    /**
     * assigner
     * 分配人
     */
    private String assigner;

    /**
     * assign_time
     * 分配时间
     */
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    private Date assignTime;

    /**
     * service_proce
     * 处理内容
     */
    private String serviceProce;

    /**
     * service_proce_people
     * 
     */
    private String serviceProcePeople;

    /**
     * service_proce_time
     * 
     */
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    private Date serviceProceTime;

    /**
     * service_proce_result
     * 
     */
    private String serviceProceResult;

    /**
     * myd
     * 等级
     */
    private String myd;

    /**
     * is_valid
     * 是否删除
     */
    private Integer isValid;

    /**
     * update_date
     * 更新时间
     */
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    private Date updateDate;

    /**
     * create_date
     * 创建时间
     */
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServeType() {
        return serveType;
    }

    public void setServeType(String serveType) {
        this.serveType = serveType;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(String serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public String getCreatePeople() {
        return createPeople;
    }

    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople;
    }

    public String getAssigner() {
        return assigner;
    }

    public void setAssigner(String assigner) {
        this.assigner = assigner;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public String getServiceProce() {
        return serviceProce;
    }

    public void setServiceProce(String serviceProce) {
        this.serviceProce = serviceProce;
    }

    public String getServiceProcePeople() {
        return serviceProcePeople;
    }

    public void setServiceProcePeople(String serviceProcePeople) {
        this.serviceProcePeople = serviceProcePeople;
    }

    public Date getServiceProceTime() {
        return serviceProceTime;
    }

    public void setServiceProceTime(Date serviceProceTime) {
        this.serviceProceTime = serviceProceTime;
    }

    public String getServiceProceResult() {
        return serviceProceResult;
    }

    public void setServiceProceResult(String serviceProceResult) {
        this.serviceProceResult = serviceProceResult;
    }

    public String getMyd() {
        return myd;
    }

    public void setMyd(String myd) {
        this.myd = myd;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}