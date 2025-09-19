public class Salvajes {

    public static void main(String[] args) {

        Contenedor<String> stringContenedor = new Contenedor<>("Hola mundo");
        Contenedor<Integer> integerContenedor = new Contenedor<>(10);

        imprimir(stringContenedor);
        imprimir(integerContenedor);
        imprimirNumeroDouble(integerContenedor); // *2 y que acabe siendo tipo double
        imprimirConMuntiplicador(integerContenedor, 5);

    }

    private static void imprimirConMuntiplicador(Contenedor<Integer> c, int multiplicador) {
        System.out.println(c.getObjeto().intValue()*multiplicador);
    }

    private static void imprimirNumeroDouble(Contenedor<Integer> c) {
        System.out.println(c.getObjeto().doubleValue() * 2);
    }

    //El ? es el salvaje y te deja poner lo que quieras
    private static void imprimir(Contenedor<?> c) {
        System.out.println(c.getObjeto());
    }

}

class Contenedor <T>{
    private T objeto;

    public Contenedor(T objeto) {
        this.objeto = objeto;
    }

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
                "objeto=" + objeto +
                '}';
    }
}