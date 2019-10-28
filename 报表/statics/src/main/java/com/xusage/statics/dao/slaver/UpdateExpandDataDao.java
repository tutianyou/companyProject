package com.xusage.statics.dao.slaver;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UpdateExpandDataDao {

	
	/**更新宁德的基础数据*/
	Integer updateNingDeBaseData(@Param(value="dimension") String dimension,
								 @Param(value="coll_amount") String coll_amount,
								 @Param(value="cash_amount") String cash_amount,
								 @Param(value="consignorName") String consignorName,
								 @Param(value="certificatDate") String certificatDate);
	
	/**更新宁德的衍生数据*/
	Integer updateNingDeExpandData(@Param(value="updatetime") String updatetime,@Param(value="content") String content);
	
	
	
	
	
	/**更新福清的基础数据*/
	Integer updateFuQingBaseData(@Param(value="dimension") String dimension,
								 @Param(value="coll_amount") String coll_amount,
								 @Param(value="cash_amount") String cash_amount,
								 @Param(value="consignorName") String consignorName,
								 @Param(value="certificatDate") String certificatDate,
								 @Param(value="departMent") String departMent);
	
	/**更新福清的衍生数据*/
	Integer updateFuQingExpandData(@Param(value="updatetime") String updatetime,@Param(value="content") String content);
	
	
	
	
	
	
	/**更新福州的基础数据*/
	Integer updateFuZhouBaseData(@Param(value="dimension") String dimension,
								 @Param(value="coll_amount") String coll_amount,
								 @Param(value="cash_amount") String cash_amount,
								 @Param(value="consignorName") String consignorName,
								 @Param(value="certificatDate") String certificatDate);
	
	
	/**更新福州的衍生数据*/
	Integer updateFuZhouExpandData(@Param(value="updatetime") String updatetime,@Param(value="content") String content);
	
	
}
