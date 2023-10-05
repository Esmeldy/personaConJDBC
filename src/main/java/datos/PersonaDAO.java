package datos;

import domain__entity.PersonaDTO;
import domain__entity.PersonaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static datos.Conexion.*;

public class PersonaDAO implements PersonaDao {
    private static final String SQL_SELECT = "SELECT id, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id = ? ";

    private static final String SQL_DELETE = "DELETE FROM persona WHERE id = ?";
    /**
     * Método que devuelve la lista de personas de la BD
     * @return
     */
    public List<PersonaDTO> getPersonas(){
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new PersonaDTO(id, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                close(rs);
                close(pstmt);
                close(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return personas;
    }

    public int insert(PersonaDTO persona){
        Connection con = null;
        int registros = 0;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, persona.getNombre());
            pstmt.setString(2, persona.getApellido());
            pstmt.setString(3, persona.getEmail());
            pstmt.setString(4, persona.getTelefono());

            registros = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        finally {
            try {
                close(pstmt);
                close(con);
            } catch (SQLException e) {
                e.getStackTrace();
            }
        }

        return registros;
    }

    public int update(PersonaDTO persona){
        Connection con = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;

        try {
            con = getConnection();
            preparedStatement = con.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellido());
            preparedStatement.setString(3, persona.getEmail());
            preparedStatement.setString(4, persona.getTelefono());
            preparedStatement.setLong(5, persona.getId());

            registros = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        finally {
            try {
                close(preparedStatement);
                close(con);
            } catch (SQLException e) {
                e.getStackTrace();
            }
        }

        return registros;
    }

    public int delete(PersonaDTO persona){
        Connection con = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;

        try {
            con = getConnection();
            preparedStatement = con.prepareStatement(SQL_DELETE);
            preparedStatement.setLong(1, persona.getId());

            registros = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        finally {
            try {
                close(preparedStatement);
                close(con);
            } catch (SQLException e) {
                e.getStackTrace();
            }
        }

        return registros;
    }

}
