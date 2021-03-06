package org.iscas.tj2.pyt.springboot_mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.iscas.tj2.pyt.springboot_mybatis.domain.FuncStatement;

public interface FuncStatementMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FuncStatement
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer idFuncstatement);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FuncStatement
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insert(FuncStatement record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FuncStatement
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insertSelective(FuncStatement record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FuncStatement
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	FuncStatement selectByPrimaryKey(Integer idFuncstatement);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FuncStatement
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKeySelective(FuncStatement record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FuncStatement
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKey(FuncStatement record);

	//2018-12-04
	List<FuncStatement> selectFuncStatementsByFunctionId(@Param("IdFunction") int intFunctionId);
}