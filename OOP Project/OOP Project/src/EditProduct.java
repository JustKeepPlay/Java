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

public class EditProduct extends JPanel implements ActionListener {
    Container c;
    JButton saveIdBtn, cancleIdBtn, saveNameBtn , cancleNameBtn , savePriceBtn , canclePriceBtn, btnBack;
    String filename = "product.txt";
    JLabel idLabel, nameLabel, priceLabel, newIdLabel, newNameLabel, newPriceLabel;
    JTextField idText, nameText, priceText, newIdText, newNameText, newPriceText;
    Font myFont = new Font("Consolas", Font.BOLD, 18);
    Product product = new Product();
    

    public EditProduct() {
        setPreferredSize(new Dimension(500, 350));
        setBorder(BorderFactory.createLineBorder(Color.green, 1));
        createGui();
    }

    public void FixProduct(String filename, String oldString, String newString) {
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
                // Closing the resources
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createGui() {
        idLabel = new JLabel(" Product ID (old) : ");
        idLabel.setFont(myFont);
        add(idLabel);
        idText = new JTextField(20);
        idText.setFont(myFont);
        add(idText);

        newIdLabel = new JLabel(" New Product ID :   ");
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

        nameLabel = new JLabel(" Product Name (old) :   ");
        nameLabel.setFont(myFont);
        add(nameLabel);
        nameText = new JTextField(20);
        nameText.setFont(myFont);
        add(nameText);

        newNameLabel = new JLabel(" New Product name :     ");
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

        priceLabel = new JLabel("Product Prcie (old) : ");
        priceLabel.setFont(myFont);
        add(priceLabel);
        priceText = new JTextField(20);
        priceText.setFont(myFont);
        add(priceText);

        newPriceLabel = new JLabel(" New Product Price :  ");
        newPriceLabel.setFont(myFont);
        add(newPriceLabel);
        newPriceText = new JTextField(20);
        newPriceText.setFont(myFont);
        add(newPriceText);

        savePriceBtn = new JButton("Save price");
        savePriceBtn.addActionListener(this);
        savePriceBtn.setFont(myFont);
        add(savePriceBtn);

        canclePriceBtn = new JButton("Cancle price");
        canclePriceBtn.addActionListener(this);
        canclePriceBtn.setFont(myFont);
        add(canclePriceBtn);
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
                FixProduct(filename, oldId, newId);
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
                FixProduct(filename, oldName, newName);
                JOptionPane.showMessageDialog(null, "Product name has been changed");
            }
            nameText.setText("");
            newNameText.setText("");
        } else if (e.getSource() == cancleNameBtn) {
            nameText.setText("");
            newNameText.setText("");
        }
        if (e.getSource() == savePriceBtn) {
            String oldPrice = priceText.getText();
            String newPrice = newPriceText.getText();
            if(oldPrice.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the old surname");
            }
            else if(newPrice.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the new surname");
            }
            else if (oldPrice.equals(newPrice)) {
                JOptionPane.showMessageDialog(null, "Please enter the new surname different from the old surname");
            }
            else {
                FixProduct(filename, oldPrice, newPrice);
                JOptionPane.showMessageDialog(null, "Product surname has been changed");
            }
            priceText.setText("");
            newPriceText.setText("");
        } else if (e.getSource() == canclePriceBtn) {
            priceText.setText("");
            newPriceText.setText("");
        }   
        
    }

    public void saveToFile() {
        try {
            FileWriter out = new FileWriter(filename, true);
            out.write(product.toString() + "\n");
            out.close(); 
        } catch (IOException event) {
            event.printStackTrace();
        }
    }
}