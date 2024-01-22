package de.stundenplan.tests.inserts;

import de.stundenplan.ConnectionPool;
import de.stundenplan.tests.Testcase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JahrgangGenerator extends Testcase{

    @Override
    public String getName() {
        return "JahrgangGenerator";
    }

    @Override
    public void test() throws SQLException {
        Connection con = ConnectionPool.getConnectionPool().getRootConnection();
        int jahre = 50;
        int startjahr = 2025;

        try {
            for (int i = 0; i < jahre; i++) {
                int jahrgang = startjahr + i;

                String sql = "INSERT INTO D_Jahrgang (jahrgang) VALUES (?)";
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setInt(1, jahrgang);
                statement.executeUpdate();
            }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Con nicht schließen
        System.out.println("Jahrgänge erzeugt");
    }
    }
}
