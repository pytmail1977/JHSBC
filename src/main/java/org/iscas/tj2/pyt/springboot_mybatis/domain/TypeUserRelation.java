package org.iscas.tj2.pyt.springboot_mybatis.domain;

public class TypeUserRelation {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TypeUserRelation.Id_TypeUserRelation
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private Integer idTypeuserrelation;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TypeUserRelation.Id_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private Integer idType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TypeUserRelation.Id_User
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private Integer idUser;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TypeUserRelation
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public TypeUserRelation(Integer idTypeuserrelation, Integer idType, Integer idUser) {
		this.idTypeuserrelation = idTypeuserrelation;
		this.idType = idType;
		this.idUser = idUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TypeUserRelation
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public TypeUserRelation() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TypeUserRelation.Id_TypeUserRelation
	 * @return  the value of TypeUserRelation.Id_TypeUserRelation
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Integer getIdTypeuserrelation() {
		return idTypeuserrelation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TypeUserRelation.Id_TypeUserRelation
	 * @param idTypeuserrelation  the value for TypeUserRelation.Id_TypeUserRelation
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setIdTypeuserrelation(Integer idTypeuserrelation) {
		this.idTypeuserrelation = idTypeuserrelation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TypeUserRelation.Id_Type
	 * @return  the value of TypeUserRelation.Id_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Integer getIdType() {
		return idType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TypeUserRelation.Id_Type
	 * @param idType  the value for TypeUserRelation.Id_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TypeUserRelation.Id_User
	 * @return  the value of TypeUserRelation.Id_User
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TypeUserRelation.Id_User
	 * @param idUser  the value for TypeUserRelation.Id_User
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
}