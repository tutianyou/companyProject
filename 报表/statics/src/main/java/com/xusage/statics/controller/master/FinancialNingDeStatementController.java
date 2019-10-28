package com.xusage.statics.controller.master;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.service.master.FinancialNingDeStatementService;

@RestController
@RequestMapping(value="/statics")
public class FinancialNingDeStatementController {

	
	@Autowired
	private FinancialNingDeStatementService financialStatementService;
	
	@RequestMapping("/searchNingDeProvinceFinanical")  
	public List<CommentPojo> searchNingDeProvinceFinanical(Integer offset, Integer length,String consignorName){
		List<CommentPojo> list = financialStatementService.searchNingDeProvinceFinanical(offset,length,consignorName);
		Integer count = financialStatementService.count(consignorName);
		for (CommentPojo commentPojo : list) {
			commentPojo.setCount(count);
			commentPojo.setInvoiceName("福建好运福融物流有限公司");
		}
		return list;
	}
}
	