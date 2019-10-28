package com.xusage.statics.service.master;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xusage.statics.dao.master.FinancialFuZhouStatementDao;
import com.xusage.statics.pojo.CommentPojo;

@Service
public class FinancialFuZhouStatementService {

		
		@Autowired
		private FinancialFuZhouStatementDao financialFuZhouStatementDao;
		
		
		@ResponseBody
		public List<CommentPojo> searchFuZhouProvinceFinanical(Integer offset, Integer length,String consignorName){
			return financialFuZhouStatementDao.searchFuZhouProvinceFinanical(offset,length,consignorName);
		}
		
		@ResponseBody
		public Integer count(String consignorName) {
			return financialFuZhouStatementDao.count(consignorName);
		}
	
}
