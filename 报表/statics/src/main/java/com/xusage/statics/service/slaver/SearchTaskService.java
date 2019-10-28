package com.xusage.statics.service.slaver;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xusage.statics.dao.slaver.SearchTaskDao;
import com.xusage.statics.dao.slaver.UserDao;
import com.xusage.statics.pojo.Task;
import com.xusage.statics.pojo.User;

@Service
public class SearchTaskService {

	@Autowired
	private SearchTaskDao searchTaskDao;
	
	public List<Task> searchTask(Integer offset, Integer length){
		return searchTaskDao.searchTask(offset,length);
	}
	
	public Integer count() {
		return searchTaskDao.count();
	}
}
