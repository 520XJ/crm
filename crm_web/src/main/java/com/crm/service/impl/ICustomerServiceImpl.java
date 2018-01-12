package com.crm.service.impl;

import com.crm.dao.CustomerDao;
import com.crm.dao.CustomerOrderDao;
import com.crm.dao.DatadicDao;
import com.crm.model.Customer;
import com.crm.model.CustomerOrder;
import com.crm.model.Datadic;
import com.crm.service.ICustomerService;
import com.crm.utils.MathUtil;
import com.crm.utils.ResultInfo;
import com.crm.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ICustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private DatadicDao datadicDao;

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Override
    public List<Customer> queryAllCustomers() {

        Map<String,Object> map = new HashMap<>();
        map.put("isValid", 1);
        List<Customer> customers = customerDao.find(map);

        return customers;
    }

    @Override
    public Map<String, Object> queryCustomersByParams(Customer customer) {
        //分页
        PageHelper.startPage(customer.getPage(), customer.getRows());

        Map<String, Object> param = new HashMap<>();

        if(StringUtil.isNotEmpty(customer.getKhno())){
            param.put("khno", customer.getKhno());
        }

        if (StringUtil.isNotEmpty(customer.getName())) {
            param.put("name", customer.getName());
        }
        param.put("isValid", 1);

        List<Customer> customers = customerDao.find(param);

        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        Map<String ,Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());

        return map;
    }

    @Override
    public List<Datadic> queryDataDicValueByDataDicName(String dataDicName) {
        Map<String, Object> map = new HashMap<>();
        map.put("isValid",1);
        map.put("dataDicName", dataDicName);
        List<Datadic> datadics = datadicDao.find(map);
        Iterator<Datadic> iterator = datadics.iterator();

        List<Datadic> list = new ArrayList<>();

        while (iterator.hasNext()) {
            Datadic datadic = iterator.next();
            list.add(datadic);
        }

        return list;
    }

    @Transactional
    @Override
    public ResultInfo insertCustomer(Customer customer) {

        ResultInfo resultInfo = new ResultInfo();

        customer.setKhno(MathUtil.genereateKhCode()); //生成客户编号
        customer.setIsValid(1);
        customer.setCreateDate(new Date());
        customer.setUpdateDate(new Date());

        long saveSte = customerDao.saveSte(customer);
        if (saveSte != 1) {
            resultInfo.setCode(500);
            resultInfo.setMsg("添加失败");
        }

        return resultInfo;
    }

    @Transactional
    @Override
    public ResultInfo updateCustomer(Customer customer) {
        ResultInfo resultInfo = new ResultInfo();

        customer.setUpdateDate(new Date());
        long updateSte = customerDao.updateSte(customer);
        if (updateSte != 1) {
            resultInfo.setMsg("更新失败");
            resultInfo.setCode(500);
        }

        return resultInfo;
    }

    @Transactional
    @Override
    public ResultInfo deleteCustomerById(Integer[] ids) {

        ResultInfo resultInfo = new ResultInfo();

        int conut = 0;
        if(ids.length<1){
            resultInfo.setCode(500);
            resultInfo.setMsg("未选中记录");
            return resultInfo;
        }
        Customer customer = null;

        for(int i = 0;i<ids.length;i++){
            customer = new Customer();
            customer.setUpdateDate(new Date());
            customer.setIsValid(0);
            customer.setId(ids[i]);

            long updateSte = customerDao.updateSte(customer);
            conut += updateSte;
        }

        if (conut != ids.length) {
            resultInfo.setMsg("删除失败");
            resultInfo.setCode(500);
        }

        return resultInfo;
    }

    @Override
    public Customer queryCustomerById(Integer id) {
        Customer customer = customerDao.get(id);
        return customer;
    }
}
