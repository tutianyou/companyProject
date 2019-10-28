package com.xusage.statics.service.slaver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xusage.statics.dao.slaver.SearchTotalDataExportExcelDao;
import com.xusage.statics.pojo.CommentPojo;

@Service
public class SearchTotalDataExportExcelService {

	
	@Autowired
	private SearchTotalDataExportExcelDao searchNingDeTotalDataExportExcelDao;
	
	
	/**宁德基础数据*/
	@ResponseBody
	public List<CommentPojo> searchNingDeBaseByProvince(){
		
		return searchNingDeTotalDataExportExcelDao.searchNingDeBaseByProvince();
	}
	
	/**宁德衍生数据*/
	@ResponseBody
	public String searchNingDeTotalDataExportExcel() {
		return searchNingDeTotalDataExportExcelDao.searchNingDeTotalDataExportExcel();
	}
	
	
	
	/**福清基础数据*/
	@ResponseBody
	public List<CommentPojo> searchFuQingBaseByProvince(){
		
		return searchNingDeTotalDataExportExcelDao.searchFuQingBaseByProvince();
	}
	
	/**福清衍生数据*/
	@ResponseBody
	public String searchFuQingTotalDataExportExcel() {
		return searchNingDeTotalDataExportExcelDao.searchFuQingTotalDataExportExcel();
	}
	
	
	
	
	/**福州基础数据*/
	@ResponseBody
	public List<CommentPojo> searchFuZhouBaseByProvince(){
		
		return searchNingDeTotalDataExportExcelDao.searchFuZhouBaseByProvince();
	}
	
	/**福州衍生数据*/
	@ResponseBody
	public String searchFuZhouTotalDataExportExcel() {
		return searchNingDeTotalDataExportExcelDao.searchFuZhouTotalDataExportExcel();
	}
	
}
