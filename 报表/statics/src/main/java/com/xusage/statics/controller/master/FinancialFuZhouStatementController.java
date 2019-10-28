package com.xusage.statics.controller.master;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.service.master.FinancialFuZhouStatementService;

@RestController
@RequestMapping(value="/statics")
public class FinancialFuZhouStatementController {

	
	@Autowired
	private FinancialFuZhouStatementService financialFuZhouStatementService;
	
	@RequestMapping("/searchFuZhouProvinceFinanical")
	public List<CommentPojo> searchFuZhouProvinceFinanical(Integer offset, Integer length,String consignorName){
		List<CommentPojo> list = financialFuZhouStatementService.searchFuZhouProvinceFinanical(offset,length,consignorName);
		Integer count = financialFuZhouStatementService.count(consignorName);
		for (CommentPojo commentPojo : list) {
			commentPojo.setInvoiceName("福建好运福融物流有限公司");
			commentPojo.setCount(count);
		}
		return list;
	}
}
