package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DAO;
import model.Location;
import model.LocationService;

public class LocationServiceImpl implements LocationService{

	@Override
	public boolean insert(Location location) {
		Connection conn = DAO.getConnect();
		try {
			LocationDAO.getInstance().insert(conn, location);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Location location) {
		Connection conn = DAO.getConnect();
		try {
			LocationDAO.getInstance().update(conn, location);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int location_Id) {
		Connection conn = DAO.getConnect();
		try {
			LocationDAO.getInstance().delete(conn, location_Id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Location selectOne(int location_Id) {
		Connection conn = DAO.getConnect();
		Location location = new Location();
		try {
			location = LocationDAO.getInstance().selectOne(conn, location_Id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return location;
	}

	@Override
	public Location selectOne(String location_name) {
		Connection conn = DAO.getConnect();
		Location location = new Location();
		try {
			location = LocationDAO.getInstance().selectOne(conn, location_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return location;
	}

	@Override
	public List<Location> selectAll() {
		Connection conn = DAO.getConnect();
		List<Location> location = new ArrayList<Location>();
		try {
			location = LocationDAO.getInstance().selectAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return location;
	}

}
