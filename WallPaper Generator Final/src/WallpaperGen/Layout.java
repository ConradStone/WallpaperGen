package WallpaperGen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.Panel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;

public class Layout {
	public static String themeSelected;
	public static String colourSelected;
	private JFrame frame;
	private static JTextField textWidth;
	private static JTextField textHeight;
	static JComboBox themInput = new JComboBox();
	static JComboBox clrInput = new JComboBox();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Layout window = new Layout();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Layout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("AcadEref", Font.PLAIN, 12));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox themeInput = new JComboBox();
		themInput = themeInput;
		themeInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		themeInput.setModel(new DefaultComboBoxModel(new String[] {"Select Your Theme", "Hypnosis", "Corona", "Gradient"}));
		themeInput.setSelectedIndex(0);
		themeInput.setMaximumRowCount(4);
		themeInput.setBounds(123, 74, 400, 32);
		frame.getContentPane().add(themeInput);
		
		JComboBox colorInput = new JComboBox();
		clrInput = colorInput;
		colorInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		colorInput.setBackground(Color.WHITE);
		colorInput.setToolTipText("");
		colorInput.setModel(new DefaultComboBoxModel(new String[] {"Select a Colour", "Red", "Orange", "Yellow", "Green", "Turquoise", "Blue", "Purple"}));
		colorInput.setSelectedIndex(0);
		colorInput.setBounds(123, 21, 400, 32);
		frame.getContentPane().add(colorInput);
		
		JButton btnNewButton = new JButton("Generate!");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainRun();
			}
		});
		btnNewButton.setBounds(21, 427, 502, 51);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Theme");
		lblNewLabel.setBounds(21, 77, 81, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblColour = new JLabel("Colour");
		lblColour.setForeground(Color.BLACK);
		lblColour.setBounds(21, 24, 81, 26);
		frame.getContentPane().add(lblColour);
		
		textWidth = new JTextField();
		textWidth.setText("1920");
		textWidth.setBounds(175, 273, 86, 20);
		frame.getContentPane().add(textWidth);
		textWidth.setColumns(10);
		
		textHeight = new JTextField();
		textHeight.setText("1080");
		textHeight.setBounds(325, 273, 86, 20);
		frame.getContentPane().add(textHeight);
		textHeight.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Width");
		lblNewLabel_1.setBounds(119, 276, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Screen Size (Pixels)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(197, 242, 177, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Height");
		lblNewLabel_3.setBounds(271, 276, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	
	public static void MainRun() {
		
		System.out.println("MainRan");
		int width = Integer.parseInt(textWidth.getText());
		int height = Integer.parseInt(textHeight.getText());
		
		float sx = 0f;
		float sy = 0f;
		float ox = 0f;
		float oy = 0f;
		
		Color weight = null;
		
		themeSelected = (String) themInput.getSelectedItem();
		colourSelected = (String) clrInput.getSelectedItem();
		switch(themeSelected) {
		
		case "Hypnosis":
			
			sx = 100f;
			sy = 100f;
			ox = 0f;
			oy = 0f;
			break;
		
		case "Corona":
			
			sx = 100f;
			sy = 100f;
			ox = 0.1f;
			oy = 0.1f;
			break;
		
		case "Gradient":
			
			sx = 1500f;
			sy = 1500f;
			ox = 0.05f;
			oy = 0.05f;
			break;
		}
		
		switch(colourSelected) {
		case "Red":
			weight = new Color(255, 0, 0);
			break;
		
		case "Orange":
			weight = new Color(255, 130, 0);
			break;
			
		case "Yellow":
			weight = new Color(255, 255, 0);
			break;
			
		case "Green":
			weight = new Color(0, 255, 0);
			break;
		case "Turquoise":
			weight = new Color(0, 255, 255);
			break;
		
		case "Blue":
			weight = new Color(0, 0, 255);
			break;
		case "Purple":
			weight = new Color(125, 0, 255);
			break;
		}
		
		/*								 width height sx   sy    ox    oy               weight		*/
		NoiseSystem fgh = new NoiseSystem(width,height,sx,sy,ox,oy, weight);
		fgh.toImg();
	}
}
