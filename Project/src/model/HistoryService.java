package model;

import java.sql.Connection;
import java.util.List;

import javafx.collections.ObservableList;

public interface HistoryService {
	boolean insert(History history);

	boolean update(History history);

	boolean delete(int history);//this history = database history datatype = number type

	History selectOneUserId(int userId);

	History selectOne(int history);//this history = database history datatype = number type

	List<History> selectAll();
	List<History> selectDateAll(String date);
	ObservableList<History> selectDateUser(String date, User user);
}
