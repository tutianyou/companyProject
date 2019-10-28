package com.xusage.statics.controller.slaver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.service.master.FinancialFuZhouStatementService;
import com.xusage.statics.service.slaver.UpdateExpandDataService;


@RestController
@RequestMapping(value="/statics")
public class UpdateFuZhouBaseDataController {

	
	@Autowired
	private UpdateExpandDataService updateExpandDataService;
	
	@Autowired 
    private FinancialFuZhouStatementService financialFuZhouStatementService;
	
	
	/**更新宁德的基础数据
	 * @throws Exception */
	@RequestMapping("/updateFuZhouBaseData")
	public Integer updateFuZhouBaseData(Integer offset, Integer length,String consignorName) throws Exception {
		
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		Integer updateFuZhouBaseData = 0;
		List<CommentPojo> listPojo = financialFuZhouStatementService.searchFuZhouProvinceFinanical(offset, length,consignorName);
		for (CommentPojo commentPojo : listPojo) {
			
			Map<String,Object> dimensionMap = new HashMap<String, Object>();
	                
			dimensionMap.put("consignorName", commentPojo.getConsignorName());
			dimensionMap.put("invoiceName", "福建好运福融物流有限公司");
			dimensionMap.put("certificatDate", commentPojo.getCertificatDate());
			dimensionMap.put("province", commentPojo.getProvince());
			String dimension = jacksonObjectMapper.writeValueAsString(dimensionMap);
			String coll_amount = commentPojo.getInvoiceAmount();
			String cash_amount = commentPojo.getEntryTicketAmount();
		
	        updateFuZhouBaseData = updateExpandDataService.updateFuZhouBaseData(dimension, coll_amount, cash_amount,commentPojo.getConsignorName(),commentPojo.getCertificatDate());
		
	}
		return updateFuZhouBaseData;
  }
}
