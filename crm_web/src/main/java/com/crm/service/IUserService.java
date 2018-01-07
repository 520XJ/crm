package com.crm.service;

import com.crm.utils.ResultInfo;

public interface IUserService {

    public ResultInfo userLogin(String userName,String userPwd);
}
