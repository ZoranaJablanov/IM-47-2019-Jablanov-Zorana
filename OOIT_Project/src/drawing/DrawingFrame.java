package drawing;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.JEditorPane;

public class DrawingFrame extends JFrame {

	private JPanel contentPane;
	private DrawingPanel canvas;
	int brojac = 0;
	private DefaultListModel dlm = new DefaultListModel();
	Point previousPoint;
	Point nextPoint;
	boolean twoPoints = false;
	private PointDlg dlgp;
	private LineDlg dlgl;
	private RectangleDlg dlgrec;
	private CircleDlg dlgcir;
	private DonutDlg dlgdon;
	private RectangleDlgModify dlgrecm;
	private CircleDlgModify dlgcirm;
	private DonutDlgModify dlgdonm;
	private ArrayList<Shape> slctd = new ArrayList<Shape>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
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
	public DrawingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		

		canvas = new DrawingPanel();
		canvas.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(canvas, BorderLayout.CENTER);
		
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		panel.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		panel.add(tglbtnLine);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		panel.add(tglbtnCircle);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		panel.add(tglbtnRectangle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		panel.add(tglbtnDonut);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		panel.add(tglbtnSelect);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		panel.add(tglbtnDelete);
		
		JLabel koordinata = new JLabel("0,0");
		contentPane.add(koordinata, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));		
		
		tglbtnLine.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED) {
					tglbtnPoint.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
				}
			}
		});
		
		tglbtnCircle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED) {
					tglbtnLine.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);		
				}
			}
		});
		
		tglbtnRectangle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED )	{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);	
				}
			}
		});
		
		tglbtnDonut.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED ) {
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
				}
			}
		});
		
		tglbtnSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED )	{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDelete.setSelected(false);
				}
			}
		});
		
		tglbtnDelete.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED ) {
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnRectangle.setSelected(false);
				}
			}
		});
		
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				koordinata.setText("x " + e.getX()+", y " + e.getY());
			}
		});
		
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(tglbtnPoint.isSelected()) {
					Point p=new Point(e.getX(),e.getY());
					canvas.getShapes().add(p);
					repaint();
				}
				
				if(tglbtnLine.isSelected())
				{
					if(twoPoints==false){
		                nextPoint = new Point(e.getX(),e.getY());
		                twoPoints = true;
		            }
		            else {
		                previousPoint = nextPoint;
		                nextPoint = new Point(e.getX(),e.getY());

		                Line l=new Line(previousPoint,nextPoint);
		                canvas.getShapes().add(l);
		                repaint();
		                previousPoint=new Point();
		                twoPoints=false;
		            }
				}
				
				if(tglbtnRectangle.isSelected()) {
					Point upperLeft = new Point(e.getX(),e.getY());
					dlgrec = new RectangleDlg();
					dlgrec.setVisible(true);

					if(dlgrec.commited==true) {
						int width=Integer.parseInt(dlgrec.widthField.getText());
						int height=Integer.parseInt(dlgrec.heightField.getText());
					 
						Rectangle r = new Rectangle(upperLeft,width,height);
					 
						canvas.getShapes().add(r);
						repaint();
					}
				}
				
				if(tglbtnCircle.isSelected()) {
					Point center=new Point(e.getX(),e.getY());
					dlgcir = new CircleDlg();
					dlgcir.setVisible(true);

					if(dlgcir.check==true) {
						int radius=Integer.parseInt(dlgcir.textFieldRadius.getText());
						Circle c=new Circle(center,radius);
					 
						canvas.getShapes().add(c);
						repaint();
					}
				}
				
				if(tglbtnDonut.isSelected()) {
					Point center=new Point(e.getX(),e.getY());
					dlgdon=new DonutDlg();
					dlgdon.setVisible(true);

					if(dlgdon.check==true) {
						int radius=Integer.parseInt(dlgdon.textFieldRadius.getText());
						int innerRadius=Integer.parseInt(dlgdon.textFieldInnerRadius.getText());
					 
						Donut d=new Donut(center,radius,innerRadius);
	
						canvas.getShapes().add(d);
						repaint();
					}
				}
				
				if(tglbtnSelect.isSelected()) {
					for(Shape s:canvas.getShapes()) {
						if(s.contains(e.getX(),e.getY())) {
							if(s instanceof Point) {
								Point temp=(Point)s;
								Point novi=new Point();
								
								dlgp=new PointDlg();
								dlgp.getTextFieldX().setText(Integer.toString(temp.getX()));
								dlgp.getTextFieldY().setText(Integer.toString(temp.getY()));
								
								dlgp.setVisible(true);
								if(dlgp.check) 	{
									novi.setSelected(true);
									novi.setC(dlgp.c);
									novi.moveOn(Integer.parseInt(dlgp.getTextFieldX().getText()), Integer.parseInt(dlgp.getTextFieldY().getText()));
	
								canvas.getShapes().set(canvas.getShapes().indexOf(temp), novi);
								repaint();
								}
							}
							if(s instanceof Line) {
								Line temp=(Line)s;
								Line novi=new Line();
								
								dlgl=new LineDlg();
								dlgl.getTextFieldStartX().setText(Integer.toString(temp.getStartPoint().getX()));
								dlgl.getTextFieldStartY().setText(Integer.toString(temp.getStartPoint().getY()));
								dlgl.getTextFieldEndX().setText(Integer.toString(temp.getEndPoint().getX()));
								dlgl.getTextFieldEndY().setText(Integer.toString(temp.getEndPoint().getY()));
								dlgl.setVisible(true);
								
								if(dlgl.check) {
									novi.setSelected(true);
									novi.setC(dlgl.c);
									novi.setStartPoint(new Point(Integer.parseInt(dlgl.getTextFieldStartX().getText()),Integer.parseInt(dlgl.getTextFieldStartY().getText())));
									novi.setEndPoint(new Point(Integer.parseInt(dlgl.getTextFieldEndX().getText()),Integer.parseInt(dlgl.getTextFieldEndY().getText())));		
								
									canvas.getShapes().set(canvas.getShapes().indexOf(temp), novi);
									repaint();
								}		
							}
							
							if(s instanceof Circle) {
								Circle temp=(Circle)s;
								Circle novi=new Circle();
								
								dlgcirm=new CircleDlgModify();
								dlgcirm.getTextFieldRadius().setText(Integer.toString(temp.getRadius()));
								dlgcirm.getTextFieldX().setText(Integer.toString(temp.getCenter().getX()));
								dlgcirm.getTextFieldY().setText(Integer.toString(temp.getCenter().getY()));
									dlgcirm.setVisible(true);
								
								if(dlgcirm.check) {
									novi.setSelected(true);
									novi.setCenter(new Point(Integer.parseInt(dlgcirm.getTextFieldX().getText()),Integer.parseInt(dlgcirm.getTextFieldY().getText())));
									try {
										novi.setRadius(Integer.parseInt(dlgcirm.getTextFieldRadius().getText()));
									} 
									catch (NumberFormatException e1) {
										e1.printStackTrace();
									} 
									catch (Exception e1) {	
										e1.printStackTrace();
									}
									novi.setC(dlgcirm.c);
									
									canvas.getShapes().set(canvas.getShapes().indexOf(temp), novi);
									repaint();
								}
							}
								
							if(s instanceof Rectangle) {
								Rectangle temp=(Rectangle)s;
								Rectangle novi=new Rectangle();
								
								dlgrecm=new RectangleDlgModify();
								dlgrecm.getTextFieldWidth().setText(Integer.toString(temp.getWidth()));
								dlgrecm.getTextFieldHeight().setText(Integer.toString(temp.getHeight()));
								dlgrecm.getTextFieldX().setText(Integer.toString(temp.getUpperLeft().getX()));
								dlgrecm.getTextFieldY().setText(Integer.toString(temp.getUpperLeft().getY()));
								dlgrecm.setVisible(true);
									
								if(dlgrecm.commited) {
									novi.setSelected(true);
									novi.setC(dlgrecm.c);
									novi.setWidth(Integer.parseInt(dlgrecm.getTextFieldWidth().getText()));
									novi.setHeight(Integer.parseInt(dlgrecm.getTextFieldHeight().getText()));
									novi.setUpperLeft(new Point(Integer.parseInt(dlgrecm.getTextFieldX().getText()),Integer.parseInt(dlgrecm.getTextFieldY().getText())));
										
									canvas.getShapes().set(canvas.getShapes().indexOf(temp), novi);
									repaint();
								}	
							}
								
							if(s instanceof Donut) {
								Donut temp=(Donut)s;
								Donut novi=new Donut();
								
								dlgdonm=new DonutDlgModify();
								
								dlgdonm.getTextFieldOR().setText(Integer.toString(temp.getRadius()));
								dlgdonm.getTextFieldIR().setText(Integer.toString(temp.getInnerRadius()));
								dlgdonm.getTextFieldX().setText(Integer.toString(temp.getCenter().getX()));
								dlgdonm.getTextFieldY().setText(Integer.toString(temp.getCenter().getY()));
								
								dlgdonm.setVisible(true);
									
								if(dlgdonm.check) {
									novi.setSelected(true);
									novi.setC(dlgdonm.c);
									novi.setCenter(new Point(Integer.parseInt(dlgdonm.getTextFieldX().getText()),Integer.parseInt(dlgdonm.getTextFieldY().getText())));
									try {
										novi.setRadius(Integer.parseInt(dlgdonm.getTextFieldOR().getText()));
									} 
									catch (NumberFormatException e1) {
										e1.printStackTrace();
									} 
									catch (Exception e1) {
										e1.printStackTrace();
									}
									novi.setInnerRadius(Integer.parseInt(dlgdonm.getTextFieldIR().getText()));
										
									canvas.getShapes().set(canvas.getShapes().indexOf(temp), novi);
									repaint();	
								}	
							}
						}	
					}
				}	
					if(tglbtnDelete.isSelected()) {
						for(int j=0; j< canvas.getShapes().size(); j++) {
							if(canvas.getShapes().get(j).contains(e.getX(),e.getY())) {
								int res = JOptionPane.showConfirmDialog(null, 
								         "Da li ste sigurni da zelite da obrisete?", 
								         "Brisanje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if(res==JOptionPane.YES_OPTION)	{
									canvas.getShapes().remove(canvas.getShapes().get(j));
								}
							}	
							repaint();
						}
					}
			}
			
		});
	}
}
