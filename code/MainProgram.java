import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainProgram extends JFrame implements ActionListener {
    JButton btn[];
    Container c;
    MyFrame1 windows1;
    MyFrame2 windows2;
    MyFrame3 windows3;
    MyFrame4 windows4;
    int n_show, n_hide;

    public MainProgram() {
        super(" Main Program ");
        c = getContentPane();
        c.setLayout(new FlowLayout());
        btn = new JButton[4];
        for (int n = 0; n < btn.length; n++) {
            btn[n] = new JButton("Windows " + (n + 1));
            btn[n].addActionListener(this);
            c.add(btn[n]);
        }
        windows1 = new MyFrame1("Windows 1");
        windows2 = new MyFrame2("Windows 2");
        windows3 = new MyFrame3("Windows 3");
        windows4 = new MyFrame4("Windows 4");
        n_show = n_hide = -1;
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn[0]) {
            windows1.setVisible(true);
            windows2.setVisible(false);
            windows3.setVisible(false);
            windows4.setVisible(false);
        } else if (e.getSource() == btn[1]) {
            windows1.setVisible(false);
            windows2.setVisible(true);
            windows3.setVisible(false);
            windows4.setVisible(false);
        } else if (e.getSource() == btn[2]) {
            windows1.setVisible(false);
            windows2.setVisible(false);
            windows3.setVisible(true);
            windows4.setVisible(false);
        } else if (e.getSource() == btn[3]) {
            windows1.setVisible(false);
            windows2.setVisible(false);
            windows3.setVisible(false);
            windows4.setVisible(true);
        }
    }

    public static void main(String[] args) throws Exception {
        new MainProgram();
    }
}