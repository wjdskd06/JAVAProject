package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.History;
import model.HistoryService;
import model.User;

public class HistoryImpl implements HistoryService{

	@Override
	public boolean insert(History history) {
		Connection conn = DAO.getConnect();
		try {
			HistoryDAO.getInstance().insert(conn, history);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(History history) {
		Connection conn = DAO.getConnect();
		try {
			HistoryDAO.getInstance().update(conn, history);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int history) {
		Connection conn = DAO.getConnect();
		try {
			HistoryDAO.getInstance().delete(conn, history);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public History selectOne(int history) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<History> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public History selectOneUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<History> selectDateAll(String date) {
		Connection conn = DAO.getConnect();
		List<History> list = new ArrayList<History>();
		try {
			return HistoryDAO.getInstance().selectDateAll(conn, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ObservableList<History> selectDateUser(String date, User user) {
		Connection conn = DAO.getConnect();
		ObservableList<History>list = FXCollections.observableArrayList();
		try {
			return HistoryDAO.getInstance().selectDateUser(conn, date, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



}
