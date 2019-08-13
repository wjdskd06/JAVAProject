package model;

import java.util.List;

public interface LocationService {
	boolean insert(Location location);

	boolean update(Location location);

	boolean delete(int location_Id);//this history = database history datatype = number type

	Location selectOne(int location_Id);
	
	Location selectOne(String location_name);//this history = database history datatype = number type

	
	
	List<Location> selectAll();
}
