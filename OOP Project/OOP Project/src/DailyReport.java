import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

public class DailyReport extends JPanel implements ActionListener {
    String filename = "salehistory.txt";
    
    JScrollPane display;
    JButton searchBtn, backBtn;
    JTextArea textArea;
    JTextField searchText;
    JLabel searchLabel;
    String search = "";
    Font myFont = new Font("Consolas", Font.BOLD, 16);


    public DailyReport() {
        setPreferredSize(new Dimension(500, 350));
        setBorder(BorderFactory.createLineBorder(Color.green, 1));
        textArea = new JTextArea(16, 50);
        textArea.setFont(myFont);
        display = new JScrollPane(textArea);
        add(display);
        createGui();
    }
    public void createGui(){
        searchLabel = new JLabel(" Chech Day : ");
        searchLabel.setFont(myFont);
        add(searchLabel);
        searchText = new JTextField(6);
        searchText.setFont(myFont);
        add(searchText);

        searchBtn = new JButton("Search");
        searchBtn.setFont(myFont);
        searchBtn.addActionListener(this);
        add(searchBtn);
        backBtn = new JButton("Back");
        backBtn.setFont(myFont);
        backBtn.addActionListener(this);
        add(backBtn);
        readAndDisplay();
    }
    public void readAndDisplay(){

    }
    public void actionPerformed(ActionEvent e) {
        
    }

    
    
    
}
