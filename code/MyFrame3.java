import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame3 extends JFrame implements ActionListener {
    JButton btnBack;
    Container c;

    public MyFrame3(String title) {
        super(title);
        c = getContentPane();
        c.setLayout(new FlowLayout());
        btnBack = new JButton(" Back to Main Program");
        btnBack.addActionListener(this);
        c.add(btnBack);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}