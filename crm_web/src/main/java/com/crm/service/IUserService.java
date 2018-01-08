package com.crm.service;

import com.crm.model.User;
import com.crm.utils.ResultInfo;

import java.util.List;

public interface IUserService {

    public ResultInfo userLogin(String userName,String userPwd);
    public List<User> queryAllCustomerManager();
}
