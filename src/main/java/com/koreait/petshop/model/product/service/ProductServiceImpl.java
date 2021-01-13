package com.koreait.petshop.model.product.service;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.petshop.exception.ProductRegistException;
import com.koreait.petshop.model.common.FileManager;
import com.koreait.petshop.model.domain.Image;
import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.product.repository.ImageDAO;
import com.koreait.petshop.model.product.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ImageDAO imageDAO;
	
	
	
	@Override
	public List selectAll() {
		return productDAO.selectAll();
	}

	@Override
	public List selectById(int subcategory_id) {

		return productDAO.selectById(subcategory_id);
	}

	@Override
	public Product select(int product_id) {
		
		return productDAO.select(product_id);
	}

	@Override
	public void regist(FileManager fileManager, Product product) throws ProductRegistException{
		
		String ext = fileManager.getExtend(product.getRepImg().getOriginalFilename());
		product.setFilename(ext);
		
		//db에 넣는 일은 DAO에게 시키고
		 productDAO.insert(product);
		
		//파일업로드까지! FileManager에게 일 시키자. service의 존재가 있기 때문에 존재. dao는 db만 딱! 하자
		//먼저 대표이미지 업로드
		 String basicImg = product.getProduct_id()+"."+ext;//상품의 product_id를 이용하여 대표이미지명을 결정짓자!!
		 fileManager.saveFile(fileManager.getSaveBasicDir()+File.separator+basicImg, product.getRepImg());
		 
		 //추가 이미지 업로드 (FileManager에게 추가이미지 갯수만큼 업로드 업무를 시키면 된다)
		 for(int i=0;i<product.getAddImg().length;i++) {
			 
			 MultipartFile file = product.getAddImg()[i];
			 ext = fileManager.getExtend(file.getOriginalFilename());
			 
			 //image table에 넣기
			 Image image = new Image();
			 image.setProduct_id(product.getProduct_id());	//fk
			 image.setFilename(ext);  //확장자 넣기
			 imageDAO.insert(image);
			 
			 //매니저의 저장메서드 호출
			 String addImg = image.getImage_id()+"."+ext;
			 fileManager.saveFile(fileManager.getSaveAddonDir()+File.separator+addImg, file);
		 }
		 
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		
	}

}
