import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sell extends JPanel {
    String filename = "product.txt";
    JTextArea textArea;
    JScrollPane display;
    Font myFont = new Font("Consolas", Font.BOLD, 16);

    public Sell() {
        setPreferredSize(new Dimension(500, 350));
        setBorder(BorderFactory.createLineBorder(Color.green, 1));
        textArea = new JTextArea(16, 50);
        textArea.setFont(myFont);
        display = new JScrollPane(textArea);
        add(display);
        readAndDisplay();
    }

    public void readAndDisplay() {
        textArea.setText("");
        textArea.setEditable(false);
        try {
            FileReader in = new FileReader(filename);
            BufferedReader inputfile = new BufferedReader(in);
            String s1;
            while ((s1 = inputfile.readLine()) != null) {
                textArea.append(s1 + "\n");
            }
            inputfile.close(); // close stream input
        } catch (IOException event) {
            event.printStackTrace();
        }
    }

    public void updateDisplay() {
        readAndDisplay();
    }

    // public static void main(String[] args) {
    //     new Sell();
    // }
}