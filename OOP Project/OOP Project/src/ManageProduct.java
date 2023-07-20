import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class ManageProduct extends JFrame implements ActionListener {
    Container c;
    JButton addBtn, displayBtn, exitBtn,editBtn , deleteBtn;
    String filename = "data.txt";
    JPanel cmdPanel;
    AddProduct addProduct;
    DisplayProduct displayProduct;
    EditProduct editProduct;
    DeleteProduct deleteProduct;
    Font myFont = new Font("Consolas", Font.BOLD, 18);

    public ManageProduct() {
        super(">>>>> Program Manage Product <<<<<");
        c = getContentPane();
        c.setLayout(new FlowLayout());
        cmdPanel = new JPanel();
        cmdPanel.setPreferredSize(new Dimension(500, 85));
        cmdPanel.setBorder(
                BorderFactory.createLineBorder(Color.green, 4));
        c.add(cmdPanel);

        addBtn = new JButton("Add Product");
        addBtn.addActionListener(this);
        addBtn.setFont(myFont);
        cmdPanel.add(addBtn);

        displayBtn = new JButton("Show Product");
        displayBtn.addActionListener(this);
        displayBtn.setFont(myFont);
        cmdPanel.add(displayBtn);

        editBtn = new JButton("Edit Product");
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

        addProduct = new AddProduct();
        c.add(addProduct);
        addProduct.setVisible(false);

        displayProduct = new DisplayProduct();
        c.add(displayProduct);
        displayProduct.setVisible(false);

        editProduct = new EditProduct();
        c.add(editProduct);
        editProduct.setVisible(false);
        
        deleteProduct = new DeleteProduct();
        c.add(deleteProduct);
        deleteProduct.setVisible(false);

        setSize(640, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            displayProduct.setVisible(false);
            addProduct.setVisible(true);
            editProduct.setVisible(false);
            deleteProduct.setVisible(false);
        } else if (e.getSource() == displayBtn) {
            addProduct.setVisible(false);
            displayProduct.setVisible(true);
            editProduct.setVisible(false);
            deleteProduct.setVisible(false);
            displayProduct.updateDisplay();
        } else if (e.getSource() == editBtn) {
            addProduct.setVisible(false);
            displayProduct.setVisible(false);
            editProduct.setVisible(true);
            deleteProduct.setVisible(false);
        } else if (e.getSource() == deleteBtn) {
            addProduct.setVisible(false);
            displayProduct.setVisible(false);
            editProduct.setVisible(false);
            deleteProduct.setVisible(true);
        } else if (e.getSource() == exitBtn) {
            setVisible(false);
        }
    }

    // public static void main(String args[]) {
    //     new ManageProduct();
    // }
}
