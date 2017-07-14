package com.hanbit.member.daoImpl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.constants.DB;
import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.domain.MemberBean;


public class MemberDAOImpl implements MemberDAO {
	public MemberDAOImpl() {
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOAD FAIL");
			e.printStackTrace();
		}		
	}
	@Override
	public int insert(MemberBean member) {
		int rs=0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("INSERT INTO %s(%s, %s, %s, %s, %s) VALUES('%S', '%S', '%S', '%S', SYSDATE)"
							, DB.TABLE_MEMBER, 
							DB.MEM_ID, DB.MEM_PW, DB.MEM_NAME, DB.MEM_SSN, DB.MEM_REGDATE, 
							member.getUserId(), member.getUserPw(), member.getName(), member.getSSN()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(
			String.format("SELECT * FROM %s", DB.TABLE_MEMBER));
			MemberBean member = null;
			while(rs.next()) {
				member = new MemberBean();
				member.setUserId(rs.getString(DB.MEM_ID));
                member.setUserPw(rs.getString(DB.MEM_PW));
                member.setName(rs.getString(DB.MEM_NAME));
                member.setSSN(rs.getString(DB.MEM_SSN));
                member.setRegdate(rs.getString(DB.MEM_REGDATE));
                list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int count() {
		int count = 0;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT COUNT(*) AS %s FROM %s", "count", DB.TABLE_MEMBER));
			if (rs.next()) {
				count = Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	   @Override
	   public MemberBean selectById(String id) {
	      MemberBean member = new MemberBean();
	         try {
	            ResultSet rs=DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(
	                  String.format("SELECT * FROM Member WHERE userId='%s'", id));
	            if(rs.next()){
	               member.setUserId(rs.getString(DB.MEM_ID));
	               member.setUserPw(rs.getString(DB.MEM_PW));
	               member.setName(rs.getString(DB.MEM_NAME));
	               member.setSSN(rs.getString(DB.MEM_SSN));
	               member.setRegdate(rs.getString(DB.MEM_REGDATE));
	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	         }                  
	      return member;
	   }
	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> list = new ArrayList<>();
		try {
			MemberBean member = null;
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM %s WHERE name='%s'", DB.TABLE_MEMBER, name));
			while (rs.next()) {
					member = new MemberBean();
	                member.setUserId(rs.getString(DB.MEM_ID));
	                member.setUserPw(rs.getString(DB.MEM_PW));
	                member.setName(rs.getString(DB.MEM_NAME));
	                member.setSSN(rs.getString(DB.MEM_SSN));
	                member.setRegdate(rs.getString(DB.MEM_REGDATE));
	                list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(MemberBean member) {
		int rs=0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("UPDATE Member SET name='%s' WHERE userId='%s'", ""));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	
	}

	@Override
	public int delete(String id) {
		int rs=0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("%s", ""));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
