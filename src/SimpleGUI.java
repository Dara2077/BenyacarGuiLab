import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI extends JFrame{

    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JTextField textField;

    public SimpleGUI() {
        super("Frame title");
        init();
    }

    private void init() {
        // setting up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocation(300, 50);

        // create the MenuBar and menu components
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save as");
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        JMenu menu2 = new JMenu("Help");
        JMenuItem menuItem3 = new JMenuItem("FAQ");
        JMenuItem menuItem4 = new JMenuItem("About");
        menu2.add(menuItem3);
        menu2.add(menuItem4);

        ActionListener item1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(menuItem1.getText());
            }
        };


        ActionListener item2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(menuItem2.getText());
            }
        };
        ActionListener item3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(menuItem3.getText());
            }
        };
        ActionListener item4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(menuItem4.getText());
            }
        };

        menuItem1.addActionListener(item1);
        menuItem2.addActionListener(item2);
        menuItem3.addActionListener(item3);
        menuItem4.addActionListener(item4);


        // add "File" and "Help" menus to the MenuBar
        menuBar.add(menu1);
        menuBar.add(menu2);

        // create the big text area located in the middle
        JTextArea textArea = new JTextArea();

        // create welcome label
        JLabel welcomeLabel = new JLabel("Welcome to my GUI!");
        welcomeLabel.setFont(new Font("Ariel", Font.ITALIC, 30));

        // create slider and adjust settings
        JSlider slider = new JSlider(0, 40, 20);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // create a panel for organizing the label and slider
        JPanel sliderPanel = new JPanel();

        // add label and slider, in left-to-right order
        sliderPanel.add(welcomeLabel);
        sliderPanel.add(slider);
        ChangeListener panelListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setText(slider.getValue() + " ");
            }
        };
        slider.addChangeListener(panelListener);


        // create the components at the bottom
        JLabel label = new JLabel("Enter Text");
        textField = new JTextField(10); // accepts upto 10 characters

        JButton sendButton = new JButton("Send");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + textField.getText());
                textField.setText("");
            }
        };
        sendButton.addActionListener(listener);
        ActionListener resetListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
                textField.setText("");
                textArea.setText("");
            }
        };
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(resetListener);

        JButton openButton = new JButton("Open");

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("Second Frame");
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.setSize(300, 200);
                newFrame.setLocation(350, 70);
                JPanel secPanel = new JPanel();
                JLabel newLabel = new JLabel("Hello!! This is my new frame!");
                secPanel.add(newLabel);
                newFrame.add(secPanel);
                newFrame.setVisible(true);
            }
        };

        openButton.addActionListener(buttonListener);



        // create checkboxes
        checkBox1 = new JCheckBox("Yes");
        checkBox1.setBounds(100, 100, 50, 50);
        checkBox2 = new JCheckBox("No", true);
        checkBox2.setBounds(100, 150, 50, 50);

        // create a panel for organizing the components at the bottom
        JPanel panel = new JPanel(); // a "panel" is not visible

        // add bottom components to the panel, in left-to-right order
        panel.add(label);
        panel.add(textField);
        panel.add(sendButton);
        panel.add(resetButton);
        panel.add(openButton);
        panel.add(checkBox1);
        panel.add(checkBox2);

        // creating a third panel to place slider and bottom panels vertically
        // (allows two rows of UI elements to be displayed)
        JPanel combinedPanels = new JPanel();
        combinedPanels.setLayout(new GridLayout(2, 1));
        combinedPanels.add(sliderPanel, BorderLayout.NORTH);
        combinedPanels.add(panel, BorderLayout.SOUTH);

        // add the menu bar to the TOP of the frame, the big white text area
        // to the MIDDLE of the frame, and the "combinedPanels" (which has
        // the label, slider, text box, buttons, and checkboxes) at the BOTTOM
        add(menuBar, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(combinedPanels, BorderLayout.SOUTH);

        // display the frame!
        setVisible(true);
    }


}