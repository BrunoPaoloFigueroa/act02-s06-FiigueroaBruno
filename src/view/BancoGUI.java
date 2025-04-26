
package view;

import controller.BancoController;
import model.CuentaAhorro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoGUI extends JFrame {
    private JComboBox<String> tipoCuentaCombo;
    private JTextField montoField;
    private JTextField tutorField;
    private JTextArea detallesTextArea;
    private BancoController controller = new BancoController();

    public BancoGUI() {
        setTitle("Sistema Bancario - MVC + Factory Method");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel(new GridLayout(4, 2, 5, 5));

        panelSuperior.add(new JLabel("Tipo de Cuenta:"));
        tipoCuentaCombo = new JComboBox<>(new String[]{
                "Ahorro Sueldo", "Ahorro Digital", "Ahorro Mancomunada", "Plazo Fijo", "Cuenta para Menores"
        });
        panelSuperior.add(tipoCuentaCombo);

        panelSuperior.add(new JLabel("Monto Inicial:"));
        montoField = new JTextField("100.00");
        panelSuperior.add(montoField);

        panelSuperior.add(new JLabel("Tutor (si aplica):"));
        tutorField = new JTextField();
        panelSuperior.add(tutorField);

        JButton crearBtn = new JButton("Crear Cuenta");
        crearBtn.addActionListener(new CrearCuentaListener());
        panelSuperior.add(crearBtn);

        add(panelSuperior, BorderLayout.NORTH);

        detallesTextArea = new JTextArea();
        detallesTextArea.setEditable(false);
        add(new JScrollPane(detallesTextArea), BorderLayout.CENTER);
    }

    private class CrearCuentaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String tipo = (String) tipoCuentaCombo.getSelectedItem();
                double monto = Double.parseDouble(montoField.getText());
                String tutor = tutorField.getText().isEmpty() ? null : tutorField.getText();

                CuentaAhorro cuenta = controller.crearCuenta(tipo, monto, tutor);

                StringBuilder detalles = new StringBuilder();
                detalles.append("=== Cuenta Creada ===\n")
                        .append("Tipo: ").append(cuenta.getTipo()).append("\n")
                        .append("Tasa: ").append(cuenta.getTasaInteres()).append("%\n")
                        .append("Saldo: $").append(cuenta.getMonto()).append("\n")
                        .append("Titulares: ").append(cuenta.getCantidadTitulares()).append("\n");

                if (cuenta.getTutor() != null) {
                    detalles.append("Tutor: ").append(cuenta.getTutor()).append("\n");
                }

                detallesTextArea.setText(detalles.toString());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(BancoGUI.this, "Monto inválido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(BancoGUI.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BancoGUI().setVisible(true));
    }
}
