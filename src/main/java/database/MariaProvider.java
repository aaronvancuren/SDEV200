package database;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class MariaProvider
{
    private final Connection connection;

    public MariaProvider(DatabaseConnection databaseConnection)
    {
        try
        {
            System.out.println("Loading driver...");
            Class.forName(databaseConnection.getJdbcDrive()); //org.mariadb.jdbc.Driver
            System.out.println("Driver loaded!");

            System.out.println("Connecting to database...");
            StringBuilder sb = new StringBuilder();
            sb.append(databaseConnection.getDatabaseUrl());
            if (!(databaseConnection.getUsername().isBlank() && databaseConnection.getUsername().isEmpty()))
            {
                sb.append("?user=").append(databaseConnection.getUsername());
            }

            if (!(databaseConnection.getPassword().isBlank() && databaseConnection.getPassword().isEmpty()))
            {
                sb.append("?password=").append(databaseConnection.getPassword());
            }

            connection = DriverManager.getConnection(
                    sb.toString()); // jdbc:mariadb://localhost:3306/db?user=username?password=password
            System.out.println("Database connected!");
        }
        catch (ClassNotFoundException e)
        {
            throw new IllegalStateException("Cannot find the driver for MariaDB.", e);
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Cannot connect to " + databaseConnection.getDatabaseUrl() + " database.",
                                            e);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public BigInteger updateBatch()
    {
        LocalDateTime dt = LocalDateTime.now();
        try
        {
            Statement statement = connection.createStatement();
            for (int i = 0; i < 1000; i++)
            {
                statement.addBatch(insertStatement());
            }

            statement.executeBatch();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


        return BigInteger.valueOf(LocalDateTime.now().getNano() - dt.getNano());
    }

    public BigInteger updateNonBatch()
    {
        LocalDateTime dt = LocalDateTime.now();
        try
        {
            Statement statement = connection.createStatement();
            for (int i = 0; i < 1000; i++)
            {
                statement.execute(insertStatement());
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


        return BigInteger.valueOf(LocalDateTime.now().getNano() - dt.getNano());
    }

    private String insertStatement()
    {
        return " INSERT INTO temp " + " (num1, num2, num3) " + " VALUES ( " + Math.random() + "," + Math.random() + "," + Math.random() + ")";
    }
}
