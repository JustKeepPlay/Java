import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import javax.swing.BorderFactory;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class MainProgram extends JFrame implements ActionListener {
    JButton btn[] = new JButton[6];
    JPanel pnl[] = new JPanel[6];
    Container c;
    Color color;
    ManageProduct windows1;
    ManageCustomer windows2;
    ManageEmployee windows3;
    SaleHistory windows4;
    DailyReport windows5;
    int n_show, n_hide;
    String[] title = {"Manage Product", "Manage Customer", "Manage Employee","Sale History","Daily Report","Exit the Program"};

    public MainProgram() {
        super(" Main Program ");
        c = getContentPane();
        c.setLayout(new FlowLayout());
        
        for (int i = 0; i < 6; i++) {
            pnl[i] = new JPanel();
            pnl[i].setPreferredSize(new Dimension(500, 47));
            pnl[i].setBorder(
                    BorderFactory.createLineBorder(Color.MAGENTA, 0));
            c.add(pnl[i]);
            btn[i] = new JButton(title[i]);
            btn[i].addActionListener(this);
            btn[i].setFont(new Font("Consolas", Font.BOLD, 18));
            pnl[i].add(btn[i]);
        }

        
        windows1 = new ManageProduct();
        windows2 = new ManageCustomer();
        windows3 = new ManageEmployee();
        windows4 = new SaleHistory();
        windows5 = new DailyReport();
        n_show = n_hide = -1;
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn[0]) {
            windows1.setVisible(true);
            windows2.setVisible(false);
            windows3.setVisible(false);
            windows4.setVisible(false);
            windows5.setVisible(false);
        } else if (e.getSource() == btn[1]) {
            windows1.setVisible(false);
            windows2.setVisible(true);
            windows3.setVisible(false);
            windows4.setVisible(false);
            windows5.setVisible(false);
            
        } else if (e.getSource() == btn[2]) {
            windows1.setVisible(false);
            windows2.setVisible(false);
            windows3.setVisible(true);
            windows4.setVisible(false);
            windows5.setVisible(false);

        } else if (e.getSource() == btn[3]) {
            windows1.setVisible(false);
            windows2.setVisible(false);
            windows3.setVisible(false);
            windows4.setVisible(true);
            windows5.setVisible(false);
        }
        else if (e.getSource() == btn[4]) {
            windows1.setVisible(false);
            windows2.setVisible(false);
            windows3.setVisible(false);
            windows4.setVisible(false);
            windows5.setVisible(true);
        }
        else if (e.getSource() == btn[5]) {
            System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception {
        new MainProgram();
    }
}