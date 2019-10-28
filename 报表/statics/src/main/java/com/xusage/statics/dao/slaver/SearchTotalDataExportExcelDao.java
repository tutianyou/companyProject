package com.xusage.statics.dao.slaver;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xusage.statics.pojo.CommentPojo;

@Mapper
public interface SearchTotalDataExportExcelDao {

	
			/**整合宁德的基础数据跟衍生数据成excel表*/
			List<CommentPojo> searchNingDeBaseByProvince();
			
			/**整合宁德的衍生数据跟衍生数据成excel表*/
			String searchNingDeTotalDataExportExcel();	
			
			
			
			/**整合福清的基础数据跟衍生数据成excel表*/
			List<CommentPojo> searchFuQingBaseByProvince();
			
			/**整合福清的衍生数据跟衍生数据成excel表*/
			String searchFuQingTotalDataExportExcel();	
			
			
			
			/**整合福州的基础数据跟衍生数据成excel表*/
			List<CommentPojo> searchFuZhouBaseByProvince();
			
			/**整合福州的衍生数据跟衍生数据成excel表*/
			String searchFuZhouTotalDataExportExcel();
			
			
}