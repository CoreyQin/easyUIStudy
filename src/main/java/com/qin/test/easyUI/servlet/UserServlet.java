package com.qin.test.easyUI.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.qin.test.easyUI.dao.UserDao;
import com.qin.test.easyUI.model.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<User> userList = UserDao.getUsers();
			JSONArray userArray = new JSONArray();
//			JSONObject returnJson = new JSONObject();
			for(User user : userList){
				JSONObject userObject = new JSONObject();
				userObject.put("firstname",user.getFirstname());
				userObject.put("lastname", user.getLastname());
				userObject.put("phone", user.getPhone());
				userObject.put("email", user.getEmail());
				userArray.put(userObject);
			}
			response.getWriter().print(userArray.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
