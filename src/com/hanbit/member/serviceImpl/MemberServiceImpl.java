package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	public void addMember(MemberBean bean) {
		map.put(bean.getUserId(),bean);
	}
	@Override
	public List<MemberBean> getMembers() {
		List<MemberBean> list = new ArrayList<>();
		Set<String> keys = map.keySet();
		for (String s:keys) {
			list.add(map.get(s));
		}
		return list;
	}

	@Override
	public int countMembers() {
		return map.size();
	}
	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp = new ArrayList<>();
		Set<String> keys = map.keySet();
			for (String s:keys) {
				if (name.equals(map.get(s).getName())) {
					temp.add(map.get(s));
				}
			}
		return temp;
	}

	@Override
	public MemberBean findById(String id) {
		return map.get(id);
	}
	
	@Override
	public void updatePass(MemberBean bean) {
		if (!bean.getName().equals("")) {
			map.get(bean.getUserId()).setName(bean.getName());
		}
		if (!bean.getUserPw().equals("")) {
			map.get(bean.getUserPw()).setUserPw(bean.getUserPw());
		}
		if (!bean.getSSN().equals("")) {
			map.get(bean.getSSN()).setSSN(bean.getSSN());
		}		
	}
	@Override
	public void delete(String id) {
		map.remove(id);
	}
}
