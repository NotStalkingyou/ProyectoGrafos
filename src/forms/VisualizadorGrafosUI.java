package forms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.GraphPanel;

public class VisualizadorGrafosUI extends JFrame {
    private GraphPanel graphPanel;
    private JPanel mainPanel;
    private JPanel controlPanel;
    private JButton btnAgregarPersona;
    private JButton btnAgregarRelacion;
    private JTextField txtNombrePersona;
    private JTextField txtRelacion1;

    public VisualizadorGrafosUI() {
        super("Analizador de Redes Sociales");
        setupUI();
    }

    private void setupUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Crear el panel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(240, 240, 240));
        setContentPane(mainPanel);

        // Panel izquierdo para el grafo
        JPanel graphContainer = new JPanel();
        graphContainer.setLayout(new BorderLayout());
        graphContainer.setBackground(Color.WHITE);
        graphContainer.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Inicializar y agregar el panel del grafo
        graphPanel = new GraphPanel();
        graphContainer.add(graphPanel, BorderLayout.CENTER);
        mainPanel.add(graphContainer, BorderLayout.CENTER);

        // Panel derecho para controles
        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBackground(new Color(245, 245, 245));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        controlPanel.setPreferredSize(new Dimension(250, 0));

        // Título del panel de control
        JLabel titleLabel = new JLabel("Control Panel");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlPanel.add(titleLabel);
        controlPanel.add(Box.createVerticalStrut(20));

        // Sección para agregar persona
        JLabel lblPersona = new JLabel("Nombre Persona:");
        lblPersona.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblPersona.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtNombrePersona = new JTextField();
        txtNombrePersona.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        txtNombrePersona.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        btnAgregarPersona = new JButton("Agregar Persona");
        btnAgregarPersona.setBackground(new Color(70, 130, 180));
        btnAgregarPersona.setForeground(Color.WHITE);
        btnAgregarPersona.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAgregarPersona.setFocusPainted(false);
        btnAgregarPersona.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnAgregarPersona.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        // Sección para agregar relación
        JLabel lblRelacion = new JLabel("Agregar Relación:");
        lblRelacion.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblRelacion.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtRelacion1 = new JTextField();
        txtRelacion1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        txtRelacion1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtRelacion1.setToolTipText("Ejemplo: Juan,Pedro");

        btnAgregarRelacion = new JButton("Agregar Relación");
        btnAgregarRelacion.setBackground(new Color(70, 130, 180));
        btnAgregarRelacion.setForeground(Color.WHITE);
        btnAgregarRelacion.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAgregarRelacion.setFocusPainted(false);
        btnAgregarRelacion.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnAgregarRelacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        // Agregar componentes al panel de control
        controlPanel.add(lblPersona);
        controlPanel.add(Box.createVerticalStrut(5));
        controlPanel.add(txtNombrePersona);
        controlPanel.add(Box.createVerticalStrut(10));
        controlPanel.add(btnAgregarPersona);
        controlPanel.add(Box.createVerticalStrut(30));

        controlPanel.add(lblRelacion);
        controlPanel.add(Box.createVerticalStrut(5));
        controlPanel.add(txtRelacion1);
        controlPanel.add(Box.createVerticalStrut(10));
        controlPanel.add(btnAgregarRelacion);

        // Agregar panel de control al marco principal
        mainPanel.add(controlPanel, BorderLayout.EAST);

        // Acción para agregar persona
        btnAgregarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombrePersona.getText().trim();
                if (!nombre.isEmpty()) {
                    graphPanel.addVertex(nombre);
                    txtNombrePersona.setText("");
                }
            }
        });

        // Acción para agregar relación (solo un campo, formato: nombre1,nombre2)
        btnAgregarRelacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = txtRelacion1.getText().trim();
                if (!texto.isEmpty() && texto.contains(",")) {
                    String[] personas = texto.split(",");
                    if (personas.length == 2) {
                        String persona1 = personas[0].trim();
                        String persona2 = personas[1].trim();
                        if (!persona1.isEmpty() && !persona2.isEmpty()) {
                            graphPanel.addEdge(persona1, persona2);
                        }
                    }
                    txtRelacion1.setText("");
                }
            }
        });

        // Configurar la ventana
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(VisualizadorGrafosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizadorGrafosUI().setVisible(true);
            }
        });
    }
}
