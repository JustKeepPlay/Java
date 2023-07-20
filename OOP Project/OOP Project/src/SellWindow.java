import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class SellWindow extends JFrame implements ActionListener {
    Container c;
    JButton addBtn, displayBtn , editBtn, exitBtn,deleteBtn;
    String filename = "data.txt";
    JPanel cmdPanel;
    Sell sell;
    Font myFont = new Font("Consolas", Font.BOLD, 18);

    public SellWindow() {
        super(">>>>> Program employee manage <<<<<");
        c = getContentPane();
        c.setLayout(new FlowLayout());
        cmdPanel = new JPanel();
        cmdPanel.setPreferredSize(new Dimension(500, 85));
        cmdPanel.setBorder(
                BorderFactory.createLineBorder(Color.orange, 4));
        c.add(cmdPanel);
        addBtn = new JButton("Add Employee");
        addBtn.addActionListener(this);
        addBtn.setFont(myFont);
        cmdPanel.add(addBtn);

        displayBtn = new JButton("Show Employee");
        displayBtn.addActionListener(this);
        displayBtn.setFont(myFont);
        cmdPanel.add(displayBtn);

        editBtn = new JButton("Edit Customer");
        editBtn.addActionListener(this);
        editBtn.setFont(myFont);
        cmdPanel.add(editBtn);

        deleteBtn = new JButton("Delete Product");
        deleteBtn.addActionListener(this);
        deleteBtn.setFont(myFont);
        cmdPanel.add(deleteBtn);

        exitBtn = new JButton("Back");
        exitBtn.addActionListener(this);
        exitBtn.setFont(myFont);
        cmdPanel.add(exitBtn);

        sell = new Sell();
        c.add(sell);
        sell.setVisible(false);

        

        setSize(640, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            
        } else if (e.getSource() == exitBtn) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new SellWindow();
    }
}
