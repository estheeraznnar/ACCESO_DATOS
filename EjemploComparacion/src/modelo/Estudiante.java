package modelo;

public class Estudiante implements Comparable<Estudiante>{

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

    public Estudiante() {
    }

    public Estudiante(int id, String nombre) {
        this.id = id;
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }

    @Override
    public int compareTo(Estudiante o) {
        return this.id - o.id;
    }

}
