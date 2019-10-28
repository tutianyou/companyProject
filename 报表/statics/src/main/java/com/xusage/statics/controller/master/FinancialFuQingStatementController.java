package com.xusage.statics.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.service.master.FinancialFuQingStatementService;

@RestController
@RequestMapping(value="/statics")
public class FinancialFuQingStatementController {

	
	@Autowired
	private FinancialFuQingStatementService financialFuQingStatementService;
	
	@RequestMapping("/searchFuQingProvinceFinanical")
	public List<CommentPojo> searchFuQingProvinceFinanical(Integer offset, Integer length,String consignorName) throws Exception{
		
		Integer count = financialFuQingStatementService.count(consignorName);
		
		List<CommentPojo> list = financialFuQingStatementService.searchFuQingProvinceFinanical(offset,length,consignorName);
		for (CommentPojo commentPojo : list) {
			commentPojo.setCount(count);
		}
		return list;
	}
}
