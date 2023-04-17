package smartcalculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SmartCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String operation;
	double prviBroj;
	double drugiBroj;
	double result;
	String answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartCalculator frame = new SmartCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SmartCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{55, 55, 55, 55, 0};
		gbl_contentPane.rowHeights = new int[]{35, 30, 30, 30, 30, 30, 30, 30, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 4;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnCustom = new JButton("Custom expression");
		btnCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomExpression custom = new CustomExpression();
				custom.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCustom = new GridBagConstraints();
		gbc_btnCustom.fill = GridBagConstraints.BOTH;
		gbc_btnCustom.insets = new Insets(0, 0, 5, 0);
		gbc_btnCustom.gridwidth = 4;
		gbc_btnCustom.gridx = 0;
		gbc_btnCustom.gridy = 1;
		contentPane.add(btnCustom, gbc_btnCustom);
		
		//prvi red
		
		JButton btnFaktorijel = new JButton("x!");
		btnFaktorijel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prviBroj = Double.parseDouble(textField.getText());
				if (textField.getText().charAt(0) == '-') {
					textField.setText("ERROR");
					JOptionPane.showMessageDialog(null, "Nije moguce izracunati faktorijel negativnog broja!", "Error", 
					JOptionPane.ERROR_MESSAGE);
				}else if (prviBroj % 1 != 0){
					textField.setText("ERROR");
					JOptionPane.showMessageDialog(null, "Nije moguce izracunati faktorijel broja sa zarezom!", "Error", 
					JOptionPane.ERROR_MESSAGE);
				}else {
				int faktorijel = 1;
				for (int i = 1; i <= prviBroj; i++) {
				    faktorijel = faktorijel * i;
				    answer = Double.toString(faktorijel);
					textField.setText(answer);
				}
				}
			}
		});
		
		GridBagConstraints gbc_btnFaktorijel = new GridBagConstraints();
		gbc_btnFaktorijel.fill = GridBagConstraints.BOTH;
		gbc_btnFaktorijel.insets = new Insets(0, 0, 5, 5);
		gbc_btnFaktorijel.gridx = 0;
		gbc_btnFaktorijel.gridy = 2;
		contentPane.add(btnFaktorijel, gbc_btnFaktorijel);
		
		
		JButton btnKoren = new JButton("√");
		btnKoren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prviBroj = Double.parseDouble(textField.getText());
				if(textField.getText().charAt(0) == '-') {
					textField.setText("ERROR");
					JOptionPane.showMessageDialog(null, "Nije moguće korenovati negativan broj.", "Error", 
						JOptionPane.ERROR_MESSAGE);
				}else {
					double koren = Math.sqrt(prviBroj);
					answer = Double.toString(koren);
					textField.setText(answer);
				}	
			}
		});
		
		GridBagConstraints gbc_btnKoren = new GridBagConstraints();
		gbc_btnKoren.fill = GridBagConstraints.BOTH;
		gbc_btnKoren.insets = new Insets(0, 0, 5, 5);
		gbc_btnKoren.gridx = 1;
		gbc_btnKoren.gridy = 2;
		contentPane.add(btnKoren, gbc_btnKoren);
		
		
		JButton btnKvadrirenje = new JButton("x^2");
		btnKvadrirenje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double kvadrat;
				prviBroj = Double.parseDouble(textField.getText());
				kvadrat = prviBroj * prviBroj;
				answer = Double.toString(kvadrat);
				textField.setText(answer);
			}
		});
		
		GridBagConstraints gbc_btnKvadrirenje = new GridBagConstraints();
		gbc_btnKvadrirenje.fill = GridBagConstraints.BOTH;
		gbc_btnKvadrirenje.insets = new Insets(0, 0, 5, 5);
		gbc_btnKvadrirenje.gridx = 2;
		gbc_btnKvadrirenje.gridy = 2;
		contentPane.add(btnKvadrirenje, gbc_btnKvadrirenje);
		
		
		JButton btnLogaritam = new JButton("ln");
		btnLogaritam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prviBroj = Double.parseDouble(textField.getText());
				double ln = Math.log(prviBroj);
				answer = Double.toString(ln);
				textField.setText(answer);
			}
		});
		
		GridBagConstraints gbc_btnLogaritam = new GridBagConstraints();
		gbc_btnLogaritam.fill = GridBagConstraints.BOTH;
		gbc_btnLogaritam.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogaritam.gridx = 3;
		gbc_btnLogaritam.gridy = 2;
		contentPane.add(btnLogaritam, gbc_btnLogaritam);
		
		
		//drugi red
		
		JButton btnOZagrada = new JButton("(");
		btnOZagrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 textField.setText("(" + textField.getText());
			}
		});
		
		GridBagConstraints gbc_btnOZagrada = new GridBagConstraints();
		gbc_btnOZagrada.fill = GridBagConstraints.BOTH;
		gbc_btnOZagrada.insets = new Insets(0, 0, 5, 5);
		gbc_btnOZagrada.gridx = 0;
		gbc_btnOZagrada.gridy = 3;
		contentPane.add(btnOZagrada, gbc_btnOZagrada);
		
		
		JButton btnZZagrada = new JButton(")");
		btnZZagrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + ")");
			}
		});
		
		GridBagConstraints gbc_btnZZagrada = new GridBagConstraints();
		gbc_btnZZagrada.fill = GridBagConstraints.BOTH;
		gbc_btnZZagrada.insets = new Insets(0, 0, 5, 5);
		gbc_btnZZagrada.gridx = 1;
		gbc_btnZZagrada.gridy = 3;
		contentPane.add(btnZZagrada, gbc_btnZZagrada);
		
		
		JButton btnProcenat = new JButton("%");
		btnProcenat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prviBroj = Double.parseDouble(textField.getText());
				textField.setText("" + (prviBroj/100));	
			}
		});
		
		GridBagConstraints gbc_btnProcenat = new GridBagConstraints();
		gbc_btnProcenat.fill = GridBagConstraints.BOTH;
		gbc_btnProcenat.insets = new Insets(0, 0, 5, 5);
		gbc_btnProcenat.gridx = 2;
		gbc_btnProcenat.gridy = 3;
		contentPane.add(btnProcenat, gbc_btnProcenat);
		
		
		JButton btnBrisanje = new JButton("AC");
		btnBrisanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		
		GridBagConstraints gbc_btnBrisanje = new GridBagConstraints();
		gbc_btnBrisanje.fill = GridBagConstraints.BOTH;
		gbc_btnBrisanje.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrisanje.gridx = 3;
		gbc_btnBrisanje.gridy = 3;
		contentPane.add(btnBrisanje, gbc_btnBrisanje);
		
		
		//treci red
		
		JButton btnSedam = new JButton("7");
		btnSedam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		
		GridBagConstraints gbc_btnSedam = new GridBagConstraints();
		gbc_btnSedam.fill = GridBagConstraints.BOTH;
		gbc_btnSedam.insets = new Insets(0, 0, 5, 5);
		gbc_btnSedam.gridx = 0;
		gbc_btnSedam.gridy = 4;
		contentPane.add(btnSedam, gbc_btnSedam);
		
		
		JButton btnOsam = new JButton("8");
		btnOsam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});
		
		GridBagConstraints gbc_btnOsam = new GridBagConstraints();
		gbc_btnOsam.fill = GridBagConstraints.BOTH;
		gbc_btnOsam.insets = new Insets(0, 0, 5, 5);
		gbc_btnOsam.gridx = 1;
		gbc_btnOsam.gridy = 4;
		contentPane.add(btnOsam, gbc_btnOsam);
		
		
		JButton btnDevet = new JButton("9");
		btnDevet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "9");
			}
		});
		
		GridBagConstraints gbc_btnDevet = new GridBagConstraints();
		gbc_btnDevet.fill = GridBagConstraints.BOTH;
		gbc_btnDevet.insets = new Insets(0, 0, 5, 5);
		gbc_btnDevet.gridx = 2;
		gbc_btnDevet.gridy = 4;
		contentPane.add(btnDevet, gbc_btnDevet);
		
		
		JButton btnDeljenje = new JButton("/");
		btnDeljenje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					prviBroj = Double.parseDouble(textField.getText());
					textField.setText("");
					operation = "/";
				}
				catch (NumberFormatException e1){
					textField.setText("ERROR");
				    JOptionPane.showMessageDialog(null, "Neispravan unos.", "Error", 
				                             JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		GridBagConstraints gbc_btnDeljenje = new GridBagConstraints();
		gbc_btnDeljenje.fill = GridBagConstraints.BOTH;
		gbc_btnDeljenje.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeljenje.gridx = 3;
		gbc_btnDeljenje.gridy = 4;
		contentPane.add(btnDeljenje, gbc_btnDeljenje);
		
		
		//cetvrti red
		
		JButton btnCetiri = new JButton("4");
		btnCetiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "4");
			}
		});
		
		GridBagConstraints gbc_btnCetiri = new GridBagConstraints();
		gbc_btnCetiri.fill = GridBagConstraints.BOTH;
		gbc_btnCetiri.insets = new Insets(0, 0, 5, 5);
		gbc_btnCetiri.gridx = 0;
		gbc_btnCetiri.gridy = 5;
		contentPane.add(btnCetiri, gbc_btnCetiri);
		
		
		JButton btnPet = new JButton("5");
		btnPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});
		
		GridBagConstraints gbc_btnPet = new GridBagConstraints();
		gbc_btnPet.fill = GridBagConstraints.BOTH;
		gbc_btnPet.insets = new Insets(0, 0, 5, 5);
		gbc_btnPet.gridx = 1;
		gbc_btnPet.gridy = 5;
		contentPane.add(btnPet, gbc_btnPet);
		
		
		JButton btnSest = new JButton("6");
		btnSest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "6");
			}
		});
		
		GridBagConstraints gbc_btnSest = new GridBagConstraints();
		gbc_btnSest.fill = GridBagConstraints.BOTH;
		gbc_btnSest.insets = new Insets(0, 0, 5, 5);
		gbc_btnSest.gridx = 2;
		gbc_btnSest.gridy = 5;
		contentPane.add(btnSest, gbc_btnSest);
		
	
		JButton btnMnozenje = new JButton("*");
		btnMnozenje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					prviBroj = Double.parseDouble(textField.getText());
					textField.setText("");
					operation = "*";
				}
				catch (NumberFormatException e1){
					textField.setText("ERROR");
				    JOptionPane.showMessageDialog(null, "Neispravan unos.", "Error", 
				                             JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		GridBagConstraints gbc_btnMnozenje = new GridBagConstraints();
		gbc_btnMnozenje.fill = GridBagConstraints.BOTH;
		gbc_btnMnozenje.insets = new Insets(0, 0, 5, 0);
		gbc_btnMnozenje.gridx = 3;
		gbc_btnMnozenje.gridy = 5;
		contentPane.add(btnMnozenje, gbc_btnMnozenje);
		
		
		//peti red
		
		JButton btnJedan = new JButton("1");
		btnJedan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "1");
			}
		});
		
		GridBagConstraints gbc_btnJedan = new GridBagConstraints();
		gbc_btnJedan.fill = GridBagConstraints.BOTH;
		gbc_btnJedan.insets = new Insets(0, 0, 5, 5);
		gbc_btnJedan.gridx = 0;
		gbc_btnJedan.gridy = 6;
		contentPane.add(btnJedan, gbc_btnJedan);
		
		
		JButton btnDva = new JButton("2");
		btnDva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "2");
			}
		});
		
		GridBagConstraints gbc_btnDva = new GridBagConstraints();
		gbc_btnDva.fill = GridBagConstraints.BOTH;
		gbc_btnDva.insets = new Insets(0, 0, 5, 5);
		gbc_btnDva.gridx = 1;
		gbc_btnDva.gridy = 6;
		contentPane.add(btnDva, gbc_btnDva);
		
		
		JButton btnTri = new JButton("3");
		btnTri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "3");
			}
		});
		
		GridBagConstraints gbc_btnTri = new GridBagConstraints();
		gbc_btnTri.fill = GridBagConstraints.BOTH;
		gbc_btnTri.insets = new Insets(0, 0, 5, 5);
		gbc_btnTri.gridx = 2;
		gbc_btnTri.gridy = 6;
		contentPane.add(btnTri, gbc_btnTri);
		
		
		JButton btnOduzimanje = new JButton("-");
		btnOduzimanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField.getText().isEmpty()) {
						textField.setText("-");				
					} else {
						prviBroj = Double.parseDouble(textField.getText());
						textField.setText("");
						operation = "-";
					}
				}
				catch (NumberFormatException e1){
					textField.setText("ERROR");
				    JOptionPane.showMessageDialog(null, "Neispravan unos.", "Error", 
				                           JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		GridBagConstraints gbc_btnOduzimanje = new GridBagConstraints();
		gbc_btnOduzimanje.fill = GridBagConstraints.BOTH;
		gbc_btnOduzimanje.insets = new Insets(0, 0, 5, 0);
		gbc_btnOduzimanje.gridx = 3;
		gbc_btnOduzimanje.gridy = 6;
		contentPane.add(btnOduzimanje, gbc_btnOduzimanje);
		
		
		//sesti red
		
		JButton btnNula = new JButton("0");
		btnNula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "0");
			}
		});
		
		GridBagConstraints gbc_btnNula = new GridBagConstraints();
		gbc_btnNula.anchor = GridBagConstraints.NORTH;
		gbc_btnNula.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNula.insets = new Insets(0, 0, 0, 5);
		gbc_btnNula.gridx = 0;
		gbc_btnNula.gridy = 7;
		contentPane.add(btnNula, gbc_btnNula);
		
		
		JButton btnZarez = new JButton(".");
		btnZarez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String zarez = textField.getText() + ".";
			textField.setText(zarez);
				
			}
		});
		
		GridBagConstraints gbc_btnZarez = new GridBagConstraints();
		gbc_btnZarez.anchor = GridBagConstraints.NORTH;
		gbc_btnZarez.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnZarez.insets = new Insets(0, 0, 0, 5);
		gbc_btnZarez.gridx = 1;
		gbc_btnZarez.gridy = 7;
		contentPane.add(btnZarez, gbc_btnZarez);
		
		
		JButton btnJednako = new JButton("=");
		btnJednako.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				drugiBroj = Double.parseDouble(textField.getText());
				try {
					if (operation == "+") {
						result = prviBroj + drugiBroj;
						answer = Double.toString(result);
						textField.setText(answer);
					}
					else if (operation == "-") {
						result= prviBroj - drugiBroj;
						answer = Double.toString(result);
						textField.setText(answer);	
					}
					else if (operation == "/") {
						if (drugiBroj == 0) {
							textField.setText("ERROR");
							JOptionPane.showMessageDialog(null, "Nije moguce deliti sa nulom.", "Error", 
													JOptionPane.ERROR_MESSAGE);				
						}
						else {
							result = prviBroj / drugiBroj;
							answer = Double.toString(result);
							textField.setText(answer);
						}
					}
					else if (operation == "*") {
						result = prviBroj * drugiBroj;
						answer = Double.toString(result);
						textField.setText(answer);
					}
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Morate uneti drugi broj", "Error", 
											JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		
		GridBagConstraints gbc_btnJednako = new GridBagConstraints();
		gbc_btnJednako.anchor = GridBagConstraints.NORTH;
		gbc_btnJednako.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnJednako.insets = new Insets(0, 0, 0, 5);
		gbc_btnJednako.gridx = 2;
		gbc_btnJednako.gridy = 7;
		contentPane.add(btnJednako, gbc_btnJednako);
		
		
		JButton btnSabiranje = new JButton("+");
		btnSabiranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					prviBroj = Double.parseDouble(textField.getText());
					textField.setText("");
					operation = "+";
				}
				catch (NumberFormatException e1){
					textField.setText("ERROR");
					JOptionPane.showMessageDialog(null, "Neispravan unos.", "Error", 
			                                JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		GridBagConstraints gbc_btnSabiranje = new GridBagConstraints();
		gbc_btnSabiranje.anchor = GridBagConstraints.NORTH;
		gbc_btnSabiranje.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSabiranje.gridx = 3;
		gbc_btnSabiranje.gridy = 7;
		contentPane.add(btnSabiranje, gbc_btnSabiranje);
		
	}
}
