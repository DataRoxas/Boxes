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
    }
}
