package org.iscas.tj2.pyt.springboot_mybatis.dao;

import org.iscas.tj2.pyt.springboot_mybatis.domain.UserMessage;

public interface UserMessageMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer idUsermessage);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insert(UserMessage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int insertSelective(UserMessage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	UserMessage selectByPrimaryKey(Integer idUsermessage);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKeySelective(UserMessage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	int updateByPrimaryKey(UserMessage record);
}