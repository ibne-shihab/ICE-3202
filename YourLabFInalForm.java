import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class YourLabFInalForm implements ActionListener {
    private static JLabel success;
    private static JFrame frame;
    private static JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
    private static JPanel panel;
    private static JButton button;
    private static JTextField userText1, userText2, userText3, userText4, userText5, userText6, emailText;
    private static JPasswordField passwordField1, passwordField2;
    private static JCheckBox accuracyCheckBox;

    public static void main(String[] args) {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(500, 550); // Increased frame height to accommodate the checkbox
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        label1 = new JLabel("Name");
        label1.setBounds(10, 10, 80, 25);
        panel.add(label1);

        label2 = new JLabel("Roll");
        label2.setBounds(10, 60, 80, 25);
        panel.add(label2);

        label3 = new JLabel("Department");
        label3.setBounds(10, 110, 80, 25);
        panel.add(label3);

        label4 = new JLabel("Father's Name");
        label4.setBounds(10, 160, 100, 25);
        panel.add(label4);

        label5 = new JLabel("Mother's Name");
        label5.setBounds(10, 210, 100, 25);
        panel.add(label5);

        label6 = new JLabel("Registration");
        label6.setBounds(10, 260, 100, 25);
        panel.add(label6);

        label7 = new JLabel("Email");
        label7.setBounds(10, 310, 80, 25);
        panel.add(label7);

        label8 = new JLabel("Password");
        label8.setBounds(10, 360, 80, 25);
        panel.add(label8);

        label9 = new JLabel("Confirm Password");
        label9.setBounds(10, 410, 120, 25);
        panel.add(label9);

        userText1 = new JTextField();
        userText1.setBounds(120, 10, 200, 25);
        panel.add(userText1);

        userText2 = new JTextField();
        userText2.setBounds(120, 60, 200, 25);
        panel.add(userText2);

        userText3 = new JTextField();
        userText3.setBounds(120, 110, 200, 25);
        panel.add(userText3);

        userText4 = new JTextField();
        userText4.setBounds(120, 160, 200, 25);
        panel.add(userText4);

        userText5 = new JTextField();
        userText5.setBounds(120, 210, 200, 25);
        panel.add(userText5);

        userText6 = new JTextField();
        userText6.setBounds(120, 260, 200, 25);
        panel.add(userText6);

        emailText = new JTextField();
        emailText.setBounds(120, 310, 200, 25);
        panel.add(emailText);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(120, 360, 200, 25);
        panel.add(passwordField1);

        passwordField2 = new JPasswordField();
        passwordField2.setBounds(140, 410, 180, 25); // Adjusted position to fit the label
        panel.add(passwordField2);

        accuracyCheckBox = new JCheckBox("I confirm that the supplied information is accurate");
        accuracyCheckBox.setBounds(10, 460, 350, 25); // Adjusted position
        panel.add(accuracyCheckBox);

        button = new JButton("Save");
        button.setBounds(200, 510, 80, 25);
        button.addActionListener(new YourLabFInalForm());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(150, 550, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (userText1.getText().isEmpty() || userText2.getText().isEmpty() || userText3.getText().isEmpty() ||
                userText4.getText().isEmpty() || userText5.getText().isEmpty() || userText6.getText().isEmpty() ||
                emailText.getText().isEmpty() || passwordField1.getPassword().length == 0 ||
                passwordField2.getPassword().length == 0) {
            success.setText("Please fill in all fields.");
        } else if (!passwordMatch()) {
            success.setText("Passwords do not match.");
        } else if (!accuracyCheckBox.isSelected()) {
            success.setText("Please confirm the accuracy of the supplied information.");
        } else {
            success.setText("Saved Successfully");
        }
    }

    private boolean passwordMatch() {
        char[] pass1 = passwordField1.getPassword();
        char[] pass2 = passwordField2.getPassword();
        return new String(pass1).equals(new String(pass2));
    }
}
