package TEMA01.Fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        //Date
        Calendar c = Calendar.getInstance();
        c.set(2022, Calendar.JANUARY, 1);

        LocalDate date = LocalDate.of(2022, Month.JANUARY, 1); //inmutable

        //String
        String texto = "Hola Mundo"; //No se puede cambiar nada es inmutable

        //horas: Times Inmutables
        LocalTime hora = LocalTime.of(10, 0);
        LocalDateTime fechaHora = LocalDateTime.of(date, hora);
        LocalDateTime fechaHora2 = LocalDateTime.of(2025, 9, 25, 10, 9);

        LocalDateTime haceUnaSemana = fechaHora.minusDays(300);
        System.out.println(haceUnaSemana);

        String fechaFormat = haceUnaSemana.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(fechaFormat);



    }

}
