package com.fabio.connession;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnessioneDB {
	private Properties properties;
	private DatabaseConfigurazione dbConfigurazione;
	private Connection connection;
	
	public ConnessioneDB() {
	}
	
	public void stabilisciConnessione() {
		try {
			Class.forName(dbConfigurazione.getDriverClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(dbConfigurazione.getUrl(),dbConfigurazione.getUsername(),dbConfigurazione.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public DatabaseConfigurazione getDbConfigurazione() {
		return dbConfigurazione;
	}

	public void setDbConfigurazione(DatabaseConfigurazione dbConfigurazione) {
		this.dbConfigurazione = dbConfigurazione;
	}
	
	
	
	
	
}
