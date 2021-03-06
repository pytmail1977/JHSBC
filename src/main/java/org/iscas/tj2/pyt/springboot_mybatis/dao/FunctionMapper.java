package org.iscas.tj2.pyt.springboot_mybatis.dao;

import org.iscas.tj2.pyt.springboot_mybatis.domain.Function;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FunctionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Function
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer idFunction);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Function
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insert(Function record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Function
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insertSelective(Function record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Function
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	Function selectByPrimaryKey(Integer idFunction);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Function
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKeySelective(Function record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Function
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKey(Function record);

	//2018-12-03
	List<Function> selectFunctionsByProjectId(@Param("IdProject") int intProjectId);
}