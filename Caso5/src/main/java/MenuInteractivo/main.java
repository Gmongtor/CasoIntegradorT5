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
        JButton btnHerramientasAnalisisNumerico = new JButton("HerramientasAnalisisNumerico");
        btnHerramientasAnalisisNumerico.setBounds(10, 340, 250, 25);
        panel.add(btnHerramientasAnalisisNumerico);

        btnHerramientasAnalisisNumerico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog();
                dialog.setTitle("Herramientas de Análisis Numérico");
                dialog.setSize(300, 400);
                dialog.setLayout(null);

                JButton btnSumatoria = new JButton("Sumatoria");
                btnSumatoria.setBounds(50, 10, 200, 25);
                dialog.add(btnSumatoria);

                btnSumatoria.addActionListener(e1 -> {
                    String input = JOptionPane.showInputDialog("Introduce un número:");
                    try {
                        int n = Integer.parseInt(input);
                        int resultado = HerramientasAnalisisNumerico.sumatoria(n);
                        JOptionPane.showMessageDialog(null, "La sumatoria de " + n + " es: " + resultado);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido.");
                    }
                });

                JButton btnListarNumeros = new JButton("Listar Números");
                btnListarNumeros.setBounds(50, 50, 200, 25);
                dialog.add(btnListarNumeros);

                // Implementa la acción de este botón según tu necesidad

                JButton btnCalcularPotencia = new JButton("Calcular Potencia");
                btnCalcularPotencia.setBounds(50, 90, 200, 25);
                dialog.add(btnCalcularPotencia);

                btnCalcularPotencia.addActionListener(e12 -> {
                    String baseStr = JOptionPane.showInputDialog("Introduce la base:");
                    String exponenteStr = JOptionPane.showInputDialog("Introduce el exponente:");
                    try {
                        int base = Integer.parseInt(baseStr);
                        int exponente = Integer.parseInt(exponenteStr);
                        int resultado = HerramientasAnalisisNumerico.calcularPotencia(base, exponente);
                        JOptionPane.showMessageDialog(null, "El resultado de " + base + "^" + exponente + " es: " + resultado);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, introduce números válidos.");
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                });

                JButton btnEncontrarMaximo = new JButton("Encontrar Máximo");
                btnEncontrarMaximo.setBounds(50, 130, 200, 25);
                dialog.add(btnEncontrarMaximo);

                // Implementa la acción de este botón según tu necesidad

                dialog.setLocationRelativeTo(null); // Centrar el dialog respecto a la aplicación
                dialog.setVisible(true);
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