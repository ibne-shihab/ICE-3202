import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame implements ActionListener {
    JButton[] numButtons;
    JButton addButton, subButton, mulButton, divButton, equalsButton, clearButton;
    JTextField displayField;
    int num1, num2;
    char operator;
    public calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5)); // Add some spacing between buttons
        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(displayField, BorderLayout.NORTH);
        numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            buttonPanel.add(numButtons[i]);
        }
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
        setContentPane(contentPane);
        pack(); // Adjusts the frame size to fit its contents
        setLocationRelativeTo(null); // Centers the frame on the screen
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("C")) {
            displayField.setText("");
            num1 = num2 = 0;
            operator = '\u0000';
        } else if (Character.isDigit(command.charAt(0))) {
            displayField.setText(displayField.getText() + command);
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            num1 = Integer.parseInt(displayField.getText());
            operator = command.charAt(0);
            displayField.setText("");
        } else if (command.equals("=")) {
            num2 = Integer.parseInt(displayField.getText());
            int result = calculate();
            displayField.setText(String.valueOf(result));
        }
    }
    private int calculate() {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
        return result;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new calculator();
            }
        });
    }
}
