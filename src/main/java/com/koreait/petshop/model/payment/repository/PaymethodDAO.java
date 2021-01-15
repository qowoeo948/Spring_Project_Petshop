package com.koreait.petshop.model.payment.repository;

import java.util.List;

import com.koreait.petshop.model.domain.OrderDetail;
import com.koreait.petshop.model.domain.OrderSummary;

public interface PaymethodDAO {
	public List selectAll();
}
