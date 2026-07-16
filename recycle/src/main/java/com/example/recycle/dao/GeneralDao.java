package com.example.recycle.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.recycle.dto.MemberDto;

@Mapper
public interface GeneralDao {
	 MemberDto findByUserId(String userId);
	 int join(MemberDto memberDto) throws Exception;
}
