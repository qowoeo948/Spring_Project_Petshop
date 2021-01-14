package com.koreait.petshop.model.domain;

import java.util.List;

import lombok.Data;

@Data
public class MemberType {
   private int member_type_id;
   private String type;
   private List<Admin> admin;
   private List<Member> member;
}