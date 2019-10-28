package com.xusage.statics.controller.slaver;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.pojo.ExpandPojo;
import com.xusage.statics.service.master.FinancialFuQingStatementService;
import com.xusage.statics.service.master.FinancialNingDeStatementService;
import com.xusage.statics.service.slaver.SelectSubjectCodeService;
import com.xusage.statics.service.slaver.UpdateExpandDataService;
import com.xusage.statics.util.CalculationUtil;
import com.xusage.statics.util.DateUtil;

@RestController
@RequestMapping(value="/statics")
public class UpdateFuQingBaseDataController {

	
	@Autowired
	private UpdateExpandDataService updateExpandDataService;
	
	@Autowired 
    private FinancialFuQingStatementService financialFuQingStatementService;
	
	
	/**更新宁德的基础数据
	 * @throws Exception */
	@RequestMapping("/updateFuQingBaseData")
	public Integer updateFuQingBaseData(Integer offset, Integer length,String consignorName) throws Exception {
		
		DecimalFormat format = new DecimalFormat("0.00");
		
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		Integer updateNingDeBaseData = 0;
		List<CommentPojo> listPojo = financialFuQingStatementService.searchFuQingProvinceFinanical(offset,length,consignorName);
		for (CommentPojo commentPojo : listPojo) {
			
			Map<String,Object> dimensionMap = new HashMap<String, Object>();
	                
			dimensionMap.put("consignorName", commentPojo.getConsignorName());
			dimensionMap.put("carrierName", commentPojo.getCarrierName());
			dimensionMap.put("certificatDate", commentPojo.getCertificatDate());
			dimensionMap.put("departMent",commentPojo.getDepartMent());
			dimensionMap.put("province", commentPojo.getProvince());
			
			String dimension = jacksonObjectMapper.writeValueAsString(dimensionMap);
			String coll_amount = format.format(new BigDecimal(commentPojo.getInvoiceAmount()));
			String cash_amount = format.format(new BigDecimal(commentPojo.getEntryTicketAmount()));
		
	        updateNingDeBaseData = updateExpandDataService.updateFuQingBaseData(dimension, coll_amount, cash_amount,commentPojo.getConsignorName(),commentPojo.getCertificatDate(),commentPojo.getDepartMent());
		
	}
		return updateNingDeBaseData;
  }
}
