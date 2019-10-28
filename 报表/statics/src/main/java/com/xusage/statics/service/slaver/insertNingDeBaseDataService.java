package com.xusage.statics.service.slaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;


@Service
public class insertNingDeBaseDataService {

		
		@Autowired
		private com.xusage.statics.dao.slaver.insertNingDeBaseDataDao insertNingDeBaseDataDao;
		
		
		@ResponseBody
		public Integer insertNingDeBaseData(String dimension,String coll_amount,String cash_amount){
			return insertNingDeBaseDataDao.insertNingDeBaseData(dimension, coll_amount, cash_amount);
		}
	
}
