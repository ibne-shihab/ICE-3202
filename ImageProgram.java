import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Image;
public class ImageProgram {
    public ImageProgram() {
        JFrame frame = new JFrame("Image Program");
        frame.setLayout(new FlowLayout());
        ImageIcon image1 = resizeImage(new ImageIcon(getClass().getResource("blueberries.jpg")), 400, 400);
        JLabel label1 = new JLabel(image1);
        frame.add(label1);
        ImageIcon image2 = resizeImage(new ImageIcon(getClass().getResource("boston_haze.jpg")), 400, 400);
        JLabel label2 = new JLabel(image2);
        frame.add(label2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageProgram();
            }
        });
    }
}
