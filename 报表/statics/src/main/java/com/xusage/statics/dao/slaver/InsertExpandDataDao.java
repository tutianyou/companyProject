package com.xusage.statics.dao.slaver;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InsertExpandDataDao {

	/**宁德的衍生数据*/
	public Integer insertNingDeExpandData(
										  @Param(value="name") String name,
										  @Param(value="content") String content);
	
	/**福清的衍生数据*/
	public Integer insertFuQingExpandData(
										  @Param(value="name") String name,
										  @Param(value="content") String content);
	
	/**福州的衍生数据*/
	public Integer insertFuZhouExpandData(
										  @Param(value="name") String name,
										  @Param(value="content") String content);
	
}
