package MenuInteractivo.GestionInformacionCientífica;

import java.io.*;
import java.util.*;

public class OrganizadorDocumentos {

    public static void ordenarArchivo(String rutaArchivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        ArrayList<String> lineas = new ArrayList<>();
        String linea;

        while ((linea = reader.readLine()) != null) {
            lineas.add(linea);
        }
        reader.close();

        Collections.sort(lineas);

        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
        for (String lineaOrdenada : lineas) {
            writer.write(lineaOrdenada);
            writer.newLine();
        }
        writer.close();
    }
}
