import java.awt.*;
import java.awt.event.*;

public class SimpleAWTApp extends Frame {
    private Button button;
    private Label label;
    private Panel mainPanel;
    
    public SimpleAWTApp() {
        // Set up the frame
        setTitle("Simple AWT Application");
        setSize(400, 300);
        setLayout(new BorderLayout());
        
        // Create main panel with FlowLayout
        mainPanel = new Panel();
        mainPanel.setLayout(new FlowLayout());
        
        // Create button
        button = new Button("Button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove button
                mainPanel.remove(button);
                
                // Create and add label
                label = new Label("Button pressed");
                mainPanel.add(label);
                
                // Refresh the panel
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        
        // Add button to panel
        mainPanel.add(button);
        
        // Add panel to frame
        add(mainPanel, BorderLayout.CENTER);
        
        // Handle window closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // Center the window on screen
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SimpleAWTApp app = new SimpleAWTApp();
        app.setVisible(true);
    }
}
