package com.koreait.petshop.model.domain;

import lombok.Data;

@Data
public class Member {
   private int member_id;
   private int member_type_id;
   private String user_id;
   private String name;
   private String phone;
   private String password;
   private String email_id;
   private String email_server;
   private String zipcode;
   private String addr;
   private String addr_detail;
   private String regdate;
}