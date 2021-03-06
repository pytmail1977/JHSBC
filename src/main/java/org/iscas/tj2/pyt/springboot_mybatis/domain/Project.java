package org.iscas.tj2.pyt.springboot_mybatis.domain;

import java.util.Date;

public class Project {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.Id_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer idProject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.Name_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String nameProject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.Db_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String dbProject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.CreateDate_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Date createdateProject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.ModifyDate_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Date modifydateProject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.Version_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String versionProject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.Memo_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String memoProject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.Status_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer statusProject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.Opensource_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer opensourceProject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.Request_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String requestProject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Project.Copyright_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String copyrightProject;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Project(Integer idProject, String nameProject, String dbProject, Date createdateProject,
			Date modifydateProject, String versionProject, String memoProject, Integer statusProject,
			Integer opensourceProject, String requestProject, String copyrightProject) {
		this.idProject = idProject;
		this.nameProject = nameProject;
		this.dbProject = dbProject;
		this.createdateProject = createdateProject;
		this.modifydateProject = modifydateProject;
		this.versionProject = versionProject;
		this.memoProject = memoProject;
		this.statusProject = statusProject;
		this.opensourceProject = opensourceProject;
		this.requestProject = requestProject;
		this.copyrightProject = copyrightProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Project() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.Id_Project
	 * @return  the value of Project.Id_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIdProject() {
		return idProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.Id_Project
	 * @param idProject  the value for Project.Id_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.Name_Project
	 * @return  the value of Project.Name_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getNameProject() {
		return nameProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.Name_Project
	 * @param nameProject  the value for Project.Name_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setNameProject(String nameProject) {
		this.nameProject = nameProject == null ? null : nameProject.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.Db_Project
	 * @return  the value of Project.Db_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getDbProject() {
		return dbProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.Db_Project
	 * @param dbProject  the value for Project.Db_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setDbProject(String dbProject) {
		this.dbProject = dbProject == null ? null : dbProject.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.CreateDate_Project
	 * @return  the value of Project.CreateDate_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Date getCreatedateProject() {
		return createdateProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.CreateDate_Project
	 * @param createdateProject  the value for Project.CreateDate_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setCreatedateProject(Date createdateProject) {
		this.createdateProject = createdateProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.ModifyDate_Project
	 * @return  the value of Project.ModifyDate_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Date getModifydateProject() {
		return modifydateProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.ModifyDate_Project
	 * @param modifydateProject  the value for Project.ModifyDate_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setModifydateProject(Date modifydateProject) {
		this.modifydateProject = modifydateProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.Version_Project
	 * @return  the value of Project.Version_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getVersionProject() {
		return versionProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.Version_Project
	 * @param versionProject  the value for Project.Version_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setVersionProject(String versionProject) {
		this.versionProject = versionProject == null ? null : versionProject.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.Memo_Project
	 * @return  the value of Project.Memo_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getMemoProject() {
		return memoProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.Memo_Project
	 * @param memoProject  the value for Project.Memo_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setMemoProject(String memoProject) {
		this.memoProject = memoProject == null ? null : memoProject.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.Status_Project
	 * @return  the value of Project.Status_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getStatusProject() {
		return statusProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.Status_Project
	 * @param statusProject  the value for Project.Status_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setStatusProject(Integer statusProject) {
		this.statusProject = statusProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.Opensource_Project
	 * @return  the value of Project.Opensource_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getOpensourceProject() {
		return opensourceProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.Opensource_Project
	 * @param opensourceProject  the value for Project.Opensource_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setOpensourceProject(Integer opensourceProject) {
		this.opensourceProject = opensourceProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.Request_Project
	 * @return  the value of Project.Request_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getRequestProject() {
		return requestProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.Request_Project
	 * @param requestProject  the value for Project.Request_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setRequestProject(String requestProject) {
		this.requestProject = requestProject == null ? null : requestProject.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Project.Copyright_Project
	 * @return  the value of Project.Copyright_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getCopyrightProject() {
		return copyrightProject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Project.Copyright_Project
	 * @param copyrightProject  the value for Project.Copyright_Project
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setCopyrightProject(String copyrightProject) {
		this.copyrightProject = copyrightProject == null ? null : copyrightProject.trim();
	}
}