package MenuInteractivo;

import MenuInteractivo.AnalisisGenomico.GeneCounter;
import MenuInteractivo.AnalisisGenomico.GeneticCombinations;
import MenuInteractivo.AnalisisNumerico.HerramientasAnalisisNumerico;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menú Interactivo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new FlowLayout());
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        JButton analisisGenomicoButton = new JButton("Análisis Genómico");
        panel.add(analisisGenomicoButton);
        analisisGenomicoButton.addActionListener(e -> handleAnalisisGenomico());

        JButton herramientasCientificasButton = new JButton("Herramientas Análisis Numérico");
        panel.add(herramientasCientificasButton);
        herramientasCientificasButton.addActionListener(e -> handleHerramientasAnalisisNumerico());
    }

    private static void handleAnalisisGenomico() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Análisis Genómico");
        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 200);

        JButton contarGenesButton = new JButton("Contar Genes");
        dialog.add(contarGenesButton);
        contarGenesButton.addActionListener(e -> {
            String adn = JOptionPane.showInputDialog("Introduce la secuencia de ADN:");
            int count = GeneCounter.contarGenes(adn);
            JOptionPane.showMessageDialog(null, "Número de genes encontrados: " + count);
        });

        JButton generarCombinacionesButton = new JButton("Generar Combinaciones");
        dialog.add(generarCombinacionesButton);
        generarCombinacionesButton.addActionListener(e -> {
            String genesStr = JOptionPane.showInputDialog("Introduce los genes separados por comas:");
            List<String> genes = Arrays.asList(genesStr.split(","));
            List<List<String>> combinaciones = GeneticCombinations.generarCombinaciones(genes);
            JOptionPane.showMessageDialog(null, "Combinaciones generadas: " + combinaciones);
        });

        dialog.pack();
        dialog.setVisible(true);
    }
    private static void handleHerramientasAnalisisNumerico() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Herramientas de Análisis Numérico");
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(0, 1));

        JButton btnSumatoria = new JButton("Sumatoria");
        btnSumatoria.addActionListener(e -> performSumatoria());
        dialog.add(btnSumatoria);

        JButton btnListarNumeros = new JButton("Listar Números");
        btnListarNumeros.addActionListener(e -> performListarNumeros());
        dialog.add(btnListarNumeros);

        JButton btnCalcularPotencia = new JButton("Calcular Potencia");
        btnCalcularPotencia.addActionListener(e -> performCalcularPotencia());
        dialog.add(btnCalcularPotencia);

        JButton btnEncontrarMaximo = new JButton("Encontrar Máximo");
        btnEncontrarMaximo.addActionListener(e -> performEncontrarMaximo());
        dialog.add(btnEncontrarMaximo);

        dialog.pack();
        dialog.setVisible(true);
    }

    // Métodos para realizar cada acción
    private static void performSumatoria() {
        String input = JOptionPane.showInputDialog("Introduce un número para la sumatoria:");
        try {
            int n = Integer.parseInt(input);
            int resultado = HerramientasAnalisisNumerico.sumatoria(n);
            JOptionPane.showMessageDialog(null, "La sumatoria de " + n + " es: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido.");
        }
    }

    private static void performListarNumeros() {
        // La implementación asume que listarNumeros devuelve un String
        int inicio = Integer.parseInt(JOptionPane.showInputDialog("Número inicial:"));
        int fin = Integer.parseInt(JOptionPane.showInputDialog("Número final:"));
        JOptionPane.showMessageDialog(null, "Números listados:\n" + HerramientasAnalisisNumerico.listarNumeros(inicio, fin));
    }

    private static void performCalcularPotencia() {
        int base = Integer.parseInt(JOptionPane.showInputDialog("Base:"));
        int exponente = Integer.parseInt(JOptionPane.showInputDialog("Exponente:"));
        JOptionPane.showMessageDialog(null, "Resultado: " + HerramientasAnalisisNumerico.calcularPotencia(base, exponente));
    }

    private static void performEncontrarMaximo() {
        // Asume que encontrarMaximo ahora no requiere el índice inicial y devuelve el máximo directamente
        String[] datosStr = JOptionPane.showInputDialog("Introduce números separados por comas:").split(",");
        int[] datos = Arrays.stream(datosStr).mapToInt(Integer::parseInt).toArray();
        JOptionPane.showMessageDialog(null, "El máximo es: " + HerramientasAnalisisNumerico.encontrarMaximo(datos, 0));
    }
}



