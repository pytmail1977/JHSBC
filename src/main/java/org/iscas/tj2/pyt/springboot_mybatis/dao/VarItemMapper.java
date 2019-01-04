package org.iscas.tj2.pyt.springboot_mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.iscas.tj2.pyt.springboot_mybatis.domain.VarItem;

public interface VarItemMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table VarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer idVaritem);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table VarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insert(VarItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table VarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insertSelective(VarItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table VarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	VarItem selectByPrimaryKey(Integer idVaritem);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table VarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKeySelective(VarItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table VarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKey(VarItem record);

	//2018-12-04 新增
	List<VarItem> selectVarItemsByVarId(@Param("IdVar") int intVarId);
}