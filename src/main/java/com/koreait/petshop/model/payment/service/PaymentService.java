package com.koreait.petshop.model.payment.service;

import java.util.List;

import com.koreait.petshop.model.domain.Cart;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.domain.OrderSummary;
import com.koreait.petshop.model.domain.Receiver;


public interface PaymentService {
	//?��바구?�� �??�� ?���?
	public List selectCartList();//?��?�� 구분?��?�� 모든 ?��?��?�� �??��?���? 
	public List selectCartList(int member_id);//?��?�� ?��?��?�� ?��바구?�� ?��?��
	public Cart selectCart(int cart_id);
	public void insert(Cart cart);
	public void update(List<Cart> cartList); //?���? ?��?��
	public void delete(int cart_id); //pk?�� ?��?�� ?��?��?�� ?��?��?��?��?��
	public void delete(Member member); //?��?��?�� ?��?�� ?��?��?�� ?��?��?��?��?��
	
	//결제 ?���?
	public List selectPaymethodList();
	public void registOrder(OrderSummary orderSummary, Receiver receiver);//?��?��?��?�� 처리�? ?��구되?�� 메서?��...
}




