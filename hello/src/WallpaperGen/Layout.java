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

public class Layout {

	private JFrame frame;
	private JTextField txtWidth;

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
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox themeInput = new JComboBox();
		themeInput.setModel(new DefaultComboBoxModel(new String[] {"", "Pre-Selected Theme"}));
		themeInput.setSelectedIndex(1);
		themeInput.setMaximumRowCount(2);
		themeInput.setBounds(123, 74, 400, 32);
		frame.getContentPane().add(themeInput);
		
		JComboBox colorInput = new JComboBox();
		colorInput.setMaximumRowCount(4);
		colorInput.setModel(new DefaultComboBoxModel(new String[] {"", "Red", "Green", "Blue"}));
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
		lblColour.setBounds(21, 24, 81, 26);
		frame.getContentPane().add(lblColour);
		
		txtWidth = new JTextField();
		txtWidth.setToolTipText("");
		txtWidth.setBounds(131, 192, 186, 32);
		frame.getContentPane().add(txtWidth);
		txtWidth.setColumns(10);
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
		/*								 width height sx   sy    ox    oy               weight		*/
		NoiseSystem fgh = new NoiseSystem(1920,1080,100f,100f,0.0f,0.0f, new Color(255,200,20));
		fgh.toImg();
	}
}
