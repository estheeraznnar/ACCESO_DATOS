package modelo;

/*Lee una lista de empleados desde un archivo de texto llamado employees.txt. Cada linea del archivo
contiene informacion sobre un empleado con el siguiente formato: Nombre, Apellido, Edad, Salario.

Realiza las siguientes busquedas usando lambdas y Streams:
- Filtrar los empleados cuya edad esten entre 20 y 40 y cuyo salario sea mayor o igual a 50000
-Ordena los empleados filtrados por salario de manera descendemte
-Guarda la lista resultante en un archivo llamado "filter employees.txt" en el mismo formato que el archivo de entrada
 */
public class Empleado {
    private String nombre;
//    private String apellido;
    private int edad;
    private double salario;

    public Empleado() {
    }

    public Empleado(String nombre,/* String apellido,*/ int edad, double salario) {
        this.nombre = nombre;
//        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

//    public String getApellido() {
//        return apellido;
//    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public void setApellido(String apellido) {
//        this.apellido = apellido;
//    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
//                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                '}';
    }
}
