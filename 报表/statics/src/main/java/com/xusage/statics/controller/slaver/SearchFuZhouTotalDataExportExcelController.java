package com.xusage.statics.controller.slaver;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.pojo.ExpandPojo;
import com.xusage.statics.service.slaver.SearchTotalDataExportExcelService;

@RestController
@RequestMapping("/statics")
public class SearchFuZhouTotalDataExportExcelController {

	
		@Autowired
		private SearchTotalDataExportExcelService searchFuZhouTotalDataExportExcelService;
		
		
		@RequestMapping("/searchFuZhouTotalDataExportExcel")
		public void searchFuZhouTotalDataExportExcel(){
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		    response.setHeader("Access-Control-Allow-Origin", "*"); //解决跨域访问报错   
		    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");   
		    response.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间   
		    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");   
		    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.   
		    response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0"); 
			
		    //创建HSSFWorkbook对象(excel的文档对象)
	        HSSFWorkbook wb = new HSSFWorkbook();
	        //建立新的sheet对象（excel的表单）
	        HSSFSheet sheet=wb.createSheet("福州数据报表");
	        //在sheet里创建第二行
	        HSSFRow row2=sheet.createRow(0);
	        //创建单元格并设置单元格内容
	        row2.createCell(0).setCellValue("客户名称");
	        row2.createCell(1).setCellValue("进项开票名称");
	        row2.createCell(2).setCellValue("凭证日期");
	        row2.createCell(3).setCellValue("发票金额");
	        row2.createCell(4).setCellValue("进项票金额");
	        row2.createCell(5).setCellValue("凭证日期");
	        row2.createCell(6).setCellValue("会计年度");
	        row2.createCell(7).setCellValue("会计期间");
	        row2.createCell(8).setCellValue("凭证字");
	        row2.createCell(9).setCellValue("凭证号");
	        row2.createCell(10).setCellValue("科目代码");
	        row2.createCell(11).setCellValue("科目名称");
	        row2.createCell(12).setCellValue("币别代码");
	        row2.createCell(13).setCellValue("币别名称");
	        row2.createCell(14).setCellValue("原币金额");
	        row2.createCell(15).setCellValue("借方");
	        row2.createCell(16).setCellValue("贷方");
	        row2.createCell(17).setCellValue("制单");
	        row2.createCell(18).setCellValue("审核");
	        row2.createCell(19).setCellValue("核准");
	        row2.createCell(20).setCellValue("出纳");
	        row2.createCell(21).setCellValue("经办");
	        row2.createCell(22).setCellValue("结算方式");
	        row2.createCell(23).setCellValue("结算号");
	        row2.createCell(24).setCellValue("凭证摘要");
	        row2.createCell(25).setCellValue("数量");
	        row2.createCell(26).setCellValue("数量单位");
	        row2.createCell(27).setCellValue("单价");
	        row2.createCell(28).setCellValue("参考信息");
	        row2.createCell(29).setCellValue("业务日期");
	        row2.createCell(30).setCellValue("往来业务");
	        row2.createCell(31).setCellValue("附件数");
	        row2.createCell(32).setCellValue("序号");
	        row2.createCell(33).setCellValue("系统模块");
	        row2.createCell(34).setCellValue("业务描述");
	        row2.createCell(35).setCellValue("汇率");
	        row2.createCell(36).setCellValue("分录序号");
	        row2.createCell(37).setCellValue("核算项目");
	        row2.createCell(38).setCellValue("过账");
	        row2.createCell(39).setCellValue("机制凭证");
	        row2.createCell(40).setCellValue("现金流量");
			
			
			/**查询福州的衍生数据*/
			String searchFuZhouTotalDataExportExcel = searchFuZhouTotalDataExportExcelService.searchFuZhouTotalDataExportExcel();
			List<ExpandPojo> parseArray = JSON.parseArray(searchFuZhouTotalDataExportExcel, ExpandPojo.class);
				for (int i = 1; i <= parseArray.size(); i++) {
					HSSFRow row=sheet.createRow(i);
					ExpandPojo result2 = parseArray.get(i-1);
					row.createCell(0).setCellValue(result2.getConsignorName());
			        row.createCell(1).setCellValue(result2.getInvoiceName());
			        if(!"null".equals(result2.getDocumentDate()) && result2.getDocumentDate() != null) {
			        	row.createCell(2).setCellValue(result2.getDocumentDate());
			        }
			        row.createCell(3).setCellValue(result2.getInvoiceAmount());
			        row.createCell(4).setCellValue(result2.getEntryTicketAmount());
			        row.createCell(5).setCellValue(result2.getDocumentDate());
			        if(!"null".equals(result2.getFiscalYear()) && result2.getFiscalYear() != null) {
			        	row.createCell(6).setCellValue(result2.getFiscalYear());
			        }
			        if(!"null".equals(result2.getFiscalPeriod()) && result2.getFiscalPeriod() != null) {
			        	row.createCell(7).setCellValue(result2.getFiscalPeriod());
			        }
			        row.createCell(8).setCellValue(result2.getDocumentWord());
			        row.createCell(9).setCellValue(result2.getDocumentNum());
			        row.createCell(10).setCellValue(result2.getSubjectCode());
			        row.createCell(11).setCellValue(result2.getSubjectName());
			        row.createCell(12).setCellValue(result2.getCurrencyCode());
			        row.createCell(13).setCellValue(result2.getCurrencyName());
			        row.createCell(14).setCellValue(result2.getOriginaCurrency());
			        row.createCell(15).setCellValue(result2.getDebit());
			        row.createCell(16).setCellValue(result2.getCredit());
			        row.createCell(17).setCellValue(result2.getBilling());
			        row.createCell(18).setCellValue(result2.getReview());
			        row.createCell(19).setCellValue(result2.getApproved());
			        row.createCell(20).setCellValue(result2.getCashier());
			        row.createCell(21).setCellValue(result2.getHandle());
			        row.createCell(22).setCellValue(result2.getSettleMethod());
			        row.createCell(23).setCellValue(result2.getSettleNum());
			        row.createCell(24).setCellValue(result2.getDocumentSummary());
			        row.createCell(25).setCellValue(result2.getNumber());
			        row.createCell(26).setCellValue(result2.getNumberUnit());
			        row.createCell(27).setCellValue(result2.getSinglePrice());
			        row.createCell(28).setCellValue(result2.getReferInfo());
			        row.createCell(29).setCellValue(result2.getBusinessDate());
			        row.createCell(30).setCellValue(result2.getExchangeBusiness());
			        row.createCell(31).setCellValue(result2.getAnnexesNum());
			        row.createCell(32).setCellValue(result2.getSerialNumber());
			        row.createCell(33).setCellValue(result2.getSystemModule());
			        row.createCell(34).setCellValue(result2.getBusinessDescription());
			        row.createCell(35).setCellValue(result2.getExchangeRate());
			        row.createCell(36).setCellValue(result2.getCatalogNumber());
			        row.createCell(37).setCellValue(result2.getAccountingProject());
			        row.createCell(38).setCellValue(result2.getPosting());
			        row.createCell(39).setCellValue(result2.getMechanismVouchers());
			        row.createCell(40).setCellValue(result2.getCashFlow());
				}
				
			//输出Excel文件
	        OutputStream output = null;
			try {
				output = response.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        response.reset();
	        response.setHeader("Content-disposition", "attachment; filename=FuZhouData.xls");
	        response.setContentType("application/msexcel");
	        try {
				wb.write(output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	      }
    }
