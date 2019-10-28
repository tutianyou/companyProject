package com.xusage.statics.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommentPojo implements Serializable{

		/**序列号*/
		private static final long serialVersionUID = 1L;

		/**订单号*/
		private String cargoNo;
		
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
		
		/**分页的总条数*/
		private Integer count;
		
		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public String getDepartMent() {
			return departMent;
		}

		public void setDepartMent(String departMent) {
			this.departMent = departMent;
		}

		public String getCarrierName() {
			return carrierName;
		}

		public void setCarrierName(String carrierName) {
			this.carrierName = carrierName;
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

		public String getInvoiceName() {
			return invoiceName;
		}

		public void setInvoiceName(String invoiceName) {
			this.invoiceName = invoiceName;
		}

		public String getCargoNo() {
			return cargoNo;
		}

		public void setCargoNo(String cargoNo) {
			this.cargoNo = cargoNo;
		}

		public String getConsignorName() {
			return consignorName;
		}

		public void setConsignorName(String consignorName) {
			this.consignorName = consignorName;
		}

		public String getCertificatDate() {
			return certificatDate;
		}

		public void setCertificatDate(String certificatDate) {
			this.certificatDate = certificatDate;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		@Override
		public String toString() {
			return "cargoNo=" + cargoNo + ", consignorName=" + consignorName + ", carrierName="
					+ carrierName + ", departMent=" + departMent + ", invoiceName=" + invoiceName + ", certificatDate="
					+ certificatDate + ", invoiceAmount=" + invoiceAmount + ", entryTicketAmount=" + entryTicketAmount
					+ ", province=" + province;
		}
		
		
}
