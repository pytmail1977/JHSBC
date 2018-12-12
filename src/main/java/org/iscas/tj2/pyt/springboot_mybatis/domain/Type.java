package org.iscas.tj2.pyt.springboot_mybatis.domain;

public class Type {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Type.Id_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private Integer idType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Type.IsSample_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private String issampleType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Type.Id_Struct
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private Integer idStruct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Type.SampleType_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private String sampletypeType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Type.Id_NameSpace_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private Integer idNamespaceType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Type.Name_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private String nameType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Type.Memo_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	private String memoType;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Type(Integer idType, String issampleType, Integer idStruct, String sampletypeType, Integer idNamespaceType,
			String nameType, String memoType) {
		this.idType = idType;
		this.issampleType = issampleType;
		this.idStruct = idStruct;
		this.sampletypeType = sampletypeType;
		this.idNamespaceType = idNamespaceType;
		this.nameType = nameType;
		this.memoType = memoType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Type() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Type.Id_Type
	 * @return  the value of Type.Id_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Integer getIdType() {
		return idType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Type.Id_Type
	 * @param idType  the value for Type.Id_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Type.IsSample_Type
	 * @return  the value of Type.IsSample_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public String getIssampleType() {
		return issampleType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Type.IsSample_Type
	 * @param issampleType  the value for Type.IsSample_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setIssampleType(String issampleType) {
		this.issampleType = issampleType == null ? null : issampleType.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Type.Id_Struct
	 * @return  the value of Type.Id_Struct
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Integer getIdStruct() {
		return idStruct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Type.Id_Struct
	 * @param idStruct  the value for Type.Id_Struct
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setIdStruct(Integer idStruct) {
		this.idStruct = idStruct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Type.SampleType_Type
	 * @return  the value of Type.SampleType_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public String getSampletypeType() {
		return sampletypeType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Type.SampleType_Type
	 * @param sampletypeType  the value for Type.SampleType_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setSampletypeType(String sampletypeType) {
		this.sampletypeType = sampletypeType == null ? null : sampletypeType.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Type.Id_NameSpace_Type
	 * @return  the value of Type.Id_NameSpace_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public Integer getIdNamespaceType() {
		return idNamespaceType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Type.Id_NameSpace_Type
	 * @param idNamespaceType  the value for Type.Id_NameSpace_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setIdNamespaceType(Integer idNamespaceType) {
		this.idNamespaceType = idNamespaceType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Type.Name_Type
	 * @return  the value of Type.Name_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public String getNameType() {
		return nameType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Type.Name_Type
	 * @param nameType  the value for Type.Name_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setNameType(String nameType) {
		this.nameType = nameType == null ? null : nameType.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Type.Memo_Type
	 * @return  the value of Type.Memo_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public String getMemoType() {
		return memoType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Type.Memo_Type
	 * @param memoType  the value for Type.Memo_Type
	 * @mbg.generated  Mon Dec 03 18:53:01 CST 2018
	 */
	public void setMemoType(String memoType) {
		this.memoType = memoType == null ? null : memoType.trim();
	}
}