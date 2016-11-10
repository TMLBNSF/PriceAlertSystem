package com.pkg.daointerfaces;

import java.sql.SQLException;
import java.util.List;

import com.pkg.beans.Alert;

public interface AlertDao {

	public boolean insertUserAlert(int itemId, int userId, String email, String carrier) ;
	public List<Alert> retrieveAlertList(int itemId);
}
