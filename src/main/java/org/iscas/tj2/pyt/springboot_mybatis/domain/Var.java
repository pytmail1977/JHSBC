package org.iscas.tj2.pyt.springboot_mybatis.domain;

public class Var {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Var.Id_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer idVar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Var.Id_Type
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer idType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Var.Name_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String nameVar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Var.Memo_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String memoVar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Var.IfConst_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer ifconstVar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Var.Value_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String valueVar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Var.IfStatic_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer ifstaticVar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Var.Blist_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String blistVar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Var.Wlist_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String wlistVar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Var.IsSampleType_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer issampletypeVar;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Var(Integer idVar, Integer idType, String nameVar, String memoVar, Integer ifconstVar, String valueVar,
			Integer ifstaticVar, String blistVar, String wlistVar, Integer issampletypeVar) {
		this.idVar = idVar;
		this.idType = idType;
		this.nameVar = nameVar;
		this.memoVar = memoVar;
		this.ifconstVar = ifconstVar;
		this.valueVar = valueVar;
		this.ifstaticVar = ifstaticVar;
		this.blistVar = blistVar;
		this.wlistVar = wlistVar;
		this.issampletypeVar = issampletypeVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Var() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Var.Id_Var
	 * @return  the value of Var.Id_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIdVar() {
		return idVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Var.Id_Var
	 * @param idVar  the value for Var.Id_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIdVar(Integer idVar) {
		this.idVar = idVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Var.Id_Type
	 * @return  the value of Var.Id_Type
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIdType() {
		return idType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Var.Id_Type
	 * @param idType  the value for Var.Id_Type
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Var.Name_Var
	 * @return  the value of Var.Name_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getNameVar() {
		return nameVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Var.Name_Var
	 * @param nameVar  the value for Var.Name_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setNameVar(String nameVar) {
		this.nameVar = nameVar == null ? null : nameVar.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Var.Memo_Var
	 * @return  the value of Var.Memo_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getMemoVar() {
		return memoVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Var.Memo_Var
	 * @param memoVar  the value for Var.Memo_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setMemoVar(String memoVar) {
		this.memoVar = memoVar == null ? null : memoVar.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Var.IfConst_Var
	 * @return  the value of Var.IfConst_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIfconstVar() {
		return ifconstVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Var.IfConst_Var
	 * @param ifconstVar  the value for Var.IfConst_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIfconstVar(Integer ifconstVar) {
		this.ifconstVar = ifconstVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Var.Value_Var
	 * @return  the value of Var.Value_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getValueVar() {
		return valueVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Var.Value_Var
	 * @param valueVar  the value for Var.Value_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setValueVar(String valueVar) {
		this.valueVar = valueVar == null ? null : valueVar.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Var.IfStatic_Var
	 * @return  the value of Var.IfStatic_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIfstaticVar() {
		return ifstaticVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Var.IfStatic_Var
	 * @param ifstaticVar  the value for Var.IfStatic_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIfstaticVar(Integer ifstaticVar) {
		this.ifstaticVar = ifstaticVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Var.Blist_Var
	 * @return  the value of Var.Blist_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getBlistVar() {
		return blistVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Var.Blist_Var
	 * @param blistVar  the value for Var.Blist_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setBlistVar(String blistVar) {
		this.blistVar = blistVar == null ? null : blistVar.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Var.Wlist_Var
	 * @return  the value of Var.Wlist_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getWlistVar() {
		return wlistVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Var.Wlist_Var
	 * @param wlistVar  the value for Var.Wlist_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setWlistVar(String wlistVar) {
		this.wlistVar = wlistVar == null ? null : wlistVar.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Var.IsSampleType_Var
	 * @return  the value of Var.IsSampleType_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIssampletypeVar() {
		return issampletypeVar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Var.IsSampleType_Var
	 * @param issampletypeVar  the value for Var.IsSampleType_Var
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIssampletypeVar(Integer issampletypeVar) {
		this.issampletypeVar = issampletypeVar;
	}
}