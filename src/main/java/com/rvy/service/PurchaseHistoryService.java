package com.rvy.service;

import java.util.List;

import com.rvy.entity.PurchaseHistory;

public interface PurchaseHistoryService {
	List<PurchaseHistory> getAllPurchaseHistory();
	PurchaseHistory getPurchaseHistoryById(String id);
	PurchaseHistory addElement(PurchaseHistory obj);
	List<PurchaseHistory> findDetailsByCustomerId(Integer Customerid);
}
