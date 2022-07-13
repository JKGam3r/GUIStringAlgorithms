import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frontend portion of the code --> displays the GUI/ interactive bit
 *
 * @author Justin Kocur
 */
public class Frontend { // random string operation on given input

    /**
     * Initiate the swing GUI
     */
    public Frontend() {
        // Set look and feel before doing anything else
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // The frame holding all of the components
        JFrame frame = new JFrame("My Java-Scala Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);

        JPanel panel = new JPanel(new BorderLayout());
        JTextField inputArea = new JTextField();
        JLabel outputBox = outputBox();

        panel.add(inputArea);
        panel.add(outputBox, BorderLayout.PAGE_END);
        panel.add(comButton(inputArea, outputBox), BorderLayout.PAGE_START);

        frame.add(panel);
        frame.pack();

        frame.setVisible(true);
    }

    /**
     * Creates the button responsible for interacting between the input/ output (frontend/ backend)
     */
    private JButton comButton(JTextField inputArea, JLabel outputBox) {
        JButton button = new JButton("Press Me for Information on Your String!");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User's inputted text
                String text = inputArea.getText();

                // String algorithms that return information on the user's text
                String palindrome = Backend.isPalindrome(text);
                String firstSingleChar = Backend.firstNonRepeatedChar(text);
                String highFreq = Backend.highestOccurringChar(text);

                // The output string
                String output = String.format("Information: %s | %s | %s", palindrome, firstSingleChar, highFreq);
                outputBox.setText(output);
            }
        });

        return button;
    }

    /**
     * Creates the output box
     */
    private JLabel outputBox() {
        JLabel label = new JLabel("OUTPUT", SwingConstants.CENTER);
        label.setBackground(new Color(75, 225, 150));
        label.setOpaque(true);

        return label;
    }
}
