import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dashboardform extends JFrame {
    private JPanel DashboardPanel;
    private JLabel lbadmin;
    private JButton registerButton;
    private JButton UNITSREGButton;
    ;
    private JButton RESULTSButton;
    private JTable table1;
    private JButton EXAMSREGButton;
    private JButton logoutButton;
    ;

    public Dashboardform() {
        setTitle("Dashboard Panel");
        setContentPane(DashboardPanel);
        setMinimumSize(new Dimension(500, 429));
        setSize(1200, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        boolean hasRegisterUsers = connectToDatabase();
        if (hasRegisterUsers) {
            loginform loginform = new loginform(this);
            User user = loginform.user;
            if (user != null) {
                lbadmin.setText("Student: " + user.name);
                setVisible(true);
            } else {
                dispose();
            }
        } else {
            register register = new register(this);
            User user = register.user;
            if (user != null) {
                lbadmin.setText("Student: " + user.name);
                setVisible(true);
            } else {
                dispose();
            }
        }

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register register = new register(Dashboardform.this);
                User user = register.user;
                if (user != null) {
                    JOptionPane.showMessageDialog(Dashboardform.this,
                            "New user registered: " + user.name,
                            "Successful Registration",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        UNITSREGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                examregistration unitRegistration = new examregistration();
                unitRegistration.setVisible(true);
            }
        });

        EXAMSREGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                examregistration examRegistration = new examregistration();
                examRegistration.setVisible(true);
            }
        });


        RESULTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsPanel resultsPanelForm = new resultsPanel();
                resultsPanelForm.setVisible(true);
            }
        });

        logoutButton.addActionListener(e ->{
            setVisible(false);
            new Dashboardform().setVisible(true);
        });


    }

    private boolean connectToDatabase() {
        boolean hasRegisteredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/mystore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS mystore");
            statement.close();
            conn.close();

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(200) NOT NULL, "
                    + "email VARCHAR(200) NOT NULL UNIQUE, "
                    + "phone VARCHAR(200), "
                    + "address VARCHAR(200), "
                    + "password VARCHAR(200) NOT NULL"
                    + ")";
            statement.execute(sql);

            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegisteredUsers = true;
                }
            }

            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegisteredUsers;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboardform().setVisible(true));
    }
}