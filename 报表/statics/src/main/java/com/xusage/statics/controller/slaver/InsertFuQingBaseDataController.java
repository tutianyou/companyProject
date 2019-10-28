package com.xusage.statics.controller.slaver;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.service.master.FinancialFuQingStatementService;
import com.xusage.statics.service.slaver.insertFuQingBaseDataService;

@RestController
@RequestMapping(value="/statics")
public class InsertFuQingBaseDataController {

	
	@Autowired
	private insertFuQingBaseDataService insertFuQingBaseDataService;
	
	@Autowired 
    private FinancialFuQingStatementService financialFuQingStatementService;
	
	@RequestMapping("/insertFuQingBaseData")
	public Integer insertFuQingBaseDataService(Integer offset, Integer length,String consignorName) throws JsonProcessingException{
		DecimalFormat format = new DecimalFormat("0.00");
		
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		Integer insertFuQingBaseDataDao = 0;
		List<CommentPojo> listPojo = financialFuQingStatementService.searchFuQingProvinceFinanical(offset,length,consignorName);
		for (CommentPojo commentPojo : listPojo) {
			
			LinkedHashMap<String,Object> dimensionMap = new LinkedHashMap<String, Object>();
	                
			dimensionMap.put("consignorName", commentPojo.getConsignorName());
			dimensionMap.put("carrierName", commentPojo.getCarrierName());
			dimensionMap.put("certificatDate", commentPojo.getCertificatDate());
			dimensionMap.put("departMent",commentPojo.getDepartMent());
			dimensionMap.put("province", commentPojo.getProvince());
			
			String dimension = jacksonObjectMapper.writeValueAsString(dimensionMap);
			String coll_amount = format.format(new BigDecimal(commentPojo.getInvoiceAmount()));
			String cash_amount = format.format(new BigDecimal(commentPojo.getEntryTicketAmount()));
			
			insertFuQingBaseDataDao = insertFuQingBaseDataService.insertFuQingBaseDataDao(dimension, coll_amount, cash_amount);
		}
		return insertFuQingBaseDataDao;
	}
}
