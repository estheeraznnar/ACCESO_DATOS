package modelo;

import java.util.Comparator;

public class ProfesorNombreComparator implements Comparator<Profesor> {



    @Override
    public int compare(Profesor o1, Profesor o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }

}
