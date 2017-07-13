package com.hanbit.member.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hanbit.member.constants.Database;
import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.domain.MemberBean;


public class MemberDAOImpl implements MemberDAO {

	@Override
	public void insert(MemberBean member) {
		try {
			Class.forName(Database.DRIVER);
			Connection conn = DriverManager.getConnection(Database.URL, Database.USERID, Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "";
			stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<MemberBean> selectAll() {
		try {
			Class.forName(Database.DRIVER);
			Connection conn = DriverManager.getConnection(Database.URL, Database.USERID, Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "";
			stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int count() {
		try {
			Class.forName(Database.DRIVER);
			Connection conn = DriverManager.getConnection(Database.URL, Database.USERID, Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "";
			stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public MemberBean selectById(String id) {
		Connection conn=null;
		MemberBean member = new MemberBean();
		try {
			Class.forName(Database.DRIVER);
			conn = DriverManager.getConnection(Database.URL, Database.USERID, Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql="SELECT * FROM Member WHERE userId = '"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				member.setName(rs.getString("name"));
				member.setUserId(rs.getString("userId"));
				member.setUserPw(rs.getString("userPw"));
				member.setSSN(rs.getString("ssn"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		try {
			Class.forName(Database.DRIVER);
			Connection conn = DriverManager.getConnection(Database.URL, Database.USERID, Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "";
			stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(MemberBean member) {
		try {
			Class.forName(Database.DRIVER);
			Connection conn = DriverManager.getConnection(Database.URL, Database.USERID, Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "";
			stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		try {
			Class.forName(Database.DRIVER);
			Connection conn = DriverManager.getConnection(Database.URL, Database.USERID, Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "";
			stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
