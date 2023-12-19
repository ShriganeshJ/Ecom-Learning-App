package com.durga.trywith;

import java.sql.*;

public class TryWithResourceEnhance_J9 {
    public static void main(String[] args) throws SQLException {
        int count =0;
        Connection connection = DriverManager.getConnection("");
        PreparedStatement ps = connection.prepareStatement("");
        ResultSet rs = ps.executeQuery();
        try(connection;ps;rs)
        {
            while (rs.next())
            {
                count++;
            }
        }
    }
}
