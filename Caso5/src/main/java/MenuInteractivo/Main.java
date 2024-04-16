package MenuInteractivo;

import MenuInteractivo.AnalisisGenomico.GeneCounter;
import MenuInteractivo.AnalisisGenomico.GeneticCombinations;
import MenuInteractivo.AnalisisNumerico.HerramientasAnalisisNumerico;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menú Interactivo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new FlowLayout());

        // Botón de Análisis Genómico
        JButton analisisGenomicoButton = new JButton("Análisis Genómico");
        panel.add(analisisGenomicoButton);
        analisisGenomicoButton.addActionListener(e -> handleAnalisisGenomico());
        JButton HerramientasCientificasButton = new JButton("Herramientas Analisis Numerico");
        panel.add(HerramientasCientificasButton);
        HerramientasCientificasButton.addActionListener(e -> handleHerramientasAnalisisNumerico());
    }
    private static void handleHerramientasAnalisisNumerico() {
        // Sumatoria
        String inputSumatoria = JOptionPane.showInputDialog("Introduce un número para la sumatoria:");
        try {
            int n = Integer.parseInt(inputSumatoria);
            int sumatoria = HerramientasAnalisisNumerico.sumatoria(n);
            JOptionPane.showMessageDialog(null, "La sumatoria de " + n + " es: " + sumatoria);

            // Listar números
            int inicio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número inicial:"));
            int fin = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número final:"));
            JOptionPane.showMessageDialog(null, "Los números listados son:\n" + HerramientasAnalisisNumerico.listarNumeros(inicio, fin)); // Asumiendo que cambiarás listarNumeros para que devuelva String

            // Calcular potencia
            int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base:"));
            int exponente = Integer.parseInt(JOptionPane.showInputDialog("Introduce el exponente:"));
            int potencia = HerramientasAnalisisNumerico.calcularPotencia(base, exponente);
            JOptionPane.showMessageDialog(null, "El resultado de " + base + "^" + exponente + " es: " + potencia);

            // Encontrar máximo
            String[] datosStr = JOptionPane.showInputDialog("Introduce números separados por comas para encontrar el máximo:").split(",");
            int[] datos = Arrays.stream(datosStr).mapToInt(Integer::parseInt).toArray(); // Corrección aquí
            int maximo = HerramientasAnalisisNumerico.encontrarMaximo(datos, 0);
            JOptionPane.showMessageDialog(null, "El máximo es: " + maximo);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce números válidos.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private static void handleAnalisisGenomico() {
        // Crear y configurar el diálogo para análisis genómico
        JDialog dialog = new JDialog();
        dialog.setTitle("Análisis Genómico");
        dialog.setSize(300, 200);
        dialog.setLayout(new FlowLayout());

        // Botón para contar genes
        JButton contarGenesButton = new JButton("Contar Genes");
        dialog.add(contarGenesButton);
        contarGenesButton.addActionListener(e -> {
            String adn = JOptionPane.showInputDialog("Introduce la secuencia de ADN:");
            int count = GeneCounter.contarGenes(adn);
            JOptionPane.showMessageDialog(null, "Número de genes encontrados: " + count);
        });

        // Botón para generar combinaciones
        JButton generarCombinacionesButton = new JButton("Generar Combinaciones");
        dialog.add(generarCombinacionesButton);
        generarCombinacionesButton.addActionListener(e -> {
            String genesStr = JOptionPane.showInputDialog("Introduce los genes separados por comas:");
            List<String> genes = Arrays.asList(genesStr.split(","));
            List<List<String>> combinaciones = GeneticCombinations.generarCombinaciones(genes);
            JOptionPane.showMessageDialog(null, "Combinaciones generadas: " + combinaciones.toString());
        });

        dialog.setVisible(true);
    }
}

