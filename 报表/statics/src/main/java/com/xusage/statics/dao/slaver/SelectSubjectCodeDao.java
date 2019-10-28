package com.xusage.statics.dao.slaver;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelectSubjectCodeDao {

       /**查询宁德科目代码*/
	   public String selectNingDeSubjectCode();
	   
	   /**查询福清的科目代码*/
	   public String selectFuQingSubjectCode();
	   
	   /**查询福州的科目代码*/
	   public String selectFuZhouSubjectCode();
	   
}
