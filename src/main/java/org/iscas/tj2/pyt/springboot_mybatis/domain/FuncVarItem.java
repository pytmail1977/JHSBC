package org.iscas.tj2.pyt.springboot_mybatis.domain;

public class FuncVarItem {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FuncVarItem.Id_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer idFuncvaritem;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FuncVarItem.Name_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String nameFuncvaritem;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FuncVarItem.Id_FuncVar
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer idFuncvar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FuncVarItem.NO_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer noFuncvaritem;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FuncVarItem.IsSampleType_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private Integer issampletypeFuncvaritem;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FuncVarItem.SampleValue_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String samplevalueFuncvaritem;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FuncVarItem.Memo_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	private String memoFuncvaritem;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public FuncVarItem(Integer idFuncvaritem, String nameFuncvaritem, Integer idFuncvar, Integer noFuncvaritem,
			Integer issampletypeFuncvaritem, String samplevalueFuncvaritem, String memoFuncvaritem) {
		this.idFuncvaritem = idFuncvaritem;
		this.nameFuncvaritem = nameFuncvaritem;
		this.idFuncvar = idFuncvar;
		this.noFuncvaritem = noFuncvaritem;
		this.issampletypeFuncvaritem = issampletypeFuncvaritem;
		this.samplevalueFuncvaritem = samplevalueFuncvaritem;
		this.memoFuncvaritem = memoFuncvaritem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public FuncVarItem() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FuncVarItem.Id_FuncVarItem
	 * @return  the value of FuncVarItem.Id_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIdFuncvaritem() {
		return idFuncvaritem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FuncVarItem.Id_FuncVarItem
	 * @param idFuncvaritem  the value for FuncVarItem.Id_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIdFuncvaritem(Integer idFuncvaritem) {
		this.idFuncvaritem = idFuncvaritem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FuncVarItem.Name_FuncVarItem
	 * @return  the value of FuncVarItem.Name_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getNameFuncvaritem() {
		return nameFuncvaritem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FuncVarItem.Name_FuncVarItem
	 * @param nameFuncvaritem  the value for FuncVarItem.Name_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setNameFuncvaritem(String nameFuncvaritem) {
		this.nameFuncvaritem = nameFuncvaritem == null ? null : nameFuncvaritem.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FuncVarItem.Id_FuncVar
	 * @return  the value of FuncVarItem.Id_FuncVar
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIdFuncvar() {
		return idFuncvar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FuncVarItem.Id_FuncVar
	 * @param idFuncvar  the value for FuncVarItem.Id_FuncVar
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIdFuncvar(Integer idFuncvar) {
		this.idFuncvar = idFuncvar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FuncVarItem.NO_FuncVarItem
	 * @return  the value of FuncVarItem.NO_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getNoFuncvaritem() {
		return noFuncvaritem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FuncVarItem.NO_FuncVarItem
	 * @param noFuncvaritem  the value for FuncVarItem.NO_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setNoFuncvaritem(Integer noFuncvaritem) {
		this.noFuncvaritem = noFuncvaritem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FuncVarItem.IsSampleType_FuncVarItem
	 * @return  the value of FuncVarItem.IsSampleType_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public Integer getIssampletypeFuncvaritem() {
		return issampletypeFuncvaritem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FuncVarItem.IsSampleType_FuncVarItem
	 * @param issampletypeFuncvaritem  the value for FuncVarItem.IsSampleType_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setIssampletypeFuncvaritem(Integer issampletypeFuncvaritem) {
		this.issampletypeFuncvaritem = issampletypeFuncvaritem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FuncVarItem.SampleValue_FuncVarItem
	 * @return  the value of FuncVarItem.SampleValue_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getSamplevalueFuncvaritem() {
		return samplevalueFuncvaritem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FuncVarItem.SampleValue_FuncVarItem
	 * @param samplevalueFuncvaritem  the value for FuncVarItem.SampleValue_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setSamplevalueFuncvaritem(String samplevalueFuncvaritem) {
		this.samplevalueFuncvaritem = samplevalueFuncvaritem == null ? null : samplevalueFuncvaritem.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FuncVarItem.Memo_FuncVarItem
	 * @return  the value of FuncVarItem.Memo_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public String getMemoFuncvaritem() {
		return memoFuncvaritem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FuncVarItem.Memo_FuncVarItem
	 * @param memoFuncvaritem  the value for FuncVarItem.Memo_FuncVarItem
	 * @mbg.generated  Sun Dec 30 11:32:24 CST 2018
	 */
	public void setMemoFuncvaritem(String memoFuncvaritem) {
		this.memoFuncvaritem = memoFuncvaritem == null ? null : memoFuncvaritem.trim();
	}
}