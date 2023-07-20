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

public class AddCustomer extends JPanel implements ActionListener {
    Container c;
    JButton saveBtn, cancleBtn,btnBack;
    String filename = "customer.txt";
    JLabel idLabel, nameLabel, surnameLabel;
    JTextField idText, nameText, surnameText;
    Font myFont = new Font("Consolas", Font.BOLD, 18);
    Customer customer = new Customer();

    public AddCustomer() {
        setPreferredSize(new Dimension(500, 350));
        setBorder(BorderFactory.createLineBorder(Color.cyan, 1));
        createGui();
    }

    public void createGui() {
        idLabel = new JLabel(" Enter Customer ID : ");
        idLabel.setFont(myFont);
        add(idLabel);
        idText = new JTextField(20);
        idText.setFont(myFont);
        add(idText);
        nameLabel = new JLabel(" Enter Customer Name  : ");
        nameLabel.setFont(myFont);
        add(nameLabel);
        nameText = new JTextField(20);
        nameText.setFont(myFont);
        add(nameText);
        surnameLabel = new JLabel("Enter Customer Surname : ");
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
        customer.setId(id);
        customer.setName(name);
        customer.setSurname(surname);
        saveToFile();
        JOptionPane.showMessageDialog(this,
                "Save Product : " + id + name + surname,
                "Message", JOptionPane.INFORMATION_MESSAGE);
        idText.setText("");
        nameText.setText("");
        surnameText.setText("");
    }

    public void saveToFile() {
        try {
            // open file for write and file exist open for append
            FileWriter out = new FileWriter(filename, true);
            out.write(customer.toString() + "\n");
            out.close(); // close stream input
        } catch (IOException event) {
            event.printStackTrace();
        }
    }
}
