package com.xusage.statics.controller.slaver;


import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.service.master.FinancialNingDeStatementService;


@RestController
@RequestMapping(value="/statics")
public class InsertNingDeBaseDataController {

	
	@Autowired
	private com.xusage.statics.service.slaver.insertNingDeBaseDataService insertNingDeBaseDataService;
	
	@Autowired 
    private FinancialNingDeStatementService financialNingDeStatementService;
	
	@RequestMapping("/insertNingDeBaseData")
	public Integer insertNingDeBaseData(Integer offset, Integer length,String consignorName) throws JsonProcessingException{
		
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		Integer ningDeTotal = 0;
		List<CommentPojo> listPojo = financialNingDeStatementService.searchNingDeProvinceFinanical(offset,length,consignorName);
		for (CommentPojo commentPojo : listPojo) {
			
			LinkedHashMap<String,Object> dimensionMap = new LinkedHashMap<String, Object>();
	                
			dimensionMap.put("consignorName", commentPojo.getConsignorName());
			dimensionMap.put("invoiceName", "福建好运福融物流有限公司");
			dimensionMap.put("certificatDate", commentPojo.getCertificatDate());
			dimensionMap.put("province", commentPojo.getProvince());
			String dimension = jacksonObjectMapper.writeValueAsString(dimensionMap);
			String coll_amount = commentPojo.getInvoiceAmount();
			String cash_amount = commentPojo.getEntryTicketAmount();
			
			ningDeTotal = insertNingDeBaseDataService.insertNingDeBaseData(dimension, coll_amount, cash_amount);
		}
		return ningDeTotal;
	}
}
