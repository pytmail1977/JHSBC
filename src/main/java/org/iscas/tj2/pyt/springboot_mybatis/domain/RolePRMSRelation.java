package org.iscas.tj2.pyt.springboot_mybatis.domain;

public class RolePRMSRelation {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RolePRMSRelation.Id_RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer idRoleprmsrelation;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RolePRMSRelation.Id_Permission
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer idPermission;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RolePRMSRelation.Id_Role
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer idRole;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public RolePRMSRelation(Integer idRoleprmsrelation, Integer idPermission, Integer idRole) {
		this.idRoleprmsrelation = idRoleprmsrelation;
		this.idPermission = idPermission;
		this.idRole = idRole;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public RolePRMSRelation() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RolePRMSRelation.Id_RolePRMSRelation
	 * @return  the value of RolePRMSRelation.Id_RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIdRoleprmsrelation() {
		return idRoleprmsrelation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RolePRMSRelation.Id_RolePRMSRelation
	 * @param idRoleprmsrelation  the value for RolePRMSRelation.Id_RolePRMSRelation
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIdRoleprmsrelation(Integer idRoleprmsrelation) {
		this.idRoleprmsrelation = idRoleprmsrelation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RolePRMSRelation.Id_Permission
	 * @return  the value of RolePRMSRelation.Id_Permission
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIdPermission() {
		return idPermission;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RolePRMSRelation.Id_Permission
	 * @param idPermission  the value for RolePRMSRelation.Id_Permission
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIdPermission(Integer idPermission) {
		this.idPermission = idPermission;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RolePRMSRelation.Id_Role
	 * @return  the value of RolePRMSRelation.Id_Role
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIdRole() {
		return idRole;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RolePRMSRelation.Id_Role
	 * @param idRole  the value for RolePRMSRelation.Id_Role
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
}