package org.iscas.tj2.pyt.springboot_mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.iscas.tj2.pyt.springboot_mybatis.domain.Role;

public interface RoleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Role
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer idRole);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Role
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insert(Role record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Role
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insertSelective(Role record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Role
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	Role selectByPrimaryKey(Integer idRole);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Role
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKeySelective(Role record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Role
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKey(Role record);

	/**
	 * 自己加的
	 */
	//@Select("SELECT * FROM Role WHERE Id_Role = #{idRole,jdbcType=INTEGER}")
	Role selectByIdRole(@Param("idRole") Integer idRole);
}