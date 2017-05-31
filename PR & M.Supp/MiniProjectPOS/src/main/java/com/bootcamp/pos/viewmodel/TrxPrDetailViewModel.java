package com.bootcamp.pos.viewmodel;

public class TrxPrDetailViewModel {
	private int id;
	private int prId;
	private int variantName;
	private int variantId;
	private int requestQty;
	private int inStockQty;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrId() {
		return prId;
	}
	public void setPrId(int prId) {
		this.prId = prId;
	}
	public int getVariantName() {
		return variantName;
	}
	public void setVariantName(int variantName) {
		this.variantName = variantName;
	}
	public int getVariantId() {
		return variantId;
	}
	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}
	public int getRequestQty() {
		return requestQty;
	}
	public void setRequestQty(int requestQty) {
		this.requestQty = requestQty;
	}
	public int getInStockQty() {
		return inStockQty;
	}
	public void setInStockQty(int inStockQty) {
		this.inStockQty = inStockQty;
	}
}
