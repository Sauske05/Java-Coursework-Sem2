import javax.swing.*;

class BackgroundWithComponentsExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Background with Components Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create a JLayeredPane to manage the layers
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 600, 400);
        frame.add(layeredPane);

        // Add the background image using a JLabel (layer 0)
        ImageIcon imageIcon = new ImageIcon("./gui_java.jpg");
        JLabel background = new JLabel("", imageIcon, JLabel.CENTER);
        background.setBounds(0, 0, 600, 400);
        layeredPane.add(background);

        // Add other components (buttons, text fields, etc.) on top of the background (layer 1)
        JButton button = new JButton("Click Me!");
        button.setBounds(250, 150, 100, 30);
        layeredPane.add(button);

        JTextField textField = new JTextField();
        textField.setBounds(200, 200, 200, 30);
        layeredPane.add(textField);

        // Add other components as needed

        frame.setVisible(true);
    }
}
