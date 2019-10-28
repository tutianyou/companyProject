package com.xusage.statics.service.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xusage.statics.dao.master.FinancialFuQingStatementDao;
import com.xusage.statics.pojo.CommentPojo;

@Service
public class FinancialFuQingStatementService {

		
		@Autowired
		private FinancialFuQingStatementDao financialFuQingStatementDao;
		
		
		@ResponseBody
		public List<CommentPojo> searchFuQingProvinceFinanical(Integer offset, Integer length,String consignorName){
			return financialFuQingStatementDao.searchFuQingProvinceFinanical(offset,length,consignorName);
		}
	
		@ResponseBody
		public Integer count(String consignorName) {
			return financialFuQingStatementDao.count(consignorName);
		}
}
