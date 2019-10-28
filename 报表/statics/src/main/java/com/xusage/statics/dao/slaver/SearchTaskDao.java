package com.xusage.statics.dao.slaver;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xusage.statics.pojo.Task;

@Mapper
public interface SearchTaskDao {

		/**
		 * 查询任务列表接口
		 * */
		
		List<Task> searchTask(@Param("offset") Integer offset,@Param("length") Integer length);
		
		Integer count();
}
