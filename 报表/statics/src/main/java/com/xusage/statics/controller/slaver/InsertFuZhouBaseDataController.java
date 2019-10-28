package com.xusage.statics.controller.slaver;


import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.service.master.FinancialFuQingStatementService;
import com.xusage.statics.service.master.FinancialFuZhouStatementService;
import com.xusage.statics.service.slaver.insertFuQingBaseDataService;

@RestController
@RequestMapping(value="/statics")
public class InsertFuZhouBaseDataController {

	
	@Autowired
	private com.xusage.statics.service.slaver.insertFuZhouBaseDataService insertFuZhouBaseDataService;
	
	@Autowired 
    private FinancialFuZhouStatementService financialFuZhouStatementService;
	
	@RequestMapping("/insertFuZhouBaseData")
	public Integer insertFuZhouBaseData(Integer offset, Integer length,String consignorName) throws JsonProcessingException{
		
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		Integer fuZhouTotal = 0;
		List<CommentPojo> listPojo = financialFuZhouStatementService.searchFuZhouProvinceFinanical(offset,length,consignorName);
		for (CommentPojo commentPojo : listPojo) {
			
			LinkedHashMap<String,Object> dimensionMap = new LinkedHashMap<String, Object>();
	                
			dimensionMap.put("consignorName", commentPojo.getConsignorName());
			dimensionMap.put("invoiceName", "福建好运福融物流有限公司");
			dimensionMap.put("certificatDate", commentPojo.getCertificatDate());
			dimensionMap.put("province", commentPojo.getProvince());
			String dimension = jacksonObjectMapper.writeValueAsString(dimensionMap);
			String coll_amount = commentPojo.getInvoiceAmount();
			String cash_amount = commentPojo.getEntryTicketAmount();
			
			fuZhouTotal = insertFuZhouBaseDataService.insertFuZhouBaseData(dimension, coll_amount, cash_amount);
		}
		return fuZhouTotal;
	}
}
