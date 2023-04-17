package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RectangleDlgModify extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JLabel lblRectangle;
	protected JButton okButton;
	protected JTextField heightField;
	protected JTextField widthField;
	protected JTextField upperLeftXField;
	protected JTextField upperLeftYField;
	protected boolean commited;
	protected JTextField textFieldColor;
	protected Color c;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RectangleDlgModify dialog = new RectangleDlgModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RectangleDlgModify() {
		setBounds(100, 100, 250, 250);
		setModal(true);
		setTitle("Rectangle Modify");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{45, 45, 50, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblRectangle = new JLabel("Rectangle Modify");
			lblRectangle.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblRectangle = new GridBagConstraints();
			gbc_lblRectangle.insets = new Insets(0, 0, 5, 0);
			gbc_lblRectangle.gridx = 2;
			gbc_lblRectangle.gridy = 0;
			contentPanel.add(lblRectangle, gbc_lblRectangle);
		}
		{
			JLabel lblNewLabel = new JLabel("width");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			widthField = new JTextField();
			GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
			gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWidth.gridx = 2;
			gbc_textFieldWidth.gridy = 1;
			contentPanel.add(widthField, gbc_textFieldWidth);
			widthField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("height");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			heightField = new JTextField();
			GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
			gbc_textFieldHeight.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldHeight.gridx = 2;
			gbc_textFieldHeight.gridy = 2;
			contentPanel.add(heightField, gbc_textFieldHeight);
			heightField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("x");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			upperLeftXField = new JTextField();
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 2;
			gbc_textFieldX.gridy = 3;
			contentPanel.add(upperLeftXField, gbc_textFieldX);
			upperLeftXField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("y");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			upperLeftYField = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 2;
			gbc_textFieldY.gridy = 4;
			contentPanel.add(upperLeftYField, gbc_textFieldY);
			upperLeftYField.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Color");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 5;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			{
				textFieldColor = new JTextField();
				textFieldColor.setEditable(false);
				GridBagConstraints gbc_textFieldColor = new GridBagConstraints();
				gbc_textFieldColor.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldColor.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldColor.gridx = 1;
				gbc_textFieldColor.gridy = 5;
				contentPanel.add(textFieldColor, gbc_textFieldColor);
				textFieldColor.setColumns(10);
			}
		}
		JButton btnNewButtonColor = new JButton("Choose color");
		btnNewButtonColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c = JColorChooser.showDialog(null, "Choose color",Color.RED);
				textFieldColor.setBackground(c);
				
			}
		});
		GridBagConstraints gbc_btnNewButtonColor = new GridBagConstraints();
		gbc_btnNewButtonColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButtonColor.gridx = 2;
		gbc_btnNewButtonColor.gridy = 5;
		contentPanel.add(btnNewButtonColor, gbc_btnNewButtonColor);
		{	
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!heightField.getText().isEmpty() && !widthField.getText().isEmpty() && !upperLeftXField.getText().isEmpty() && !upperLeftYField.getText().isEmpty()) {
							if(heightField.getText().matches("^[1-9]\\d*$") && widthField.getText().matches("^[1-9]\\d*$") && upperLeftXField.getText().matches("^[1-9]\\d*$")
								&& upperLeftYField.getText().matches("^[1-9]\\d*$")) {
								setCommited(true);
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "All values have to be positive!", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "You have to enter all values!", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setCommited(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	

	//getteri i setteri
	public JTextField getTextFieldWidth() {
		return widthField;
	}

	public void setTextFieldWidth(JTextField textFieldWidth) {
		this.widthField = textFieldWidth;
	}

	public JTextField getTextFieldHeight() {
		return heightField;
	}

	public void setTextFieldHeight(JTextField textFieldHeight) {
		this.heightField = textFieldHeight;
	}

	public JTextField getTextFieldX() {
		return upperLeftXField;
	}

	public void setTextFieldX(JTextField textFieldX) {
		this.upperLeftXField = textFieldX;
	}

	public JTextField getTextFieldY() {
		return upperLeftYField;
	}

	public void setTextFieldY(JTextField textFieldY) {
		this.upperLeftYField = textFieldY;
	}

	public JTextField getTextFieldColor() {
		return textFieldColor;
	}

	public void setTextFieldColor(JTextField textFieldColor) {
		this.textFieldColor = textFieldColor;
	}

	public boolean isCommited() {
		return commited;
	}

	public void setCommited(boolean commited) {
		this.commited = commited;
	}

	public JLabel getLblRectangle() {
		return lblRectangle;
	}

	public void setLblRectangle(JLabel lblRectangle) {
		this.lblRectangle = lblRectangle;
	}

	public JTextField getHeightField() {
		return heightField;
	}

	public void setHeightField(JTextField heightField) {
		this.heightField = heightField;
	}

	public JTextField getWidthField() {
		return widthField;
	}

	public void setWidthField(JTextField widthField) {
		this.widthField = widthField;
	}

	public JTextField getUpperLeftXField() {
		return upperLeftXField;
	}

	public void setUpperLeftXField(JTextField upperLeftXField) {
		this.upperLeftXField = upperLeftXField;
	}

	public JTextField getUpperLeftYField() {
		return upperLeftYField;
	}

	public void setUpperLeftYField(JTextField upperLeftYField) {
		this.upperLeftYField = upperLeftYField;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	
	
	
}	