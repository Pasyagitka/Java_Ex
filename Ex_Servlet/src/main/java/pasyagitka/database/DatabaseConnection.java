package pasyagitka.database;

import pasyagitka.model.Book;
import pasyagitka.model.DBList;

import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    ResultSet rs;
    PreparedStatement stmt;
    public final Connection connection;

    public static DatabaseConnection getInstance()
    {
        if ( instance != null) return instance;
        instance = new DatabaseConnection();
        return instance;
    }
    private DatabaseConnection()
    {
        //todo connection properties to file
        DAOFactory daoFactory = new DAOFactory("jdbc:sqlserver://localhost;database=Ex_Book;integratedSecurity=true");
        connection = daoFactory.getConnection();
    }
    public DBList getRecordsFromDB()
    {
        String sql = "select * from Book";
        DBList recordList = DBList.getInstance();
        recordList.clear();
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            rs = stm.executeQuery();
            while (rs.next()) {
                Book item = new Book(
                        rs.getString("book_name"),
                        rs.getString("author"),
                        rs.getInt("publication_year"),
                        rs.getInt("pages")
                );
                recordList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }
}
