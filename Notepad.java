import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Notepad{
    public static void main(String[] args) {
        NotepadFrame f = new NotepadFrame();
        f.setVisible(true);
    }
}

class NotepadFrame extends JFrame{
    private static int WIDTH = 600;
    private static int HEIGHT = 600;
    public NotepadFrame(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        final JTextArea textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        String[] fontNames = GraphicsEnviroment.getLocalGraphicsEnviroment().getAvailableFontFamilyNames();
        final JComboBox fontComboBox = new JComboBox(fontNames);
        fontComboBox.setSelectedItem("SansSerif");
        final JComboBox sizeComboBox = new JComboBox();
        for(int i = 8; i <= 72; i++){
            sizeComboBox.addItem(i);
        }
        sizeComboBox.setSelectedItem(12);
        sizeComboBox.setEditable(true);
        ActionListener changeListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.setFont(new Font((String)fontComboBox.
                    getSelectedItem(),Font.PLAIN,(Integer)sizeComboBox.
                        getSelectedItem()));
            }
        };
        fontComboBox.addActionListener(changeListener);
        fontComboBox.addActionListener(changeListener);
        controlPanel.add(fontComboBox);
        controlPanel.add(sizeComboBox);
        add(controlPanel,BorderLayout.NORTH);
    }
}
