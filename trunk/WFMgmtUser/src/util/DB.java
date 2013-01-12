package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DB {
	// private static DataSource data;
	private static DataSource data;// , data1 = null;
	static int timeCounter = 0;
	static boolean isActiveConnectionsWatcherStarted = false;
	protected static Connection conn;
	protected DatabaseMetaData dmd;
	protected ResultSetMetaData rsmd = null;
	protected ResultSet rs;
	protected Statement stmt;
	protected static boolean isSeekingConnectionFirstTime = true;
	protected static boolean isEnteredBMTCFirstTime = true;
	protected static boolean isEnteredCelcabsFirstTime = true;
	protected static int activeConnections;
	static String SPACES = "                           " + "                 ";
	private static DB db = new DB();

	private DB() {
	}

	public static DB getInstance() {
		return db;
	}

	public static void main(String[] args) {
		// db.createDatabase("bookstore");
		//db.runScript(RuntimeSettings.scriptSql);
	}

	public void createDatabase(String databaseName) {
		try {
			Statement stmt;

			// Register the JDBC driver for MySQL.
			Class.forName("com.mysql.jdbc.Driver");

			// Define URL of database server for
			// database named mysql on the localhost
			// with the default port number 3306.
			String url = "jdbc:mysql://localhost:3306/mysql";

			// Get a connection to the database for a
			// user named root with a blank password.
			// This user is the default administrator
			// having full privileges to do anything.
			Connection con = DriverManager.getConnection(url,
					RuntimeSettings.dbUserID, 
					RuntimeSettings.dbPassword);

			// Display URL and connection information
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);

			// Get a Statement object
			stmt = con.createStatement();

			// Create the new database after 1st dropping it if it exists
			stmt.executeUpdate("drop database if exists " + databaseName);

			stmt.executeUpdate("CREATE DATABASE " + databaseName);
			close(stmt);
			close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}// end catch
	}

	private static Connection getConnection(String dbName) {
		Connection conn;
		conn = getConnection();
		return conn;

	}

	private DB(String password, String dbname) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + dbname
							+ "?autoReconnect=true", "root", password);
		} catch (SQLException se) {
			//MyLog.myCatch("/java", 100, se);
			se.printStackTrace();
		} catch (ClassNotFoundException c) {
			//MyLog.myCatch("/java", 103, c);
			c.printStackTrace();
		}

	}

	public static DB getInstance(String password, String dbname) {
		return new DB(password, dbname);
	}

	public static ResultSet select(String query, Connection connection) {
		ResultSet result = null;
		Statement stmt = null;
		try {
			//MyLog.log("in readFromDB with query:\n" + query);
			if ((query.indexOf(" where ") >= 0)
					|| (query.indexOf("count ") >= 0)) {
				// ok
			} else {
				//MyLog.myIO("@@@ please check as query without a where clause!");
			}
			stmt = connection.createStatement();
			// System.out.println("in readFromDB inside result with query:\n" +
			// query);
			result = stmt.executeQuery(query);
			//MyLog.myIO("readFromDB sql:" + query);
		} catch (SQLException se) {
			//MyLog.myCatch("/java", 66, se);
		}
		return result;
	}

	
	public static int update(String sql) {

		int rowsUpdated = 0;
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(true);
			System.out.println("DB.java before");
			rowsUpdated = update(connection, sql);
			System.out.println("DB.java after"+rowsUpdated);
		} catch (SQLException ex) {
			//MyLog.myCatch("/java", 143, ex);
		} finally {
			close(connection);
		}
		return rowsUpdated;
	}

	
	public static int update(Connection connection, String sql) {
		Statement statement = null;
		int rows = 0;
		try {
			statement = connection.createStatement();
			System.out.println("update2 - DB.java" +sql);
			rows = statement.executeUpdate(sql);
			System.out.println("update2 - done DB.java");
		    System.out.println("updating " + rows + " rows for sql:" + sql + ":");
		} catch (SQLException ex) {
			System.out.println("caught in exception");
			//MyLog.myCatch("/update() while running sql:" + sql + ":", 79, ex);
		} finally {
			close(statement);
		}
		return rows;
	}

	public static void create(String sql)
	{
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(true);
			create(connection,sql);
		} catch (SQLException ex) {
		//	MyLog.myCatch("/java", 143, ex);
		} finally {
			close(connection);
		}
	}
	public static void create(Connection connection, String sql)
	{
		Statement statement = null;
		try{
			statement = connection.createStatement();
			statement.executeQuery(sql);
	//		MyLog.myIO("created table");
		}
		catch (SQLException e) {
			//MyLog.myCatch("/create() while running sql:" + sql + ":", 80, e);
		}
		finally {
			close(statement);
		}
	}
	public static void close(Connection connection) {
		// return;
		if (connection == null) {
			return;
		}
		try {
			if (connection.isClosed()) {
				connection = null;
			} else {
				try {
					connection.close();
				//	MyLog.log("closing a conn; total conn:" + activeConnections);
					connection = null;
				} catch (SQLException ex) {
				//	MyLog.myCatch("/java", 106, ex);
				}
			}
		} catch (SQLException ex) {
			//MyLog.myCatch("/java", 110, ex);
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {

			if (isSeekingConnectionFirstTime) {
				isSeekingConnectionFirstTime = false;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException ex) {
				//	MyLog.myCatch("/java", 162, ex);
				}
			}
			String connectionUrl = "jdbc:mysql://" + RuntimeSettings.SERVER_IP
					+ ":" + RuntimeSettings.portNo + "/"
					+ RuntimeSettings.databaseName
					+ "?zeroDateTimeBehavior=convertToNull";
			con = DriverManager.getConnection(connectionUrl,
					RuntimeSettings.dbUserID, RuntimeSettings.dbPassword);
		} catch (SQLException ex) {
		//	MyLog.myCatch("/java", 217, ex);
		}
		activeConnections++;
		//MyLog.log("in DBDataStandAlone added new tms conn; total connections:"
		//		+ activeConnections);
		return con;
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
				statement = null;
			} catch (SQLException ex) {
			//	MyLog.myCatch("/java", 202, ex);
			}
		}
	}

	public static void close(ResultSet rs) {
		// return;
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException ex) {
			//	MyLog.myCatch("/java", 214, ex);
			}
		}
	}

	public static void close(PreparedStatement preparedStmt) {
		if (preparedStmt != null) {
			try {
				preparedStmt.close();
				preparedStmt = null;
			} catch (SQLException ex) {
			//	MyLog.myCatch("/java", 225, ex);
			}
		}
	}

	public int runScript(String sqlStatement) {
		int rowsUpdated = update(sqlStatement);
		return rowsUpdated;
	}

	public int runScript(String[] sqlStatements) {
		for (int i = 0; i < sqlStatements.length; i++) {
			//MyLog.log("running sql:" + sqlStatements[i]);
			runScript(sqlStatements[i]);
		}
		return 1;
	}

	
}
