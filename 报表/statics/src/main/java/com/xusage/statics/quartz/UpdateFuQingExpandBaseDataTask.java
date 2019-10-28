package com.xusage.statics.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.xusage.statics.controller.slaver.UpdateFuQingBaseDataController;
import com.xusage.statics.controller.slaver.UpdateFuQingExpandDataController;
import com.xusage.statics.controller.slaver.UpdateNingDeBaseDataController;
import com.xusage.statics.controller.slaver.UpdateNingDeExpandDataController;

public class UpdateFuQingExpandBaseDataTask extends QuartzJobBean{

	
	
	@Autowired
	private UpdateNingDeExpandDataController updateNingDeExpandDataController;
	
	@Autowired
	private UpdateFuQingExpandDataController updateFuQingExpandDataController;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		try {
			Integer offset = null;
			Integer length = null;
			String consignorName = "";
			updateNingDeExpandDataController.updateNingDeExpandData(offset,length,consignorName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
