package TEMA01.Optioal;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Optional<Double> res = calcularMedia(5d,6d,8d,9d,10d);
        //Antes de acceder comprovamos si el resultado esta lleno o no
        //y si lo esta continuamos
        if (res.isPresent()) {
            //Asi
            Double resMedia = res.get();
            System.out.println(resMedia);
            //o asi
            //System.out.println(res.get());
        }else System.out.println("Nada");

    }

    //Cuando se ponen tres puntos se considera como un array
    private static Optional<Double> calcularMedia(Double ...notas) {

        if (notas.length == 0){
            return Optional.empty();
        }else {
            double sum = 0;
            for (Double nota: notas) sum += nota;
            return Optional.of(sum/notas.length);
        }

    }

}
