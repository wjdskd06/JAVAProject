package model;

import java.util.List;

public interface UserService {
	boolean insert(User user);

	boolean update(User user);

	boolean delete(int user_Code);

	User selectOne(String dept_id);

	List<User> selectAll();

}
