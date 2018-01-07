package com.crm.utils;

import java.util.List;


import java.util.Map;
/**
 * 基础到dao层
 * @author Mr.YongGan.Zhang
 *       数据库中的各种操作
 * @param <K> 主键
 * @param <E> model
 */
public interface BaseDao<K, E> {

	/**
	 *  通过id 删除
	 * @param id
	 * @return
	 */
	long delete(K id);

	/**
	 *    保存所有     不论是否为空
	 * @param record
	 * @return
	 */
	long save(E record);

	/**
	 * 只保存非空字段   添加
	 * 
	 * @param record
	 * @return
	 */
	long saveSte(E record);

	/**
	 *   通过id  查询所有字段
	 * @param id
	 * @return
	 */
	E get(K id);

	/**
	 * 只更新非空字段
	 * 
	 * @param record
	 * @return
	 */
	long updateSte(E record);

	/**
	 * 所有都更新
	 * @param record
	 * @return
	 */
	long update(E record);

	/**
	 *    查询1张表有多少条数据    条数总和
	 * @param param
	 * @return
	 */
	long count(Object param);

	/**
	 * 有多个符合条件的 全都要
	 */
	List<E> find(Map<String, Object> param);

	/**
	 * 有多个符合条件的也只取第一个
	 * 
	 * @param param
	 * @return
	 */
	E findOne(Map<String, Object> param);
}
