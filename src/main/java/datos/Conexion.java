package datos;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/aj_persona_test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "esmeldyjava";
    private static final String JDBC_PASSWORD = "Ajava*";

    public static DataSource getDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(JDBC_URL);
        basicDataSource.setUsername(JDBC_USER);
        basicDataSource.setPassword(JDBC_PASSWORD);
        //Tamaño inicial de conexiones abiertas
        basicDataSource.setInitialSize(5);
        return basicDataSource;
    }
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
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
