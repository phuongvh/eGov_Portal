
/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */


package com.vportal.portlet.rate.action;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Exrate")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Exrate implements Serializable{

	private String currencyCode;
	private String currencyName;
	private Double buy;
	private Double transfer;
	private Double sell;
	
	@XmlAttribute
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	@XmlAttribute
	public String getCurrencyName() {
		return currencyName;
	}
	
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	@XmlAttribute
	public Double getBuy() {
		return buy;
	}
	
	public void setBuy(Double buy) {
		this.buy = buy;
	}
	
	@XmlAttribute
	public Double getTransfer() {
		return transfer;
	}
	
	public void setTransfer(Double transfer) {
		this.transfer = transfer;
	}
	
	@XmlAttribute
	public Double getSell() {
		return sell;
	}
	
	public void setSell(Double sell) {
		this.sell = sell;
	}
	

}
