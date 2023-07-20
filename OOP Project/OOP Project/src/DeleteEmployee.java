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

public class DeleteEmployee extends JPanel implements ActionListener {
    Container c;
    JButton deleteBtn, cancleIdBtn, saveNameBtn , cancleNameBtn , savePriceBtn , canclePriceBtn, btnBack;
    String filename = "employee.txt";
    JLabel exampleLabel,detailLabel;
    JTextField exampleText,detailText;
    Font myFont = new Font("Consolas", Font.BOLD, 18);
    Product product = new Product();
    

    public DeleteEmployee() {
        setPreferredSize(new Dimension(500, 350));
        setBorder(BorderFactory.createLineBorder(Color.orange, 1));
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

    public void createGui(){
        exampleLabel = new JLabel("Delete Example : ");
        exampleLabel.setFont(myFont);
        add(exampleLabel);
        exampleText = new JTextField("001,Product_Name,Product_Price",40);
        exampleText.setFont(myFont);
        exampleText.setEditable(false);
        add(exampleText);

        detailLabel = new JLabel(" Delete Product details : ");
        detailLabel.setFont(myFont);
        add(detailLabel);
        detailText = new JTextField(40);
        detailText.setFont(myFont);
        add(detailText);

        deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(this);
        deleteBtn.setFont(myFont);
        add(deleteBtn);

        
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == deleteBtn){
            String[] productDetails = detailText.getText().split(",");
            if(productDetails.length != 3){
                JOptionPane.showMessageDialog(null, "Please enter the correct details");
            }
            else{
                String oldId = productDetails[0];
                String oldName = productDetails[1];
                String oldPrice = productDetails[2];
                FixProduct(filename, oldId + "," + oldName + ","+ oldPrice,"");
                JOptionPane.showMessageDialog(null, "Customer Detail Deleted");
            }
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
