package com.xusage.statics.controller.slaver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.service.master.FinancialNingDeStatementService;
import com.xusage.statics.service.slaver.UpdateExpandDataService;

@RestController
@RequestMapping(value="/statics")
public class UpdateNingDeBaseDataController{

	
	@Autowired
	private UpdateExpandDataService updateExpandDataService;
	
	@Autowired 
    private FinancialNingDeStatementService financialNingDeStatementService;
	
	
	/**更新宁德的基础数据
	 * @throws Exception */
	@RequestMapping("/updateNingDeBaseData")
	public Integer updateNingDeBaseData(Integer offset, Integer length,String consignorName) throws Exception {
		
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		Integer updateNingDeBaseData = 0;
		List<CommentPojo> listPojo = financialNingDeStatementService.searchNingDeProvinceFinanical(offset,length,consignorName);
		for (CommentPojo commentPojo : listPojo) {
			
			Map<String,Object> dimensionMap = new HashMap<String, Object>();
	                
			dimensionMap.put("consignorName", commentPojo.getConsignorName());
			dimensionMap.put("invoiceName", "福建好运福融物流有限公司");
			dimensionMap.put("certificatDate", commentPojo.getCertificatDate());
			dimensionMap.put("province", commentPojo.getProvince());
			String dimension = jacksonObjectMapper.writeValueAsString(dimensionMap);
			String coll_amount = commentPojo.getInvoiceAmount();
			String cash_amount = commentPojo.getEntryTicketAmount();
		
	        updateNingDeBaseData = updateExpandDataService.updateNingDeBaseData(dimension, coll_amount, cash_amount,commentPojo.getConsignorName(),commentPojo.getCertificatDate());
		
	}
		return updateNingDeBaseData;
  }

}
