package com.xusage.statics.service.slaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class InsertFuQingExpandDataService {

	@Autowired
	private com.xusage.statics.dao.slaver.InsertExpandDataDao insertNingDeExpandDataDao;
	
	@ResponseBody
	public Integer insertFuQingExpandData(String name,String content) {
		
		return insertNingDeExpandDataDao.insertFuQingExpandData(name, content);
		
	}
	
	
}
