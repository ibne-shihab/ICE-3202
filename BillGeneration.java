import javax.swing.*;
import java.awt.event.*;
public class BillGeneration extends JFrame implements ActionListener {
    JLabel l, lPizza, lBurger, lTea;
    JTextField tfPizza, tfBurger, tfTea;
    JButton b;
    JTextArea ta;
    BillGeneration() {
        l = new JLabel("Food Ordering System");
        l.setBounds(100, 50, 300, 20);
        lPizza = new JLabel("Pizza @ 100");
        lPizza.setBounds(100, 100, 150, 20);
        tfPizza = new JTextField();
        tfPizza.setBounds(250, 100, 50, 20);
        lBurger = new JLabel("Burger @ 30");
        lBurger.setBounds(100, 150, 150, 20);
        tfBurger = new JTextField();
        tfBurger.setBounds(250, 150, 50, 20);
        lTea = new JLabel("Tea @ 10");
        lTea.setBounds(100, 200, 150, 20);
        tfTea = new JTextField();
        tfTea.setBounds(250, 200, 50, 20);
        b = new JButton("Order");
        b.setBounds(100, 250, 80, 30);
        b.addActionListener(this);
        ta = new JTextArea();
        ta.setBounds(100, 300, 200, 100);
        add(l);
        add(lPizza);
        add(tfPizza);
        add(lBurger);
        add(tfBurger);
        add(lTea);
        add(tfTea);
        add(b);
        add(ta);
        setSize(400, 500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        float amount = 0;
        StringBuilder msg = new StringBuilder();
        int pizzaQuantity = Integer.parseInt(tfPizza.getText());
        amount += 100 * pizzaQuantity;
        msg.append("Pizza: ").append(pizzaQuantity).append(" x 100\n");
        int burgerQuantity = Integer.parseInt(tfBurger.getText());
        amount += 30 * burgerQuantity;
        msg.append("Burger: ").append(burgerQuantity).append(" x 30\n");
        int teaQuantity = Integer.parseInt(tfTea.getText());
        amount += 10 * teaQuantity;
        msg.append("Tea: ").append(teaQuantity).append(" x 10\n");
        msg.append("-----------------\n");
        ta.setText(msg + "Total: " + amount);
    }
    public static void main(String[] args) {
        new BillGeneration();
    }
}
