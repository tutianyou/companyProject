package com.xusage.statics.service.slaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;


@Service
public class insertFuQingBaseDataService {

		
		@Autowired
		private com.xusage.statics.dao.slaver.insertFuQingBaseDataDao insertFuQingBaseDataDao;
		
		
		@ResponseBody
		public Integer insertFuQingBaseDataDao(String dimension,String coll_amount,String cash_amount){
			return insertFuQingBaseDataDao.insertFuQingBaseData(dimension, coll_amount, cash_amount);
		}
	
}
