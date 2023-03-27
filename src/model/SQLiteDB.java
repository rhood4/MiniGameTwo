package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteDB extends model.DB {

    /**
     * Constructor: SQLiteDB
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public SQLiteDB() throws SQLException, ClassNotFoundException {
        //Build the connection String
        sJdbc = "jdbc:sqlite";
        sDriverName = "org.sqlite.JDBC";
        // register the driver
        Class.forName(sDriverName);
        sDbUrl = sJdbc + ":" + dbName;
        conn = DriverManager.getConnection(sDbUrl);
    }

    /**
     * Constructor: SQLiteDB
     *
     * @param dbName
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public SQLiteDB(String dbName) throws SQLException, ClassNotFoundException {
        //Build the connection String
        sJdbc = "jdbc:sqlite";
        sDriverName = "org.sqlite.JDBC";
        // register the driver
        Class.forName(sDriverName);
        sDbUrl = sJdbc + ":" + dbName;

        this.dbName = dbName;
        conn = DriverManager.getConnection(sDbUrl);
    }

    /**
     * Method: close
     * Purpose: Close the database connection
     *
     * @return void
     * @throws SQLException
     */
    public void close() throws SQLException {
        SQLiteDB conn = null;
        conn.close();
    }

    public int getMaxValue(String roomNumber, String room) {
        return 0;
    }

    public ResultSet queryDB(String sql) {
        return null;
    }
}

