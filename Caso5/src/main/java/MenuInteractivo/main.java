package MenuInteractivo;

import MenuInteractivo.AnalisisGenomico.GeneCounter;
import MenuInteractivo.AnalisisGenomico.GeneticCombinations;
import MenuInteractivo.GestionInformacionCientífica.GestionFechas;
import MenuInteractivo.GestionInformacionCientífica.BusquedaTexto;
import MenuInteractivo.GestionInformacionCientífica.OrganizadorDocumentos;
import MenuInteractivo.AnalisisNumerico.HerramientasAnalisisNumerico;
import MenuInteractivo.Optimizacion.QuickSortOptimizado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Interactivo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton geneCounterButton = new JButton("GeneCounter");
        geneCounterButton.setBounds(10, 10, 80, 25);
        panel.add(geneCounterButton);

        geneCounterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adn = JOptionPane.showInputDialog("Introduce la secuencia de ADN:");
                int count = GeneCounter.contarGenes(adn);
                JOptionPane.showMessageDialog(null, "El número de genes es: " + count);
            }
        });

        // Aquí puedes agregar más botones para las demás clases
        // Asegúrate de ajustar las posiciones y tamaños de los botones según sea necesario

        // Botón para GeneticCombinations
        JButton geneticCombinationsButton = new JButton("GeneticCombinations");
        geneticCombinationsButton.setBounds(10, 40, 150, 25);
        panel.add(geneticCombinationsButton);

        geneticCombinationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genes = JOptionPane.showInputDialog("Introduce los genes separados por comas:");
                List<String> geneList = Arrays.asList(genes.split(","));
                List<List<String>> combinations = GeneticCombinations.generarCombinaciones(geneList);
                JOptionPane.showMessageDialog(null, "Las combinaciones de genes son: " + combinations);
            }
        });
        JButton gestionFechasButton = new JButton("GestionFechas");
        gestionFechasButton.setBounds(10, 70, 150, 25);
        panel.add(gestionFechasButton);

        gestionFechasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestionFechas gestionFechas = new GestionFechas();
                // Aquí puedes agregar la lógica para interactuar con la clase GestionFechas
            }
        });

// Botón para BusquedaTexto
        JButton busquedaTextoButton = new JButton("BusquedaTexto");
        busquedaTextoButton.setBounds(10, 100, 150, 25);
        panel.add(busquedaTextoButton);

        busquedaTextoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para interactuar con la clase BusquedaTexto
            }
        });

// Botón para OrganizadorDocumentos
        JButton organizadorDocumentosButton = new JButton("OrganizadorDocumentos");
        organizadorDocumentosButton.setBounds(10, 130, 200, 25);
        panel.add(organizadorDocumentosButton);

        organizadorDocumentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para interactuar con la clase OrganizadorDocumentos
            }
        });

// Botón para HerramientasAnalisisNumerico
        JButton herramientasAnalisisNumericoButton = new JButton("HerramientasAnalisisNumerico");
        herramientasAnalisisNumericoButton.setBounds(10, 160, 250, 25);
        panel.add(herramientasAnalisisNumericoButton);

        herramientasAnalisisNumericoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para interactuar con la clase HerramientasAnalisisNumerico
            }
        });

// Botón para QuickSortOptimizado
        JButton quickSortOptimizadoButton = new JButton("QuickSortOptimizado");
        quickSortOptimizadoButton.setBounds(10, 190, 200, 25);
        panel.add(quickSortOptimizadoButton);

        quickSortOptimizadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para interactuar con la clase QuickSortOptimizado
            }
        });
    }
}