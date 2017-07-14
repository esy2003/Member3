package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.daoImpl.MemberDAOImpl;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService {
	MemberBean member;
	Map<String, MemberBean> map;
	//생성자 처리가 이 문제의 핵심(아래)
	public MemberServiceImpl() {
		map = new HashMap<>();
		member = new MemberBean();
	}
	@Override
	public String addMember(MemberBean bean) {
		MemberDAO dao = new MemberDAOImpl();
		return (dao.insert(bean)==1)?"ok":"no";
	}
	@Override
	public List<MemberBean> getMembers() {
		return new MemberDAOImpl().selectAll();
	}

	@Override
	public int countMembers() {
		return new MemberDAOImpl().count();
	}
	
	@Override
	public List<MemberBean> findByName(String name) {
		return new MemberDAOImpl().selectByName(name);
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		MemberDAO dao = new MemberDAOImpl();
		member=dao.selectById(id);
		return member;
	}
	
	@Override
	public String modify(MemberBean bean) {
		MemberDAO dao=new MemberDAOImpl();
		return (dao.insert(bean)==1)?"ok":"no";
	}
	@Override
	public String remove(String id) {
		MemberDAO dao = new MemberDAOImpl();
		return (dao.insert(member)==1)?"ok":"no";
	}
}
