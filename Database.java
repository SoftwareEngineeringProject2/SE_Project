package teamProject;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Database
{
private Connection conn;

/**
* Default constructor. Reads the db.properties file and initializes the
* Connection private data field.
*/
public Database()
{
// Read the properties file
Properties prop = new Properties();
try {
FileInputStream fis = new FileInputStream("/Users/ZackH/eclipse-workspace/Chess/db.properties");
prop.load(fis);
} catch (IOException e) {
System.out.println("Error loading properties file.");
System.exit(1);}

String url = prop.getProperty("url");
String user = prop.getProperty("user");
String password = prop.getProperty("password");

// Connect to the database

try {
conn = DriverManager.getConnection(url, user, password);
} catch (SQLException e) {
System.out.println("Error connecting to database.");
/*System.exit(1);*/ } }


/**
* Creates a JDBC Statement object that executes the passed-in query and
* returns an ArrayList of Strings representing the ResultSet containing all
* the data matching the query.
*
* @param query A SQL query.
* @return An ArrayList of Strings, where each String is a comma-delimited
* record, or null if an exception occurs or the ResultSet is empty.
*/
public ArrayList<String> query(String query)
{
try {
// Execute the query
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
ResultSetMetaData rmd = rs.getMetaData();

// Get the records in the result set as Strings
ArrayList<String> ret = new ArrayList<String>();
int noColumns = rmd.getColumnCount();
while (rs.next()) {
StringBuilder record = new StringBuilder();
for (int i = 1; i <= noColumns; i++) {
record.append(rs.getString(i));
if (i < noColumns) {
record.append(",");
}}
ret.add(record.toString());
}

// Return the accumulated Strings
if (ret.isEmpty()) {
return null;
}
return ret;
} catch (SQLException e) {
return null;
}
}

/**
* Creates a JDBC Statement object that executes the passed-in DML
* statement.
*
* @param dml A DML statement.
* @throws SQLException If the statement fails.
*/
public void executeDML(String dml) throws SQLException
{
Statement stmt = conn.createStatement();
stmt.execute(dml);
}

// Private data field for storing a HashMap of usernames and passwords.
HashMap<String, String> database;

// Method for verifying a username and password.
public boolean verifyAccount(String username, String password)
{
  // Read the database.
  if (query("select username from users where username="+username) == null)
  // Stop if this account doesn't exist.
    return false;
  
  // Check the username and password.
  if (query("select username from users where username="+username+"and password="+password) == null) 
    return false;
  else
    return true;
}

// Method for creating a new account.
public boolean createNewAccount(String username, String password)
{

  
  // Stop if this account already exists.
	 if (query("select username from users where username="+username) == null)
		  // Stop if this account doesn't exist.
		    return false;
  
  // Add the new account.
	 try {
		executeDML("insert into users\n"
		 		+ "	values('"+username+"', aes_encrypt('"+password+"', 'key'));");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  

  return true;
}}