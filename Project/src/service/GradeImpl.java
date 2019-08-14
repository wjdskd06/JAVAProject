package service;

import java.sql.Connection;
import java.sql.SQLException;

import common.DAO;
import model.Grade;
import model.GradeService;
import model.User;

public class GradeImpl implements GradeService{

	@Override
	public boolean insert(Grade grade) {
		Connection conn = DAO.getConnect();
		try {
			GradeDAO.getInstance().insert(conn, grade);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Grade grade) {
		Connection conn = DAO.getConnect();
		try {
			GradeDAO.getInstance().update(conn, grade);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String grade) {
		Connection conn = DAO.getConnect();
		try {
			GradeDAO.getInstance().delete(conn, grade);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String outGrade(int grade_Point) {
		Connection conn = DAO.getConnect();
		try {
			return GradeDAO.getInstance().outGrade(conn, grade_Point);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String outGrade(User user) {
		Connection conn = DAO.getConnect();
		try {
			return GradeDAO.getInstance().outGrade(conn,user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
