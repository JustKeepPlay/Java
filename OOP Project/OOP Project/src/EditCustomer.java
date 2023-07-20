import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EditCustomer extends JPanel implements ActionListener {
    Container c;
    JButton saveIdBtn, cancleIdBtn, saveSurnameBtn , cancleNameBtn , saveNameBtn , cancleSurnameBtn, btnBack;
    String filename = "customer.txt";
    JLabel idLabel, nameLabel, surnameLabel, newIdLabel, newNameLabel, newSurnameLabel;
    JTextField idText, nameText, surnameText, newIdText, newNameText, newSurnameText;
    Font myFont = new Font("Consolas", Font.BOLD, 18);
    Customer customer = new Customer();
    

    public EditCustomer() {
        setPreferredSize(new Dimension(500, 350));
        setBorder(BorderFactory.createLineBorder(Color.cyan, 1));
        createGui();
    }

    public void FixCustomer(String filename, String oldString, String newString) {
        File fileToBeModified = new File(filename);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            String newContent = oldContent.replaceAll(oldString, newString);
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createGui() {
        idLabel = new JLabel(" Customer ID (old) : ");
        idLabel.setFont(myFont);
        add(idLabel);
        idText = new JTextField(20);
        idText.setFont(myFont);
        add(idText);

        newIdLabel = new JLabel(" New Customer ID :   ");
        newIdLabel.setFont(myFont);
        add(newIdLabel);
        newIdText = new JTextField(20);
        newIdText.setFont(myFont);
        add(newIdText);

        saveIdBtn = new JButton("Save ID");
        saveIdBtn.addActionListener(this);
        saveIdBtn.setFont(myFont);
        add(saveIdBtn);

        cancleIdBtn = new JButton("Cancle Id");
        cancleIdBtn.addActionListener(this);
        cancleIdBtn.setFont(myFont);
        add(cancleIdBtn);

        nameLabel = new JLabel(" Customer Name (old) :   ");
        nameLabel.setFont(myFont);
        add(nameLabel);
        nameText = new JTextField(20);
        nameText.setFont(myFont);
        add(nameText);

        newNameLabel = new JLabel(" New Customer name :     ");
        newNameLabel.setFont(myFont);
        add(newNameLabel);
        newNameText = new JTextField(20);
        newNameText.setFont(myFont);
        add(newNameText);

        saveNameBtn = new JButton("Save Name");
        saveNameBtn.addActionListener(this);
        saveNameBtn.setFont(myFont);
        add(saveNameBtn);

        cancleNameBtn = new JButton("Cancle Name");
        cancleNameBtn.addActionListener(this);
        cancleNameBtn.setFont(myFont);
        add(cancleNameBtn);

        surnameLabel = new JLabel("Customer surname (old) : ");
        surnameLabel.setFont(myFont);
        add(surnameLabel);
        surnameText = new JTextField(20);
        surnameText.setFont(myFont);
        add(surnameText);

        newSurnameLabel = new JLabel("New Customer Surname :  ");
        newSurnameLabel.setFont(myFont);
        add(newSurnameLabel);
        newSurnameText = new JTextField(20);
        newSurnameText.setFont(myFont);
        add(newSurnameText);

        saveSurnameBtn = new JButton("Save Surname");
        saveSurnameBtn.addActionListener(this);
        saveSurnameBtn.setFont(myFont);
        add(saveSurnameBtn);

        cancleSurnameBtn = new JButton("Cancle Surname");
        cancleSurnameBtn.addActionListener(this);
        cancleSurnameBtn.setFont(myFont);
        add(cancleSurnameBtn);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveIdBtn) {
            String oldId = idText.getText();
            String newId = newIdText.getText();
            if(oldId.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the old ID");
            }
            else if(newId.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the new ID");
            }
            else if (oldId.equals(newId)) {
                JOptionPane.showMessageDialog(null, "Please enter the new ID different from the old ID");
            }
            else {
                FixCustomer(filename, oldId, newId);
                JOptionPane.showMessageDialog(null, "Product ID has been changed");
            }
            idText.setText("");
            newIdText.setText("");
        } else if (e.getSource() == cancleIdBtn) {
            idText.setText("");
            newIdText.setText("");
        }
        if (e.getSource() == saveNameBtn) {
            String oldName = nameText.getText();
            String newName = newNameText.getText();
            if(oldName.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the old name");
            }
            else if(newName.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the new name");
            }
            else if (oldName.equals(newName)) {
                JOptionPane.showMessageDialog(null, "Please enter the new name different from the old name");
            }
            else {
                FixCustomer(filename, oldName, newName);
                JOptionPane.showMessageDialog(null, "Customer name has been changed");
            }
            nameText.setText("");
            newNameText.setText("");
        } else if (e.getSource() == cancleNameBtn) {
            nameText.setText("");
            newNameText.setText("");
        }
        if (e.getSource() == saveSurnameBtn) {
            String oldSurname = surnameText.getText();
            String newSurname = newSurnameText.getText();
            if(oldSurname.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the old surname");
            }
            else if(newSurname.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the new surname");
            }
            else if (oldSurname.equals(newSurname)) {
                JOptionPane.showMessageDialog(null, "Please enter the new surname different from the old surname");
            }
            else {
                FixCustomer(filename, oldSurname, newSurname);
                JOptionPane.showMessageDialog(null, "Customer surname has been changed");
            }
            surnameText.setText("");
            newSurnameText.setText("");
        } else if (e.getSource() == cancleSurnameBtn) {
            surnameText.setText("");
            newSurnameText.setText("");
        }   
    }

    public void saveToFile() {
        try {
            FileWriter out = new FileWriter(filename, true);
            out.write(customer.toString() + "\n");
            out.close(); 
        } catch (IOException event) {
            event.printStackTrace();
        }
    }
}
