package org.iscas.tj2.pyt.springboot_mybatis.domain;

import java.util.Date;

public class UserMessage {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column UserMessage.Id_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer idUsermessage;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column UserMessage.Id_User
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer idUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column UserMessage.TS_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Date tsUsermessage;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column UserMessage.Input_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String inputUsermessage;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column UserMessage.Output_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String outputUsermessage;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column UserMessage.State_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String stateUsermessage;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column UserMessage.Memo_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String memoUsermessage;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public UserMessage(Integer idUsermessage, Integer idUser, Date tsUsermessage, String inputUsermessage,
			String outputUsermessage, String stateUsermessage, String memoUsermessage) {
		this.idUsermessage = idUsermessage;
		this.idUser = idUser;
		this.tsUsermessage = tsUsermessage;
		this.inputUsermessage = inputUsermessage;
		this.outputUsermessage = outputUsermessage;
		this.stateUsermessage = stateUsermessage;
		this.memoUsermessage = memoUsermessage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public UserMessage() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column UserMessage.Id_UserMessage
	 * @return  the value of UserMessage.Id_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIdUsermessage() {
		return idUsermessage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column UserMessage.Id_UserMessage
	 * @param idUsermessage  the value for UserMessage.Id_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIdUsermessage(Integer idUsermessage) {
		this.idUsermessage = idUsermessage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column UserMessage.Id_User
	 * @return  the value of UserMessage.Id_User
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column UserMessage.Id_User
	 * @param idUser  the value for UserMessage.Id_User
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column UserMessage.TS_UserMessage
	 * @return  the value of UserMessage.TS_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Date getTsUsermessage() {
		return tsUsermessage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column UserMessage.TS_UserMessage
	 * @param tsUsermessage  the value for UserMessage.TS_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setTsUsermessage(Date tsUsermessage) {
		this.tsUsermessage = tsUsermessage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column UserMessage.Input_UserMessage
	 * @return  the value of UserMessage.Input_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getInputUsermessage() {
		return inputUsermessage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column UserMessage.Input_UserMessage
	 * @param inputUsermessage  the value for UserMessage.Input_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setInputUsermessage(String inputUsermessage) {
		this.inputUsermessage = inputUsermessage == null ? null : inputUsermessage.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column UserMessage.Output_UserMessage
	 * @return  the value of UserMessage.Output_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getOutputUsermessage() {
		return outputUsermessage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column UserMessage.Output_UserMessage
	 * @param outputUsermessage  the value for UserMessage.Output_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setOutputUsermessage(String outputUsermessage) {
		this.outputUsermessage = outputUsermessage == null ? null : outputUsermessage.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column UserMessage.State_UserMessage
	 * @return  the value of UserMessage.State_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getStateUsermessage() {
		return stateUsermessage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column UserMessage.State_UserMessage
	 * @param stateUsermessage  the value for UserMessage.State_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setStateUsermessage(String stateUsermessage) {
		this.stateUsermessage = stateUsermessage == null ? null : stateUsermessage.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column UserMessage.Memo_UserMessage
	 * @return  the value of UserMessage.Memo_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getMemoUsermessage() {
		return memoUsermessage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column UserMessage.Memo_UserMessage
	 * @param memoUsermessage  the value for UserMessage.Memo_UserMessage
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setMemoUsermessage(String memoUsermessage) {
		this.memoUsermessage = memoUsermessage == null ? null : memoUsermessage.trim();
	}
}