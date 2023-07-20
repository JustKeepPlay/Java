import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class ManageEmployee extends JFrame implements ActionListener {
    Container c;
    JButton addBtn, displayBtn , editBtn, exitBtn,deleteBtn;
    String filename = "data.txt";
    JPanel cmdPanel;
    AddEmployee addEmployee;
    DisplayEmployee displayEmployee;
    EditEmployee editEmployee;
    DeleteEmployee deleteEmployee;
    Font myFont = new Font("Consolas", Font.BOLD, 18);

    public ManageEmployee() {
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

        addEmployee = new AddEmployee();
        c.add(addEmployee);
        addEmployee.setVisible(false);

        displayEmployee = new DisplayEmployee();
        c.add(displayEmployee);
        displayEmployee.setVisible(false);

        editEmployee = new EditEmployee();
        c.add(editEmployee);
        editEmployee.setVisible(false);

        deleteEmployee = new DeleteEmployee();
        c.add(deleteEmployee);
        deleteEmployee.setVisible(false);

        setSize(640, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            displayEmployee.setVisible(false);
            addEmployee.setVisible(true);
            editEmployee.setVisible(false);
        } else if (e.getSource() == displayBtn) {
            addEmployee.setVisible(false);
            displayEmployee.setVisible(true);
            editEmployee.setVisible(false);
            displayEmployee.updateDisplay();
        } else if (e.getSource() == editBtn) {
            addEmployee.setVisible(false);
            displayEmployee.setVisible(false);
            editEmployee.setVisible(true);
        } else if (e.getSource() == deleteBtn) {
            addEmployee.setVisible(false);
            displayEmployee.setVisible(false);
            editEmployee.setVisible(false);
            deleteEmployee.setVisible(true);
        } else if (e.getSource() == exitBtn) {
            setVisible(false);
        }
    }
    // public static void main(String[] args) {
    //     new ManageEmployee();
    // }
}
