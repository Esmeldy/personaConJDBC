package datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/aj_persona_test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "esmeldyjava";
    private static final String JDBC_PASSWORD = "Ajava*";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    public static void close(Statement st) throws SQLException{
        st.close();
    }
    public static void close(PreparedStatement st) throws SQLException{
        st.close();
    }

    public static void close(Connection con) throws SQLException{
        con.close();
    }
}
