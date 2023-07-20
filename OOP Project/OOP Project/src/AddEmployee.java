import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class AddEmployee extends JPanel implements ActionListener {
    Container c;
    JButton saveBtn, cancleBtn,btnBack;
    String filename = "employee.txt";
    JLabel idLabel, nameLabel, surnameLabel;
    JTextField idText, nameText, surnameText;
    Font myFont = new Font("Consolas", Font.BOLD, 18);
    Employee employee = new Employee();

    public AddEmployee() {
        setPreferredSize(new Dimension(500, 350));
        setBorder(BorderFactory.createLineBorder(Color.orange, 1));
        createGui();
    }

    public void createGui() {
        idLabel = new JLabel(" Enter Employee ID : ");
        idLabel.setFont(myFont);
        add(idLabel);
        idText = new JTextField(20);
        idText.setFont(myFont);
        add(idText);
        nameLabel = new JLabel(" Enter Employee Name  : ");
        nameLabel.setFont(myFont);
        add(nameLabel);
        nameText = new JTextField(20);
        nameText.setFont(myFont);
        add(nameText);
        surnameLabel = new JLabel("Enter Employee Surname : ");
        surnameLabel.setFont(myFont);
        add(surnameLabel);
        surnameText = new JTextField(20);
        surnameText.setFont(myFont);
        add(surnameText);
        saveBtn = new JButton("Save");
        saveBtn.addActionListener(this);
        saveBtn.setFont(myFont);
        add(saveBtn);
        cancleBtn = new JButton("Cancle");
        cancleBtn.addActionListener(this);
        cancleBtn.setFont(myFont);
        add(cancleBtn);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            saveData();
        } else if (e.getSource() == cancleBtn) {
            idText.setText("");
            nameText.setText("");
            surnameText.setText("");
        }
    }

    public void saveData() {
        String id = idText.getText().trim();
        String name = nameText.getText().trim();
        String surname = surnameText.getText().trim();
        employee.setId(id);
        employee.setName(name);
        employee.setSurname(surname);
        saveToFile();
        JOptionPane.showMessageDialog(this,
                "Save Employee Info : " + id + name + surname,
                "Message", JOptionPane.INFORMATION_MESSAGE);
        idText.setText("");
        nameText.setText("");
        surnameText.setText("");
    }

    public void saveToFile() {
        try {
            // open file for write and file exist open for append
            FileWriter out = new FileWriter(filename, true);
            out.write(employee.toString() + "\n");
            out.close(); // close stream input
        } catch (IOException event) {
            event.printStackTrace();
        }
    }
}