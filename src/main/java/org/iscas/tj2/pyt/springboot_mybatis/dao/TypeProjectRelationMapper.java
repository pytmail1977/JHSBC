package org.iscas.tj2.pyt.springboot_mybatis.dao;

import org.iscas.tj2.pyt.springboot_mybatis.domain.TypeProjectRelation;

public interface TypeProjectRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TypeProjectRelation
     *
     * @mbg.generated Sun Dec 30 11:32:24 CST 2018
     */
    int deleteByPrimaryKey(Integer idTypeprojectrelation);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TypeProjectRelation
     *
     * @mbg.generated Sun Dec 30 11:32:24 CST 2018
     */
    int insert(TypeProjectRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TypeProjectRelation
     *
     * @mbg.generated Sun Dec 30 11:32:24 CST 2018
     */
    int insertSelective(TypeProjectRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TypeProjectRelation
     *
     * @mbg.generated Sun Dec 30 11:32:24 CST 2018
     */
    TypeProjectRelation selectByPrimaryKey(Integer idTypeprojectrelation);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TypeProjectRelation
     *
     * @mbg.generated Sun Dec 30 11:32:24 CST 2018
     */
    int updateByPrimaryKeySelective(TypeProjectRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TypeProjectRelation
     *
     * @mbg.generated Sun Dec 30 11:32:24 CST 2018
     */
    int updateByPrimaryKey(TypeProjectRelation record);
}