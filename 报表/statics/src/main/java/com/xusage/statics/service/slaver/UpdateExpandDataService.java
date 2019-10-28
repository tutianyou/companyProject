package com.xusage.statics.service.slaver;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xusage.statics.dao.slaver.UpdateExpandDataDao;

@Service
public class UpdateExpandDataService {

	@Autowired
	private UpdateExpandDataDao updateExpandDataDao;
	
	
	/**更新宁德的基础数据*/
	public Integer updateNingDeBaseData(String dimension,String coll_amount,String cash_amount,String consignorName,String certificatDate) {
		return updateExpandDataDao.updateNingDeBaseData(dimension, coll_amount, cash_amount,consignorName,certificatDate);
	}
	
	
	/**更新宁德的数据*/
	@ResponseBody
	public Integer updateNingDeExpandData(String updatetime,String content) {
		return updateExpandDataDao.updateNingDeExpandData(updatetime, content);
	}
	
	
	
	
	
	/**更新福清的基础数据*/
	public Integer updateFuQingBaseData(String dimension,String coll_amount,String cash_amount,String consignorName,String certificatDate,String departMent) {
		return updateExpandDataDao.updateFuQingBaseData(dimension, coll_amount, cash_amount,consignorName,certificatDate,departMent);
	}
	
	/**更新福清的数据*/
	@ResponseBody
	public Integer updateFuQingExpandData(String updatetime,String content) {
		return updateExpandDataDao.updateFuQingExpandData(updatetime, content);
	}
	
	
	
	
	
	/**更新宁德的基础数据*/
	public Integer updateFuZhouBaseData(String dimension,String coll_amount,String cash_amount,String consignorName,String certificatDate) {
		return updateExpandDataDao.updateNingDeBaseData(dimension, coll_amount, cash_amount,consignorName,certificatDate);
	}
	
	
	/**更新福州的数据*/
	@ResponseBody
	public Integer updateFuZhouExpandData(String updatetime,String content) {
		return updateExpandDataDao.updateFuZhouExpandData(updatetime, content);
	}
	
}
