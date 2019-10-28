package com.xusage.statics.controller.slaver;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xusage.statics.pojo.CommentPojo;
import com.xusage.statics.pojo.ExpandPojo;
import com.xusage.statics.service.master.FinancialFuQingStatementService;
import com.xusage.statics.service.slaver.InsertFuQingExpandDataService;
import com.xusage.statics.service.slaver.SelectSubjectCodeService;
import com.xusage.statics.util.CalculationUtil;
import com.xusage.statics.util.DateUtil;

@RestController
@RequestMapping(value="/statics")
public class InsertFuQingExpandDataController {

	@Autowired
	private InsertFuQingExpandDataService insertFuQingExpandDataService;
	
	@Autowired 
    private FinancialFuQingStatementService financialFuQingStatementService;
	
	@Autowired
	private SelectSubjectCodeService selectSubjectCodeService;
	
	
	@RequestMapping("/insertFuQingExpandData")
	public Integer insertFuQingExpandData(Integer offset, Integer length,String consignorName) throws JsonProcessingException, Exception{
	
	List<ExpandPojo> expand = new ArrayList<>();	
	
	/**将List转成json*/
	ObjectMapper jacksonObjectMapper = new ObjectMapper();
	
	List<CommentPojo> searchFuQingProvinceFinanical = financialFuQingStatementService.searchFuQingProvinceFinanical(offset,length,consignorName);
	int initNum = 400;
	int serialNumber = 4000;
	for (CommentPojo commentPojo : searchFuQingProvinceFinanical) {
		String selectNingDeSubjectCode = selectSubjectCodeService.selectFuQingSubjectCode();
		int catalogNumber = 0;
		Map<String, Object> map = JSON.parseObject(selectNingDeSubjectCode);
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			   ExpandPojo expandPojo = new ExpandPojo();
			   
			   expandPojo.setCarrierName(commentPojo.getCarrierName());
			   expandPojo.setDepartMent(commentPojo.getDepartMent());
			   expandPojo.setInvoiceName("福建好运福融物流有限公司");
			   expandPojo.setCertificatDate(commentPojo.getCertificatDate());
			   expandPojo.setInvoiceAmount(commentPojo.getInvoiceAmount());
			   expandPojo.setEntryTicketAmount(commentPojo.getEntryTicketAmount());
			   
			   
			   
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
			   if(!"null".equals(commentPojo.getInvoiceAmount()) && commentPojo.getInvoiceAmount() != null 
					   && !"null".equals(commentPojo.getEntryTicketAmount()) && commentPojo.getEntryTicketAmount() != null) {
			   if(entry.getKey().toString().split("_")[1].equals("1131")) {
				   expandPojo.setOriginaCurrency(commentPojo.getInvoiceAmount());
				   expandPojo.setDebit(commentPojo.getInvoiceAmount());
				   expandPojo.setCredit("0");
			   }
			   if(entry.getKey().toString().split("_")[1].equals("5101.02")) {
				   expandPojo.setOriginaCurrency(CalculationUtil.divide(commentPojo.getInvoiceAmount(), "1.09", 2));
				   expandPojo.setDebit("0");
				   expandPojo.setCredit(CalculationUtil.divide(commentPojo.getInvoiceAmount(), "1.09", 2));
			   }
			   if(entry.getKey().toString().split("_")[1].equals("2171.01.05.02")) {
				   expandPojo.setOriginaCurrency(CalculationUtil.subtract(commentPojo.getInvoiceAmount(), CalculationUtil.divide(commentPojo.getInvoiceAmount(), "1.09", 2), 2));
				   expandPojo.setDebit("0");
				   expandPojo.setCredit(CalculationUtil.subtract(commentPojo.getInvoiceAmount(), CalculationUtil.divide(commentPojo.getInvoiceAmount(), "1.09", 2), 2));
			   }
			   if(entry.getKey().toString().split("_")[1].equals("5401.01")) {
				   expandPojo.setOriginaCurrency(commentPojo.getEntryTicketAmount());
				   expandPojo.setDebit(commentPojo.getEntryTicketAmount());
				   expandPojo.setCredit("0");
			   }
			   if(entry.getKey().toString().split("_")[1].equals("2121")) {
				   expandPojo.setOriginaCurrency(commentPojo.getEntryTicketAmount());
				   expandPojo.setDebit("0");
				   expandPojo.setCredit(commentPojo.getEntryTicketAmount());
			   }
			 }
			   expandPojo.setBilling("刘丽");
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
				   expandPojo.setAccountingProject("客户--" + commentPojo.getConsignorName() + "||部门--拓展部" );
			   }
			   else if(entry.getKey().toString().split("_")[1].equals("2121")) {
				   expandPojo.setAccountingProject("部门--拓展部||供应商--" + (commentPojo.getCarrierName()==null?"福建好运福融物流有限公司":commentPojo.getCarrierName()));
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
	    String expandContent  = jacksonObjectMapper.writeValueAsString(expand);
	  
	
	  	Integer expandTotalData = insertFuQingExpandDataService.insertFuQingExpandData("福清衍生数据", expandContent);
		
		return expandTotalData;
	}
}
