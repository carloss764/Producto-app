package PRODUCTO_APP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase Login que representa la ventana de login
 */
public class Login extends JFrame {
    /**
     * Campo de texto para ingresar el nombre de usuario
     */
    private JTextField campoNombre;
    /**
     * Campo de contraseña para ingresar la contraseña
     */
    private JPasswordField campoContraseña;
    /**
     * Botón para autenticar al usuario
     */
    private JButton botonLogin;
    /**
     * Botón para guardar un nuevo usuario
     */
    private JButton botonGuardar;
    /**
     * Botón para cancelar la operación actual
     */
    private JButton botonCancelar;
    /**
     * Lista de usuarios registrados
     */
    private ArrayList<Usuario> usuarios;

    /**
     * Constructor de la clase Login
     */
    public Login() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin", "admin"));

        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel etiquetaNombre = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelEntrada.add(etiquetaNombre, gbc);

        campoNombre = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelEntrada.add(campoNombre, gbc);

        JLabel etiquetaContraseña = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelEntrada.add(etiquetaContraseña, gbc);

        campoContraseña = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelEntrada.add(campoContraseña, gbc);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        botonLogin = new JButton("Login");
        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Autenticar al usuario cuando se presiona el botón Login
                 */
                autenticar();
            }
        });

        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Guardar un nuevo usuario cuando se presiona el botón Guardar
                 */
                guardar();
            }
        });

        botonCancelar = new JButton("Cancelar");
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Cancelar la operación actual cuando se presiona el botón Cancelar
                 */
                campoNombre.setText("");
                campoContraseña.setText("");
            }
        });

        panelBotones.add(botonLogin);
        panelBotones.add(botonGuardar);
        panelBotones.add(botonCancelar);

        // Agregar paneles al frame
        add(panelEntrada, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setSize(400, 450); // Tamaño del frame
        setLocationRelativeTo(null); // Centrar el frame en la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Autenticar al usuario
     */
    private void autenticar() {
        String nombre = campoNombre.getText();
        String contraseña = new String(campoContraseña.getPassword());

        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
                JOptionPane.showMessageDialog(this, "Login exitoso");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Login fallido");
    }

    /**
     * Guardar un nuevo usuario
     */
    private void guardar() {
        String nombre = campoNombre.getText();
        String contraseña = new String(campoContraseña.getPassword());

        if (nombre.isEmpty() || contraseña.isEmpty()) {
            /**
             * Mostrar mensaje de error si alguno de los campos está vacío
             */
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos");
            return;
        }

        boolean existe = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                existe = true;
                break;
            }
        }

        if (existe) {
            /**
             * Mostrar mensaje de error si el usuario ya existe
             */
            JOptionPane.showMessageDialog(this, "El usuario ya existe");
        } else {
            usuarios.add(new Usuario(nombre, contraseña));
                    /**
             * Mostrar mensaje de éxito si el usuario se ha agregado correctamente
             */
            JOptionPane.showMessageDialog(this, "Usuario agregado correctamente");
        }
    }

    /**
     * Clase Usuario que representa un usuario registrado
     */
    static class Usuario {
        private String nombre;
        private String contraseña;

        /**
         * Constructor de la clase Usuario
         */
        public Usuario(String nombre, String contraseña) {
            this.nombre = nombre;
            this.contraseña = contraseña;
        }

        /**
         * Método para obtener el nombre del usuario
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Método para obtener la contraseña del usuario
         */
        public String getContraseña() {
            return contraseña;
        }
    }

    /**
     * Método main que inicia la aplicación
     */
    public static void main(String[] args) {
        /**
         * Crear una nueva instancia de la clase Login y mostrarla en la pantalla
         */
        new Login();
    }
}