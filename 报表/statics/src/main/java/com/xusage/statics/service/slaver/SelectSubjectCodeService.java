package com.xusage.statics.service.slaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class SelectSubjectCodeService {
	
	@Autowired
	private com.xusage.statics.dao.slaver.SelectSubjectCodeDao selectSubjectCodeDao;
	
	
	
	/**查询宁德的科目代码*/
	@ResponseBody
	public String selectNingDeSubjectCode() {
		
		return selectSubjectCodeDao.selectNingDeSubjectCode();
	}
	
	
	/**查询福清的科目代码*/
	@ResponseBody
	public String selectFuQingSubjectCode() {
		
		return selectSubjectCodeDao.selectFuQingSubjectCode();
	}
	
	/**查询福州的科目代码*/
	@ResponseBody
	public String selectFuZhouSubjectCode() {
		
		return selectSubjectCodeDao.selectFuZhouSubjectCode();
	}
	
}
