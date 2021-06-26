package pasyagitka.database;
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
        DAOFactory daoFactory = new DAOFactory("jdbc:sqlserver://localhost;database=Ex_Like;integratedSecurity=true");
        connection = daoFactory.getConnection();
    }
}
