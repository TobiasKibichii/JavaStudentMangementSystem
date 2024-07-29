import javax.swing.*;
import java.awt.*;

public class fees extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public fees() {
        setTitle("Fees Management");
        setContentPane(panel1);
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize panel and layout
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        // Labels and text fields
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(new JLabel("Field 1:"), gbc);
        textField1 = new JTextField(20);
        gbc.gridx = 1;
        panel1.add(textField1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(new JLabel("Field 2:"), gbc);
        textField2 = new JTextField(20);
        gbc.gridx = 1;
        panel1.add(textField2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(new JLabel("Field 3:"), gbc);
        textField3 = new JTextField(20);
        gbc.gridx = 1;
        panel1.add(textField3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(new JLabel("Field 4:"), gbc);
        textField4 = new JTextField(20);
        gbc.gridx = 1;
        panel1.add(textField4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel1.add(new JLabel("Field 5:"), gbc);
        textField5 = new JTextField(20);
        gbc.gridx = 1;
        panel1.add(textField5, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel1.add(new JLabel("Field 6:"), gbc);
        textField6 = new JTextField(20);
        gbc.gridx = 1;
        panel1.add(textField6, gbc);

        // Make the frame visible
        pack(); // Adjusts the frame size to fit the components
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new fees();
            }
        });
    }
}
