package org.iscas.tj2.pyt.springboot_mybatis.dao;

import org.iscas.tj2.pyt.springboot_mybatis.domain.RolePRMSRelation;

public interface RolePRMSRelationMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer idRoleprmsrelation);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insert(RolePRMSRelation record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insertSelective(RolePRMSRelation record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	RolePRMSRelation selectByPrimaryKey(Integer idRoleprmsrelation);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKeySelective(RolePRMSRelation record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKey(RolePRMSRelation record);
}