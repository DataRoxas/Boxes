import java.awt.event.*;
import javax.swing.*;

public class AboutProgram{
    public static void main(String[] args) {
        AboutFrame f = new AboutFrame();
        f.setVisible(true);
    }
}

class AboutFrame extends JFrame {
    public AboutFrame(){
        setSize(300,300);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);
        JMenuItem aboutMI = new JMenuItem("About");
        helpMenu.add(aboutMI);
        aboutMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AboutDialog dialog  = new AboutDialog(AboutFrame.this);
                dialog.setSize(100, 100);
                dialog.setVisible(true);
            }
        });
    }
}

class AboutDialog extends JDialog{
    public AboutDialog(JFrame owner){
        super(owner, "About", true);
        JLabel label = new JLabel("It's all about me!");
        add(label);
    }
}
