import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener, FocusListener {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton exitButton;

    public App() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JLabel userLabel = new JLabel("Usuário:");
        userField = new JTextField();
        userField.addFocusListener(this);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField();
        passwordField.addFocusListener(this);

        loginButton = new JButton("Entrar");
        loginButton.addActionListener(this);

        exitButton = new JButton("Sair");
        exitButton.addActionListener(this);

        JPanel userPanel = new JPanel(new GridLayout(1, 2));
        userPanel.add(userLabel);
        userPanel.add(userField);

        JPanel passwordPanel = new JPanel(new GridLayout(1, 2));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);

        add(userPanel);
        add(passwordPanel);
        add(buttonPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = userField.getText();
            String password = new String(passwordField.getPassword());

            if (user.equals("usuario") && password.equals("senha")) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");

                TesteJframe2 frame2 = new TesteJframe2(user);
                frame2.setVisible(true);

                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
            }
        } else if (e.getSource() == exitButton) {
            dispose();
        }
    }

    public void focusGained(FocusEvent e) {
        if (e.getSource() == userField) {
            // do nothing
        } else if (e.getSource() == passwordField) {
            if (passwordField.getPassword().length == 0) {
                passwordField.setBackground(Color.RED);
            }
        }
    }

    public void focusLost(FocusEvent e) {
        if (e.getSource() == userField) {
            if (userField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Campo usuário não preenchido!");
            }
        } else if (e.getSource() == passwordField) {
            passwordField.setBackground(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        App frame = new App();
    }
}

class TesteJframe2 extends JFrame {
    public TesteJframe2(String user) {
        setTitle("Bem-vindo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JLabel welcomeLabel = new JLabel("Bem-vindo, " + user + "!");
        JLabel courseLabel = new JLabel("Você está no curso de Engenharia de Software na Faculdade XYZ.");

        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        welcomePanel.add(welcomeLabel);

        JPanel coursePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        coursePanel.add(courseLabel);

        add(welcomePanel);
        add(coursePanel);

        setVisible(true);
    }
}
