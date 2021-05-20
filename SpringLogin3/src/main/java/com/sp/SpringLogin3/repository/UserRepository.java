package com.sp.SpringLogin3.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.SpringLogin3.entities.User;

@Repository
public class UserRepository {

//	@Autowired
	private User user;

	String sql = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test?serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "aaaa";

	public Boolean createUser(User user) {
		System.out.println("DAO create user");
		Boolean result = false;
		sql = "INSERT INTO test.USERS (username,password,sex,email) values(?,?,?,?)";
		// try JDBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getSex());
			stmt.setString(4, user.getEmail());
			int ins = stmt.executeUpdate();
			System.out.println("新增" + ins + "筆");
			if (ins == 1) {
				result = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
