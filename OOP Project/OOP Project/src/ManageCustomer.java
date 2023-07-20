import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class ManageCustomer extends JFrame implements ActionListener {
    Container c;
    JButton addBtn, displayBtn , editBtn, exitBtn, deleteBtn;
    String filename = "data.txt";
    JPanel cmdPanel;
    AddCustomer addCustomer;
    DisplayCustomer displayCustomer;
    EditCustomer editCustomer;
    DeleteCustomer deleteCustomer;
    MainProgram mainProgram;
    Font myFont = new Font("Consolas", Font.BOLD, 18);

    public ManageCustomer() {
        super(">>>>> Program customer manage <<<<<");
        c = getContentPane();
        c.setLayout(new FlowLayout());
        cmdPanel = new JPanel();
        cmdPanel.setPreferredSize(new Dimension(500, 85));
        cmdPanel.setBorder(
                BorderFactory.createLineBorder(Color.cyan, 4));
        c.add(cmdPanel);

        addBtn = new JButton("Add Customer");
        addBtn.addActionListener(this);
        addBtn.setFont(myFont);
        cmdPanel.add(addBtn);

        displayBtn = new JButton("Show Customer");
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

        addCustomer = new AddCustomer();
        c.add(addCustomer);
        addCustomer.setVisible(false);

        displayCustomer = new DisplayCustomer();
        c.add(displayCustomer);
        displayCustomer.setVisible(false);

        editCustomer = new EditCustomer();
        c.add(editCustomer);
        editCustomer.setVisible(false);

        deleteCustomer = new DeleteCustomer();
        c.add(deleteCustomer);
        deleteCustomer.setVisible(false);

        setSize(640, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            displayCustomer.setVisible(false);
            addCustomer.setVisible(true);
            editCustomer.setVisible(false);
            deleteCustomer.setVisible(false);
        } else if (e.getSource() == displayBtn) {
            addCustomer.setVisible(false);
            displayCustomer.setVisible(true);
            editCustomer.setVisible(false);
            deleteCustomer.setVisible(false);
            displayCustomer.updateDisplay();
        } else if (e.getSource() == editBtn) {
            addCustomer.setVisible(false);
            displayCustomer.setVisible(false);
            editCustomer.setVisible(true);
            deleteCustomer.setVisible(false);
        } else if (e.getSource() == deleteBtn) {
            addCustomer.setVisible(false);
            displayCustomer.setVisible(false);
            editCustomer.setVisible(false);
            deleteCustomer.setVisible(true);
        } else if (e.getSource() == exitBtn) {
            //to MainProgram
            setVisible(false);
        }
    }
    // public static void main(String[] args) {
    //     new ManageCustomer();
    // }
}