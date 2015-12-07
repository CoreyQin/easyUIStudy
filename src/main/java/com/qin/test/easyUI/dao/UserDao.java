package com.qin.test.easyUI.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qin.test.easyUI.db.DataBaseHandler;
import com.qin.test.easyUI.model.User;

public class UserDao {
	
	public static List<User> getUsers() throws SQLException {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from users";
		ResultSet rs = DataBaseHandler.executeQuerySql(sql);
		while (rs.next()) {
			User user = new User();
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone"));
			userList.add(user);
		}
		return userList;
	}

}
