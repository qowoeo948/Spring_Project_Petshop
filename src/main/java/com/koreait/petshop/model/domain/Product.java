package com.koreait.petshop.model.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int product_id;
	private SubCategory subCategory;
	private String product_name;
	private int price;
	private String detail;
	private String filename;
	private int hit;
	
	//이미지 하나를 자동으로 처리하는 객체 선언
	//단, 이름을 html의 업로드 컴포넌트 파라미터명과 일치 시켜야 자동으로 업로드 처리해준다..
	private MultipartFile repImg;		//대표 이미지
	private MultipartFile addImg[];	//추가 이미지는 선택사항이며 동시에 배열이다.


	private List<Image> imageList;
	

	
	
}
