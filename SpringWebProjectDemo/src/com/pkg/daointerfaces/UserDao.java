package com.pkg.daointerfaces;

import java.sql.SQLException;
import java.util.List;

import com.pkg.beans.Users;

public interface UserDao {

	public boolean insertUserInfo(Users user) throws ClassNotFoundException, SQLException;;
	public boolean retrieveUserInfo(String email,String password);
	public Users retrieveAUser(String userEmail);
}
