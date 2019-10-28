package com.xusage.statics.dao.slaver;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface insertFuZhouBaseDataDao {

	public Integer insertFuZhouBaseData(@Param(value="dimension") String dimension,@Param(value="coll_amount") String coll_amount,@Param(value="cash_amount") String cash_amount);
	
}
