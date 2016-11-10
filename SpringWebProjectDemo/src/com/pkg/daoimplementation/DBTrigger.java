package com.pkg.daoimplementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import java.sql.*;

//CREATE OR REPLACE AND COMPILE JAVA SOURCE NAMED My_JavaClass AS

public class DBTrigger {
	  public static void logSal (int empID, float oldSal, float newSal)
	  {
	    System.out.println("empID: "+empID);
	    System.out.println("OldSal: "+oldSal);
	    System.out.println("New Sal: "+newSal);
	  }
	}
