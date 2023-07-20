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

public class AddProduct extends JPanel implements ActionListener {
    Container c;
    JButton saveBtn, cancleBtn,btnBack;
    String filename = "product.txt";
    JLabel idLabel, nameLabel, priceLabel;
    JTextField idText, nameText, priceText;
    Font myFont = new Font("Consolas", Font.BOLD, 18);
    Product product = new Product();

    public AddProduct() {
        setPreferredSize(new Dimension(500, 350));
        setBorder(BorderFactory.createLineBorder(Color.green, 1));
        createGui();
    }

    public void createGui() {
        idLabel = new JLabel(" Enter Id Product : ");
        idLabel.setFont(myFont);
        add(idLabel);
        idText = new JTextField(20);
        idText.setFont(myFont);
        add(idText);
        nameLabel = new JLabel(" Enter Name Product : ");
        nameLabel.setFont(myFont);
        add(nameLabel);
        nameText = new JTextField(20);
        nameText.setFont(myFont);
        add(nameText);
        priceLabel = new JLabel("Enter price Product : ");
        priceLabel.setFont(myFont);
        add(priceLabel);
        priceText = new JTextField(20);
        priceText.setFont(myFont);
        add(priceText);
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
            priceText.setText("");
        }
    }

    public void saveData() {
        String id = idText.getText().trim();
        String name = nameText.getText().trim();
        String price = priceText.getText().trim();
        product.setId(id);
        product.setName(name);
        product.setPrice(Float.parseFloat(price));
        saveToFile();
        JOptionPane.showMessageDialog(this,
                "Save Product : " + id + name + price,
                "Message", JOptionPane.INFORMATION_MESSAGE);
        idText.setText("");
        nameText.setText("");
        priceText.setText("");
    }

    public void saveToFile() {
        try {
            // open file for write and file exist open for append
            FileWriter out = new FileWriter(filename, true);
            out.write(product.toString() + "\n");
            out.close(); // close stream input
        } catch (IOException event) {
            event.printStackTrace();
        }
    }
}
