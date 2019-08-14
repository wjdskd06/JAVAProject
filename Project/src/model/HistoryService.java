package model;

import java.util.List;

public interface HistoryService {
	boolean insert(History history);

	boolean update(History history);

	boolean delete(int history);//this history = database history datatype = number type

	History selectOneUserId(int userId);

	History selectOne(int history);//this history = database history datatype = number type

	List<History> selectAll();
	List<History> selectDateAll(String date);
	List<History> selectDateUser(String date,User user);
}
