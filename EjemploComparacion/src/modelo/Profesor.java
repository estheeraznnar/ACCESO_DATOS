package modelo;

public class Profesor { //POJO

    //DATOS
    int id;
    String Nombre;

    //CONSTRUCTOR
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Profesor() {
    }

    public Profesor(int id, String nombre) {
        this.id = id;
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }

}
