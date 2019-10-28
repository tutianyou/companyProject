package com.xusage.statics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter.BigDecimalLayoutForm;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.pojo.ExpandPojo;
import com.xusage.statics.pojo.Task;
import com.xusage.statics.service.master.FinancialNingDeStatementService;
import com.xusage.statics.service.slaver.SearchTaskService;
import com.xusage.statics.service.slaver.SearchTotalDataExportExcelService;
import com.xusage.statics.service.slaver.SelectSubjectCodeService;
import com.xusage.statics.util.CalculationUtil;
import com.xusage.statics.util.DateUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private SelectSubjectCodeService selectSubjectCodeService;
	
	@Autowired
	private SearchTotalDataExportExcelService searchTotalDataExportExcelService;
	
	@Autowired
	private SearchTaskService searchTaskService;
	
	@Autowired
	private FinancialNingDeStatementService financialStatementService;
	
	
	@SuppressWarnings("resource")
	@Test
	public void contextLoads() {
		
		Long start = System.currentTimeMillis();
		
		try {
			FileChannel sourceChannel = new FileInputStream(new File("D:\\Centos镜像文件\\CentOS-7-x86_64-DVD-1810.iso")).getChannel();
			FileChannel targetChannel = new FileOutputStream(new File("D:\\Centos镜像文件\\2.iso")).getChannel();
			for(long count = sourceChannel.size();count > 0;) {
				long tranfer = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
				count -= tranfer;
			}
			
		long end  = System.currentTimeMillis();
		
		System.err.println("耗时:" + (end - start));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void test() throws Exception {
		
		List<CommentPojo> list = financialStatementService.searchNingDeProvinceFinanical(0,5,"江祥");
		
	}
	
	
	
}
