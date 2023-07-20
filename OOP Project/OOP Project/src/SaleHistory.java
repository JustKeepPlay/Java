import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class SaleHistory extends JFrame implements ActionListener {
    Container c;
    JButton dayBtn,monthBtn,yearBtn,exitBtn,searchBtn;
    String filename = "salehistory.txt";
    JPanel cmdPanel;
    
    Font myFont = new Font("Consolas", Font.BOLD, 18);

    public SaleHistory() {
        super(">>>>> Sale history <<<<<");
        c = getContentPane();
        c.setLayout(new FlowLayout());
        cmdPanel = new JPanel();
        cmdPanel.setPreferredSize(new Dimension(500, 85));
        cmdPanel.setBorder(
                BorderFactory.createLineBorder(Color.green, 4));
        c.add(cmdPanel);

        

        dayBtn = new JButton("Day");
        dayBtn.addActionListener(this);
        dayBtn.setFont(myFont);
        cmdPanel.add(dayBtn);

        monthBtn = new JButton("Month");
        monthBtn.addActionListener(this);
        monthBtn.setFont(myFont);
        cmdPanel.add(monthBtn);
        
        yearBtn = new JButton("Year");
        yearBtn.addActionListener(this);
        yearBtn.setFont(myFont);
        cmdPanel.add(yearBtn);

        searchBtn = new JButton("Search");
        searchBtn.addActionListener(this);
        searchBtn.setFont(myFont);
        cmdPanel.add(searchBtn);

        exitBtn = new JButton("Back");
        exitBtn.addActionListener(this);
        exitBtn.setFont(myFont);
        cmdPanel.add(exitBtn);


        setSize(640, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dayBtn) {
            
        } else if (e.getSource() == exitBtn) {
            setVisible(false);
        }
    }

    // public static void main(String args[]) {
    //     new ManageProduct();
    // }
}