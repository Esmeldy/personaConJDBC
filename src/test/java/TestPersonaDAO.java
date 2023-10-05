import datos.PersonaDaoJDBC;
import domain__entity.PersonaDTO;
import datos.PersonaDao;

import java.util.List;

public class TestPersonaDAO {
    public static void main(String[] args) {
        PersonaDao personaDAO = new PersonaDaoJDBC();
        PersonaDTO persona = new PersonaDTO(
                "Mariano",
                "Rajoy",
                "mrajoy@Gmail.com",
                "969669596"
        );

     //   personaDAO.insert(persona);
        List<PersonaDTO> personaDTOList = personaDAO.getPersonas();
        personaDTOList.forEach(System.out::println);
    }
}
