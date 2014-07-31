package vakardevstudios.kawaii;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Bootstrap extends JFrame
{
	
	
    private final JLabel usernameLabel = new JLabel("Username");
    private final JLabel passwordLabel = new JLabel("Password");

    private final JTextField username = new JTextField(15);
    private final JPasswordField password = new JPasswordField();

    private final JButton login = new JButton("Login");
    private final JButton cancel = new JButton("Cancel");

    private final JLabel status = new JLabel(" ");
	  
    public Bootstrap() {
        try {
			initUI();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void initUI() throws IOException {

        //add(new LoginPanel());

        setSize(854, 480);
        //pack();
        
        setTitle("Kawaii Collectors");
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        
        JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(usernameLabel);
        p3.add(passwordLabel);

        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(username);
        p4.add(password);

        JPanel p1 = new JPanel();
        p1.add(p3);
        p1.add(p4);

        JPanel p2 = new JPanel();
        p2.add(login);
        p2.add(cancel);

        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.EAST);
        p5.add(status, BorderLayout.CENTER);
        p5.add(p1, BorderLayout.WEST);
        status.setForeground(Color.RED);
        status.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(p5, BorderLayout.SOUTH);
        add(status, BorderLayout.BEFORE_FIRST_LINE); 
        
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        
        JEditorPane website = new JEditorPane("http://google.com");
        website.setEditable(false);
        add(new JScrollPane(website));
        menubar.add(file);
        setJMenuBar(menubar);
        
        addWindowListener(new WindowAdapter() {  
            @Override
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });
       
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Arrays.equals("derp".toCharArray(), password.getPassword())
                        && "derp".equals(username.getText())) {
                    setVisible(false);
                    //TODO: Make game visible!
                } else {
                    status.setText("Invalid username or password");
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
    }    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Bootstrap boot = new Bootstrap();
                boot.setVisible(true);
            }
        });
    }
}
