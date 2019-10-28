package com.xusage.statics.controller.slaver;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xusage.statics.quartz.UpdateFuQingBaseDataTask;
import com.xusage.statics.quartz.UpdateFuQingExpandBaseDataTask;
import com.xusage.statics.quartz.UpdateFuZhouBaseDataTask;
import com.xusage.statics.quartz.UpdateNingDeBaseDataTask;
import com.xusage.statics.quartz.UpdateNingDeExpandBaseDataTask;

@RestController
@RequestMapping(value="/statics")
public class HelloController {

	@Autowired
	private Scheduler scheduler;

	@RequestMapping(value = "/DataQuartz", method = RequestMethod.GET)
	public void updateNingDeBase() throws SchedulerException {
		// cron表达式
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 09 17 * * ?");
		// 根据name 和group获取当前trgger 的身份
		TriggerKey triggerKey = TriggerKey.triggerKey("FuQing", "FuQingGroup");
		CronTrigger triggerOld = null;
		try {
			// 获取触发器的信息
			triggerOld = (CronTrigger) scheduler.getTrigger(triggerKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		if (triggerOld == null) {
			// 将job加入到jobDetail中
			JobDetail jobDetail = JobBuilder.newJob(UpdateFuQingBaseDataTask.class).withIdentity("FuZhouExpand", "FuZhouExpandGroup").build();
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("FuZhouExpand", "FuZhouExpandGroup").withSchedule(cronScheduleBuilder)
					.build();
			// 执行任务
			scheduler.scheduleJob(jobDetail, trigger);
		} else {
			System.out.println("当前job已存在--------------------------------------------");
		}
	}
}
