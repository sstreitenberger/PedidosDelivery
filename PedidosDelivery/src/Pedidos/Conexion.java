package Pedidos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	
	
	
	public Connection conexionDeli() throws Exception {
		String url = "jdbc:sqlserver://192.168.245.2:1433;databaseName=Delivery";
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String userName = "web";
		String password = "w3b4ls34r3w4rd52021";
		Class.forName(driver).newInstance();
		return DriverManager.getConnection(url, userName, password);
	}

}


