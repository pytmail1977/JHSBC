package org.iscas.tj2.pyt.springboot_mybatis.domain;

public class UserRoleRelation {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column UserRoleRelation.Id_UserRoleRelation
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private Integer idUserrolerelation;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column UserRoleRelation.Id_Role
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private Integer idRole;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column UserRoleRelation.Id_User
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private Integer idUser;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table UserRoleRelation
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public UserRoleRelation(Integer idUserrolerelation, Integer idRole, Integer idUser) {
		this.idUserrolerelation = idUserrolerelation;
		this.idRole = idRole;
		this.idUser = idUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table UserRoleRelation
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public UserRoleRelation() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column UserRoleRelation.Id_UserRoleRelation
	 * @return  the value of UserRoleRelation.Id_UserRoleRelation
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Integer getIdUserrolerelation() {
		return idUserrolerelation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column UserRoleRelation.Id_UserRoleRelation
	 * @param idUserrolerelation  the value for UserRoleRelation.Id_UserRoleRelation
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setIdUserrolerelation(Integer idUserrolerelation) {
		this.idUserrolerelation = idUserrolerelation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column UserRoleRelation.Id_Role
	 * @return  the value of UserRoleRelation.Id_Role
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Integer getIdRole() {
		return idRole;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column UserRoleRelation.Id_Role
	 * @param idRole  the value for UserRoleRelation.Id_Role
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column UserRoleRelation.Id_User
	 * @return  the value of UserRoleRelation.Id_User
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column UserRoleRelation.Id_User
	 * @param idUser  the value for UserRoleRelation.Id_User
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
}