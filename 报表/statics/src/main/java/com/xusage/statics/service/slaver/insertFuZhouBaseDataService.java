package com.xusage.statics.service.slaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;


@Service
public class insertFuZhouBaseDataService {

		
		@Autowired
		private com.xusage.statics.dao.slaver.insertFuZhouBaseDataDao insertFuZhouBaseDataDao;
		
		
		@ResponseBody
		public Integer insertFuZhouBaseData(String dimension,String coll_amount,String cash_amount){
			return insertFuZhouBaseDataDao.insertFuZhouBaseData(dimension, coll_amount, cash_amount);
		}
	
}
