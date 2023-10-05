package domain__entity;

public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Persona() {
    }

    /**
     * Para eliminar un registro por su ID solo necesitamos su Id
     * @param id
     */
    public Persona(Long id) {
        this.id = id;
    }


    /**
     * Para crear un registro no es necesario su ID
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     */
    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    /**
     * Para modificar un registro necesitamos todos sus campos
     * @param id
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     */
    public Persona(Long id, String nombre, String apellido, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
