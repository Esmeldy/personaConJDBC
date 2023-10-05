import datos.PersonaDaoJDBC;
import domain__entity.PersonaDTO;
import datos.PersonaDao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class TestPersonaDAO {
    public static void main(String[] args) {
        PersonaDao personaDAO = new PersonaDaoJDBC();
        PersonaDTO persona = new PersonaDTO(
                "Luka",
                "Modrid",
                "lmod@Gmail.com",
                "999669596"
        );

        try {
            personaDAO.insert(persona);
        } catch (SQLException e) {
            System.out.println("Error en la BBDD"+ Arrays.toString(e.getStackTrace()));
        }
        List<PersonaDTO> personaDTOList = personaDAO.getPersonas();
        personaDTOList.forEach(System.out::println);
    }
}
