package com.xusage.statics.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExpandPojo implements Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**客户名称*/
	private String consignorName;
	
	/**承运商名称(福清)*/
	private String carrierName;
	
	/**业务所属部门*/
	private String departMent;
	
	/**进项开票名称*/
	private String invoiceName;
	
	/**装货时间(凭证日期)*/
	private String certificatDate;
	
	/**开票金额总和(对于福清是发起收款金额)*/
	private String invoiceAmount;
	
	/**进项票金额总和(对于福清是现金支付金额) */
	private String entryTicketAmount;
	
	/**开票区域*/
	private String province;
	
	
	
	/**凭证日期*/
	private String documentDate;
	
	/**会计年度*/
	private Integer fiscalYear;
	
	/**会计期间*/
	private Integer fiscalPeriod;
	
	/**凭证字*/
	private String documentWord;
	
	/**凭证号*/
	private Integer documentNum;
	
	/**科目代码*/
	private String subjectCode;
	
	/**科目名称*/
	private String subjectName;
	
	/**币别代码*/
	private String currencyCode;
	
	/**币别名称*/
	private String currencyName;
	
	/**原币金额*/
	private String originaCurrency;
	
	/**借方*/
	private String debit;
	
	/**贷方*/
	private String credit;
	
	/**制单*/
	private String billing;
	
	/**审核*/
	private String review;
	
	/**核准*/
	private String approved;
	
	/**出纳*/
	private String cashier;
	
	/**经办*/
	private String handle;
	
	/**结算方式*/
	private String settleMethod;
	
	/**结算号*/
	private String settleNum;
	
	/**凭证摘要*/
	private String documentSummary;
	
	/**数量*/
	private String number;
	
	/**数量单位*/
	private String numberUnit;
	
	/**单价*/
	private String singlePrice;
	
	/**参考信息*/
	private String referInfo;
	
	/**业务日期*/
	private String businessDate;
	
	/**往来业务*/
	private String exchangeBusiness;
	
	/**附件数*/
	private String annexesNum;
	
	/**序号*/
	private Integer serialNumber;
	
	/**系统模块*/
	private String systemModule;
	
	/**业务描述*/
	private String businessDescription;
	
	/**汇率*/
	private String exchangeRate;
	
	/**分录序号*/
	private Integer catalogNumber;
	
	/**核算项目*/
	private String accountingProject;
	
	/**过账*/
	private String posting;
	
	/**机制凭证*/
	private String mechanismVouchers;
	
	/**现金流量*/
	private String cashFlow;
	
	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getDepartMent() {
		return departMent;
	}

	public void setDepartMent(String departMent) {
		this.departMent = departMent;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public String getCertificatDate() {
		return certificatDate;
	}

	public void setCertificatDate(String certificatDate) {
		this.certificatDate = certificatDate;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getEntryTicketAmount() {
		return entryTicketAmount;
	}

	public void setEntryTicketAmount(String entryTicketAmount) {
		this.entryTicketAmount = entryTicketAmount;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumberUnit() {
		return numberUnit;
	}

	public void setNumberUnit(String numberUnit) {
		this.numberUnit = numberUnit;
	}

	public String getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(String singlePrice) {
		this.singlePrice = singlePrice;
	}

	public String getReferInfo() {
		return referInfo;
	}

	public void setReferInfo(String referInfo) {
		this.referInfo = referInfo;
	}

	public String getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public String getExchangeBusiness() {
		return exchangeBusiness;
	}

	public void setExchangeBusiness(String exchangeBusiness) {
		this.exchangeBusiness = exchangeBusiness;
	}

	public String getAnnexesNum() {
		return annexesNum;
	}

	public void setAnnexesNum(String annexesNum) {
		this.annexesNum = annexesNum;
	}


	public String getSystemModule() {
		return systemModule;
	}

	public void setSystemModule(String systemModule) {
		this.systemModule = systemModule;
	}

	public String getBusinessDescription() {
		return businessDescription;
	}

	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Integer getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(Integer catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public String getPosting() {
		return posting;
	}

	public void setPosting(String posting) {
		this.posting = posting;
	}

	public String getMechanismVouchers() {
		return mechanismVouchers;
	}

	public void setMechanismVouchers(String mechanismVouchers) {
		this.mechanismVouchers = mechanismVouchers;
	}

	public String getCashFlow() {
		return cashFlow;
	}

	public void setCashFlow(String cashFlow) {
		this.cashFlow = cashFlow;
	}

	public String getOriginaCurrency() {
		return originaCurrency;
	}

	public void setOriginaCurrency(String originaCurrency) {
		this.originaCurrency = originaCurrency;
	}

	public String getDebit() {
		return debit;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getBilling() {
		return billing;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getCashier() {
		return cashier;
	}

	public void setCashier(String cashier) {
		this.cashier = cashier;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getSettleMethod() {
		return settleMethod;
	}

	public void setSettleMethod(String settleMethod) {
		this.settleMethod = settleMethod;
	}

	public String getSettleNum() {
		return settleNum;
	}

	public void setSettleNum(String settleNum) {
		this.settleNum = settleNum;
	}

	public String getDocumentSummary() {
		return documentSummary;
	}

	public void setDocumentSummary(String documentSummary) {
		this.documentSummary = documentSummary;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getAccountingProject() {
		return accountingProject;
	}

	public void setAccountingProject(String accountingProject) {
		this.accountingProject = accountingProject;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public String getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	public Integer getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(Integer fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public Integer getFiscalPeriod() {
		return fiscalPeriod;
	}

	public void setFiscalPeriod(Integer fiscalPeriod) {
		this.fiscalPeriod = fiscalPeriod;
	}

	public String getDocumentWord() {
		return documentWord;
	}

	public void setDocumentWord(String documentWord) {
		this.documentWord = documentWord;
	}

	public Integer getDocumentNum() {
		return documentNum;
	}

	public void setDocumentNum(Integer documentNum) {
		this.documentNum = documentNum;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Override
	public String toString() {
		return "consignorName:" + consignorName + ", documentDate:" + documentDate + ", fiscalYear:"
				+ fiscalYear + ", fiscalPeriod:" + fiscalPeriod + ", documentWord:" + documentWord + ", documentNum:"
				+ documentNum + ", subjectCode:" + subjectCode + ", subjectName:" + subjectName + ", currencyCode:"
				+ currencyCode + ", currencyName:" + currencyName + ", originaCurrency:" + originaCurrency + ", debit:"
				+ debit + ", credit:" + credit + ", billing:" + billing + ", review:" + review + ", approved:"
				+ approved + ", cashier:" + cashier + ", handle:" + handle + ", settleMethod:" + settleMethod
				+ ", settleNum:" + settleNum + ", documentSummary:" + documentSummary + ", number:" + number
				+ ", numberUnit:" + numberUnit + ", singlePrice:" + singlePrice + ", referInfo:" + referInfo
				+ ", businessDate:" + businessDate + ", exchangeBusiness:" + exchangeBusiness + ", annexesNum:"
				+ annexesNum + ", serialNumber:" + serialNumber + ", systemModule:" + systemModule
				+ ", businessDescription:" + businessDescription + ", exchangeRate:" + exchangeRate + ", catalogNumber:"
				+ catalogNumber + ", accountingProject:" + accountingProject + ", posting:" + posting
				+ ", mechanismVouchers:" + mechanismVouchers + ", cashFlow:" + cashFlow ;
	}
	
	
}
