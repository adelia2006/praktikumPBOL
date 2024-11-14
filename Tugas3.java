import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tugas3 {

    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    // Login components
    private JTextField emailField;
    private JPasswordField passwordField;

    // Register components
    private JTextField nameField;
    private JTextField regEmailField;
    private JPasswordField regPasswordField;

    public static void main(String[] args) {
        // Menjalankan UI di Event Dispatch Thread (EDT) untuk Thread-Safety
        SwingUtilities.invokeLater(() -> new Tugas3().createUI());
    }

    public void createUI() {
        frame = new JFrame("Login & Register Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);  // Ukuran frame diperbesar sedikit agar lebih rapi
        frame.setLocationRelativeTo(null); // Menempatkan frame di tengah layar

        // Menggunakan CardLayout untuk beralih antara Login dan Register
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Menambahkan panel login dan register ke dalam CardLayout
        cardPanel.add(createLoginPanel(), "Login");
        cardPanel.add(createRegisterPanel(), "Register");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    // Panel Login
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // GridBagLayout untuk fleksibilitas yang lebih besar
        panel.setBackground(new Color(139, 69, 19)); // Coklat

        // GridBagConstraints untuk menata komponen dengan lebih fleksibel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Menambahkan jarak antar komponen

        // Label dan input Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        // Label dan input Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        // Tombol Login
        JButton loginButton = new JButton("Submit Login");
        loginButton.addActionListener(this::loginAction);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        // Tombol Register
        JButton registerButton = new JButton("Go to Register");
        registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Register"));
        gbc.gridy = 3;
        panel.add(registerButton, gbc);

        return panel;
    }

    // Panel Register
    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());  // GridBagLayout untuk fleksibilitas yang lebih besar
        panel.setBackground(new Color(139, 69, 19));  // Coklat

        // GridBagConstraints untuk menata komponen dengan lebih fleksibel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Menambahkan jarak antar komponen

        // Label dan input Nama
        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        nameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        // Label dan input Email
        JLabel regEmailLabel = new JLabel("Email:");
        regEmailLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(regEmailLabel, gbc);

        regEmailField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(regEmailField, gbc);

        // Label dan input Password
        JLabel regPasswordLabel = new JLabel("Password:");
        regPasswordLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(regPasswordLabel, gbc);

        regPasswordField = new JPasswordField(20);
        gbc.gridx = 1;
        panel.add(regPasswordField, gbc);

        // Tombol Register
        JButton registerButton = new JButton("Submit Register");
        registerButton.addActionListener(this::registerAction);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        // Tombol Login
        JButton loginButton = new JButton("Go to Login");
        loginButton.addActionListener(e -> cardLayout.show(cardPanel, "Login"));
        gbc.gridy = 4;
        panel.add(loginButton, gbc);

        return panel;
    }

    // Fungsi untuk menangani login
    private void loginAction(ActionEvent e) {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Email dan Password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Login berhasil", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Fungsi untuk menangani registrasi
    private void registerAction(ActionEvent e) {
        String name = nameField.getText();
        String email = regEmailField.getText();
        String password = new String(regPasswordField.getPassword());

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Semua field harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Registrasi berhasil", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
