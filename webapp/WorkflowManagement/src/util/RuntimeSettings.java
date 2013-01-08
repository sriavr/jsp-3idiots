package util;

public class RuntimeSettings {
	public static final String APPLICATION_NAME = "WorkFlowManagement";
	public static final String VERSION_ID = " version 1.0"
			+ " dated October 28, 2012";
	public static final String SERVER_IP = "localhost";
	static String databaseName = "workflowdb";
	static String dbUserID = "root";
	// "" for apple Macbook Air
	static String dbPassword = "root"; 
	public static String RUN_MODE = "Test"; // "Production"; //
	public static boolean IS_IN_DEBUG_MODE = true; // false; //
	static int portNo = 3306;// 5432; //
}
