package com.koreait.petshop.model.payment.repository;

import java.util.List;

import com.koreait.petshop.model.domain.Cart;
import com.koreait.petshop.model.domain.Member;

public interface CartDAO {
	public List selectAll();//?��?�� 구분?��?�� 모든 ?��?��?�� �??��?���? 
	public List selectAll(int member_id);//?��?�� ?��?��?�� ?��바구?�� ?��?��
	public Cart select(int cart_id);
	public void duplicateCheck(Cart cart); //?��바구?�� 중복?��?�� ?���? 체크
	public void insert(Cart cart); 
	public void update(Cart cart);
	public void delete(int cart_id); //pk�? ?��?��?�� ?��?��
	public void delete(Member member); //?��?��?�� ?��?�� ?��?��?�� ?��?��?��?��?��
	
}
