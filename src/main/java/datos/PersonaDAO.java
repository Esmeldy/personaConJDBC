package datos;

import domain__entity.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

public interface PersonaDao {
    public List<PersonaDTO> getPersonas();
    public int insert(PersonaDTO persona) throws SQLException;
    public int update(PersonaDTO persona) throws SQLException;
    public int delete(PersonaDTO persona) throws SQLException;
}
