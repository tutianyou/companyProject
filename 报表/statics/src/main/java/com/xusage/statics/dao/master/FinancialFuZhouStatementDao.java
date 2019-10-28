package com.xusage.statics.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xusage.statics.pojo.CommentPojo;

@Mapper
public interface FinancialFuZhouStatementDao {

	public List<CommentPojo> searchFuZhouProvinceFinanical(
			@Param("offset") Integer offset,
			@Param("length") Integer length,
			@Param("consignorName") String consignorName);
	
	Integer count(@Param("consignorName") String consignorName);
	
}
