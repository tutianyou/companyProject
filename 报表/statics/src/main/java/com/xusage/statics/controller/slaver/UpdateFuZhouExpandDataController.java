package com.xusage.statics.controller.slaver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.pojo.ExpandPojo;
import com.xusage.statics.service.master.FinancialFuZhouStatementService;
import com.xusage.statics.service.master.FinancialNingDeStatementService;
import com.xusage.statics.service.slaver.SelectSubjectCodeService;
import com.xusage.statics.service.slaver.UpdateExpandDataService;
import com.xusage.statics.util.CalculationUtil;
import com.xusage.statics.util.DateUtil;

@RestController
@RequestMapping(value="/statics")
public class UpdateFuZhouExpandDataController {

	
	@Autowired
	private UpdateExpandDataService updateExpandDataService;
	
	@Autowired 
    private FinancialFuZhouStatementService financialFuZhouStatementService;
	
	@Autowired
	private SelectSubjectCodeService selectSubjectCodeService;
	
	/**更新宁德的衍生数据
	 * @throws Exception */
	@RequestMapping("/updateFuZhouExpandData")
	public Integer updateFuZhouExpandData(Integer offset, Integer length,String consignorName) throws Exception {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date date = new Date();
		String updatetime = df.format(date);
		
		List<ExpandPojo> expand = new ArrayList<>();	
		
		/**将List转成json*/
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		
		List<CommentPojo> searchFuZhouProvinceFinanical = financialFuZhouStatementService.searchFuZhouProvinceFinanical(offset,length,consignorName);
		int initNum = 500;
		int serialNumber = 4000;
		
		for (CommentPojo commentPojo : searchFuZhouProvinceFinanical) {
			String selectNingDeSubjectCode = selectSubjectCodeService.selectFuZhouSubjectCode();
			int catalogNumber = 0;
			Map<String, Object> map = JSON.parseObject(selectNingDeSubjectCode);
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				   ExpandPojo expandPojo = new ExpandPojo();
				   expandPojo.setDocumentDate(commentPojo.getCertificatDate());
				   if(!"null".equals(commentPojo.getCertificatDate()) && commentPojo.getCertificatDate() != null) {
					   expandPojo.setFiscalYear(DateUtil.getYear(commentPojo.getCertificatDate())); 
					   expandPojo.setFiscalPeriod(DateUtil.getMonth(commentPojo.getCertificatDate())); 
				   }
				   expandPojo.setDocumentWord("记");
				   expandPojo.setConsignorName(commentPojo.getConsignorName());
				   expandPojo.setDocumentNum(initNum);
				   expandPojo.setSubjectCode(entry.getKey().toString().split("_")[1]);
				   expandPojo.setSubjectName(entry.getValue().toString());
				   expandPojo.setCurrencyCode("RMB");
				   expandPojo.setCurrencyName("人名币");
				   if(!"null".equals(commentPojo.getInvoiceAmount()) && !"null".equals(commentPojo.getEntryTicketAmount())
						   && commentPojo.getInvoiceAmount() != null && commentPojo.getEntryTicketAmount() != null) {
					   if(entry.getKey().toString().split("_")[1].equals("1122.10.01.002.001")) {
						   expandPojo.setOriginaCurrency(commentPojo.getInvoiceAmount());
						   expandPojo.setDebit(commentPojo.getInvoiceAmount());
						   expandPojo.setCredit("0");
					   }
					   if(entry.getKey().toString().split("_")[1].equals("5001.10.01.01.002")) {
						   expandPojo.setOriginaCurrency(CalculationUtil.divide(commentPojo.getInvoiceAmount(), "1.09", 2));
						   expandPojo.setDebit("0");
						   expandPojo.setCredit(CalculationUtil.divide(commentPojo.getInvoiceAmount(), "1.09", 2));
					   }
					   if(entry.getKey().toString().split("_")[1].equals("2221.01.02.05")) {
						   expandPojo.setOriginaCurrency(CalculationUtil.subtract(commentPojo.getInvoiceAmount(), CalculationUtil.divide(commentPojo.getInvoiceAmount(), "1.09", 2), 2));
						   expandPojo.setDebit("0");
						   expandPojo.setCredit(CalculationUtil.subtract(commentPojo.getInvoiceAmount(), CalculationUtil.divide(commentPojo.getInvoiceAmount(), "1.09", 2), 2));
					   }
					   if(entry.getKey().toString().split("_")[1].equals("5401.10.01.02.001")) {
						   expandPojo.setOriginaCurrency(CalculationUtil.divide(commentPojo.getEntryTicketAmount(), "1.09", 2));
						   expandPojo.setDebit(CalculationUtil.divide(commentPojo.getEntryTicketAmount(), "1.09", 2));
						   expandPojo.setCredit("0");
					   }
					   if(entry.getKey().toString().split("_")[1].equals("2221.01.01.01.09")) {
						   expandPojo.setOriginaCurrency(CalculationUtil.subtract(commentPojo.getEntryTicketAmount(), CalculationUtil.divide(commentPojo.getEntryTicketAmount(), "1.09", 2), 2));
						   expandPojo.setDebit(commentPojo.getEntryTicketAmount());
						   expandPojo.setCredit("0");
					   }
					   if(entry.getKey().toString().split("_")[1].equals("2202.10.01.002.001")) {
						   expandPojo.setOriginaCurrency(commentPojo.getEntryTicketAmount());
						   expandPojo.setDebit("0");
						   expandPojo.setCredit(commentPojo.getEntryTicketAmount());
					   }
				   }

				   expandPojo.setBilling("高小琴");
				   expandPojo.setReview("NONE");
				   expandPojo.setApproved("NONE");
				   expandPojo.setCashier("NONE");
				   expandPojo.setHandle("");
				   expandPojo.setSettleMethod("*");
				   expandPojo.setSettleNum("");
				   
				   if(!"null".equals(commentPojo.getCertificatDate()) && commentPojo.getCertificatDate() != null) {
					   if(entry.getKey().toString().split("_")[1].equals("1131") || entry.getKey().toString().split("_")[1].equals("5101.02") || entry.getKey().toString().split("_")[1].equals("2171.01.05.02")) {
							  expandPojo.setDocumentSummary(DateUtil.getMonth(commentPojo.getCertificatDate())+
				   						  "月" + commentPojo.getConsignorName()+"收入(" + (DateUtil.getMonth(commentPojo.getCertificatDate()) + 1)  + "月份开票)");
						   }else {
							   expandPojo.setDocumentSummary(DateUtil.getMonth(commentPojo.getCertificatDate())+
				   						  "月" + commentPojo.getConsignorName()+"成本");
						   }
				   }
				   
				   expandPojo.setNumber("0");
				   expandPojo.setNumberUnit("*");
				   expandPojo.setSinglePrice("0");
				   expandPojo.setReferInfo("");
				   if(!"null".equals(commentPojo.getCertificatDate()) && commentPojo.getCertificatDate() != null ) {
					   expandPojo.setBusinessDate(commentPojo.getCertificatDate());
				   }
				   expandPojo.setExchangeBusiness("");
				   expandPojo.setAnnexesNum("0");
				   expandPojo.setSerialNumber(serialNumber);
				   expandPojo.setSystemModule("");
				   expandPojo.setBusinessDescription("");
				   expandPojo.setExchangeRate("1");
				   
				   expandPojo.setCatalogNumber(catalogNumber);
				   catalogNumber+=1;
				   
				   if(entry.getKey().toString().split("_")[1].equals("1131")) {
					   expandPojo.setAccountingProject("客户--" + commentPojo.getConsignorName());
				   }
				   else if(entry.getKey().toString().split("_")[1].equals("5401.10.01.02.001")) {
					   expandPojo.setAccountingProject("成本项目--公路" );
				   }
				   else if(entry.getKey().toString().split("_")[1].equals("2121")) {
					   expandPojo.setAccountingProject("供应商--" + (commentPojo.getInvoiceName()==null?"福建好运福融物流有限公司":commentPojo.getInvoiceName()));
				   }else {
					   expandPojo.setAccountingProject("");
				   }
				   
				   expandPojo.setPosting("");
				   expandPojo.setMechanismVouchers("0");
				   expandPojo.setCashFlow("");
				   
				   expand.add(expandPojo);
				  }
				 initNum += 1;
				}
		    String content  = jacksonObjectMapper.writeValueAsString(expand);
		
		Integer updateNingDeExpandData = updateExpandDataService.updateFuZhouExpandData(updatetime, content);
		
		return updateNingDeExpandData;
	}
	
}
