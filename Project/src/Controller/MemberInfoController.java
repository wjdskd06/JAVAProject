package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import common.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.User;
import service.UserDAO;

public class MemberInfoController implements Initializable{
	
	@FXML
	TextField userId;
	@FXML
	TextField userPw;
	@FXML
	TextField userSalePoint;
	@FXML
	TextField userGradePoint;
	
	User user;
	

public void MemberInfo(ActionEvent event) throws SQLException {
	Connection conn = DAO.getConnect();
	user= UserDAO.getInstance().selectOne(conn, user.getUser_Id());

	userId.setText(user.getUser_Id());
	userPw.setText(user.getUser_Pw());
	userSalePoint.setText(String.valueOf(user.getSale_Point()));
	userGradePoint.setText(String.valueOf(user.getGrade_Point()));
//	user= UserDAO.getInstance().selectOne(conn, user.getSale_Point());
//	user= UserDAO.getInstance().selectOne(conn, user.getGrade_Point());
	
	
	
}


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	Connection conn = DAO.getConnect();
	user = UserRootController.user;

	userId.setText(user.getUser_Id());
	userPw.setText(user.getUser_Pw());
	userSalePoint.setText(String.valueOf(user.getSale_Point()));
	userGradePoint.setText(String.valueOf(user.getGrade_Point()));

	
	
}
	
	
	
	
	

}
