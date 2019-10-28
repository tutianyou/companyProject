package com.xusage.statics.service.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xusage.statics.dao.master.FinancialNingDeStatementDao;
import com.xusage.statics.pojo.CommentPojo;

@Service
public class FinancialNingDeStatementService {

		
		@Autowired
		private FinancialNingDeStatementDao financialStatementDao;
		
		
		@ResponseBody
		public List<CommentPojo> searchNingDeProvinceFinanical(Integer offset, Integer length,String consignorName){
			return financialStatementDao.searchNingDeProvinceFinanical(offset, length,consignorName);
		}
		
		@ResponseBody
		public Integer count(String consignorName) {
			return 	financialStatementDao.count(consignorName);
		}
	
}
