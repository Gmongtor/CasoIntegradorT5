package GestionInformacionCientífica;

import java.time.LocalDate;
import java.util.*;

public class GestionFechas {

    private ArrayList<LocalDate> fechas = new ArrayList<>();

    public void agregarFecha(LocalDate fecha) {
        fechas.add(fecha);
        Collections.sort(fechas);
    }

    public void listarFechas() {
        for (LocalDate fecha : fechas) {
            System.out.println(fecha);
        }
    }
}

