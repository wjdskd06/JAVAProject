package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DAO;
import model.User;
import model.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean insert(User user) {

		Connection conn = DAO.getConnect();
		try {
			UserDAO.getInstance().insert(conn, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		Connection conn = DAO.getConnect();
		try {
			UserDAO.getInstance().update(conn, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int user_code) {
		Connection conn = DAO.getConnect();
		try {
			UserDAO.getInstance().delete(conn, user_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User selectOne(String user_code) {
		Connection conn = DAO.getConnect();
		User user = new User();
		try {
			user = UserDAO.getInstance().selectOne(conn, user_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> selectAll() {
		Connection conn = DAO.getConnect();
		List<User> users= new ArrayList<User>();
		try {
			users = UserDAO.getInstance().selectAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
