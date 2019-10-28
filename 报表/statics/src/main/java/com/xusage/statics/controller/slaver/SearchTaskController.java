package com.xusage.statics.controller.slaver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xusage.statics.pojo.Task;
import com.xusage.statics.pojo.User;
import com.xusage.statics.service.slaver.SearchTaskService;
import com.xusage.statics.service.slaver.UserService;
import com.xusage.statics.util.Md5;


@RestController
@RequestMapping("/statics")
public class SearchTaskController {

	@Autowired
	private SearchTaskService searchTaskService;
	
	@RequestMapping("/searchTask")
	public List<Task> searchTask(Integer offset, Integer length){
		List<Task> listTask = new ArrayList<Task>();
		Integer count = searchTaskService.count();
		for (Task task : searchTaskService.searchTask(offset, length)) {
			task.setCount(count);
			listTask.add(task);
		}
		return listTask;
	}
}
