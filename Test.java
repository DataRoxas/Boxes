import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test{
    public static void main(String[] args){
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
        String[] fontNames = GraphicsEnvironment.
            getLocalGraphicsEnvironment().
                getAvailableFontFamilyNames();
        final JComboBox fontComboBox = new JComboBox(fontNames);
        fontComboBox.setSelectedItem("SansSerif");
        final JComboBox sizeComboBox = new JComboBox();
        final JCheckBox boldCheckBox = new JCheckBox("Bold");
        final JCheckBox italicCheckBox = new JCheckBox("Italic");
        for(int i = 8; i <= 72; i++){
            sizeComboBox.addItem(i);
        }
        sizeComboBox.setSelectedItem(12);
        sizeComboBox.setEditable(true);
        ActionListener changeListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int mask = Font.PLAIN;
                if(boldCheckBox.isSelected()){
                    mask += Font.BOLD;
                }
                if (italicCheckBox.isSelected()){
                    mask += Font.ITALIC;
                }
                textArea.setFont(new Font((String) fontComboBox.getSelectedItem(),
                    mask, (Integer) sizeComboBox.getSelectedItem()));
            }
        };
        fontComboBox.addActionListener(changeListener);
        sizeComboBox.addActionListener(changeListener);
        boldCheckBox.addActionListener(changeListener);
        italicCheckBox.addActionListener(changeListener);
        controlPanel.add(fontComboBox);
        controlPanel.add(sizeComboBox);
        controlPanel.add(boldCheckBox);
        controlPanel.add(italicCheckBox);
        add(controlPanel, BorderLayout.NORTH);
    }
}
