package Lambda;

/*Calculadora con funciones lambda: Crea una interfaz funcional “Calculator” con un
metodo “calculate()”. Este metodo debe tomar dos números enteros y devolver un
número entero. Luego, en tu metodo “main()”, crea varias instancias de “Calculator”
utilizando funciones lambda para implementar operaciones como suma, resta,
multiplicación y división. Finalmente, prueba tus calculadoras con algunos números.*/
public class MainEjer01 {

    //Tambien se puede hacer poniendo aqui directamente la interfaz sin hacer una interfaz aparte
   /* interface Calculator{
        void Calculate ( int a, int b);
    }*/

    public static void main(String[] args) {

        Calculator01 Suma = (a, b) -> a+b;
        Calculator01 Resta = (a, b) -> a-b;
        Calculator01 Divi = (a, b) -> a/b;
        Calculator01 Multi = (a, b) -> a*b;

        System.out.println("Suma: " + Suma.calculate(5, 3));
        System.out.println("Resta: " + Resta.calculate(5, 3));
        System.out.println("Division: " + Divi.calculate(5, 3));
        System.out.println("Multiplicacion: " + Multi.calculate(5, 3));

    }

}
