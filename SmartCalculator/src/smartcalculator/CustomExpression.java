package smartcalculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class CustomExpression extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomExpression dialog = new CustomExpression();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomExpression() {
		setTitle("Custom expression");
		setResizable(false);
		setBounds(100, 100, 250, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{88, 320, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel); 
		
		{
		JLabel lblNewLabel = new JLabel("Operation");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	 	gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
	 	gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
	 	gbc_lblNewLabel.gridx = 0;
	 	gbc_lblNewLabel.gridy = 0;
	 	contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		}
		{
	 	JLabel lblNewLabel_1 = new JLabel("Result");
	 	GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	 	gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
	 	gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
	 	gbc_lblNewLabel_1.gridx = 0;
	 	gbc_lblNewLabel_1.gridy = 1;
	 	contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
	 	textField_1 = new JTextField();
	 	GridBagConstraints gbc_textField_1 = new GridBagConstraints();
	 	gbc_textField_1.insets = new Insets(0, 0, 5, 0);
	 	gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
	 	gbc_textField_1.gridx = 1;
	 	gbc_textField_1.gridy = 1;
	 	contentPanel.add(textField_1, gbc_textField_1);
	 	textField_1.setColumns(10);
		}
		{
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
			JButton okButton = new JButton("Result");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					String res = "";
					res = textField.getText();
					Stack<Integer> st = new Stack<>(); 
				          
				    	for(int i=0; i < res.length(); i++) {
				           char ch = res.charAt(i); 
				           if(Character.isDigit(ch))
				           st.push(ch - '0'); 
				           else {
				               int first = st.pop(); 
				               int second = st.pop(); 
				                 
				               switch(ch) { 
				                   case '+': 
				                   st.push(second + first); 
				                   break; 
				                      
				                   case '-': 
				                   st.push(second - first); 
				                   break; 
				                        
				                   case '*': 
				                   st.push(second * first); 
				                   break; 
				                    
				                   case '/': 
				                   st.push(second / first); 
				                   break; 
				               } 
				           } 
				       } 
				    textField_1.setText(textField_1.getText() + st.pop());
				    } 
					catch (Exception e1) {
				        JOptionPane.showMessageDialog(null, "Morate uneti broj ili operacije!", "Error", JOptionPane.ERROR_MESSAGE);
				    }
				}
			});
			{
				JButton btnAC = new JButton("AC");
				buttonPane.add(btnAC);
				btnAC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText("");
						textField_1.setText("");
					}
				});
			}
			okButton.setActionCommand("Result");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
			}
		
			{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
			}
		}
	}
}
