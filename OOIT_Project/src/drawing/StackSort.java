package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import geometry.Point;
import geometry.Rectangle;

public class StackSort extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int i = 0;
	private JPanel contentPane;
	private JPanel buttonPanel;
	private JPanel panel;
	private String rectangle;
	private Stack<Rectangle> stack = new Stack<Rectangle>();
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private HashMap<String, Rectangle> object = new HashMap<String, Rectangle>();
	private HashMap<String, Integer> srt = new HashMap<String, Integer>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private RectangleDlgModify dlgRM;
	private JToggleButton add;
	private JToggleButton remove;
	private JToggleButton sort;
	private JList<String> list;
	private JLabel recStack;



	/**
	 * Create the frame.
	 */
	public StackSort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
	
		add = new JToggleButton("Add Rectangle");
		add.addActionListener(this);
		buttonGroup.add(add);
		buttonPanel.add(add);
		
		sort = new JToggleButton("Sort");
		sort.addActionListener(this);
		buttonGroup.add(sort);
		buttonPanel.add(sort);
		
		remove = new JToggleButton("Remove Rectangle");
		remove.addActionListener(this);
		buttonGroup.add(remove);
		buttonPanel.add(remove);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout(0,0));
		contentPane.add(panel, BorderLayout.CENTER);
		
		list = new JList<String>();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(list);
		
		recStack = new JLabel("Rectangle Stack");
		recStack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		recStack.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(recStack, BorderLayout.NORTH);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(add.isSelected()) {
			add();
		}else if(remove.isSelected()) {
			remove();
		}else if(sort.isSelected()) {
			sort();
		}
	}
	
	protected void add() {
		dlgRM = new RectangleDlgModify();
		dlgRM.setTitle("Add Rectangle");
		dlgRM.getLblRectangle().setText("Add Rectangle");
		dlgRM.setVisible(true);
		
		if(dlgRM.isCommited()) {
			i++;
			Rectangle r = new Rectangle(new Point(Integer.parseInt(dlgRM.getUpperLeftXField().getText()),Integer.parseInt(dlgRM.getUpperLeftYField().getText())),
			Integer.parseInt(dlgRM.getWidthField().getText()),Integer.parseInt(dlgRM.getHeightField().getText()));
			stack.push(r);
			rectangle = i+". Rectangle area: " +r.area();
			int area = r.area();
			srt.put(rectangle, area);
			object.put(rectangle, r);
			listModel.add(0, rectangle);
			list.setModel(listModel);
			//System.out.println(stack);
		}
	}
	protected void remove() {
		if(list.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Please select object to remove!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else {
			if(object.containsKey(list.getSelectedValue())) {		
				dlgRM = new RectangleDlgModify();
				dlgRM.setTitle("Remove Rectangle");
				dlgRM.getLblRectangle().setText("Remove Rectangle");
				dlgRM.getOkButton().setText("Remove");
				Rectangle r = object.get(list.getSelectedValue());
				dlgRM.getHeightField().setText(Integer.toString(r.getHeight()));
				dlgRM.getWidthField().setText(Integer.toString(r.getWidth()));
				dlgRM.getUpperLeftXField().setText(Integer.toString(r.getUpperLeft().getX()));
				dlgRM.getUpperLeftYField().setText(Integer.toString(r.getUpperLeft().getY()));
				dlgRM.setVisible(true);
				
				if(dlgRM.isCommited()) {
					stack.remove(object.get(list.getSelectedValue()));
					object.remove(list.getSelectedValue());
					srt.remove(list.getSelectedValue());
					listModel.remove(list.getSelectedIndex());
					list.setModel(listModel);
					//System.out.println(stack);
				}
			}		
		}
	}
	protected void sort() {
		if(list.getModel().getSize() == 0) {
			JOptionPane.showMessageDialog(null, "List is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else {
			listModel.removeAllElements();
			list.setModel(listModel);
			HashMap<String,Integer> sorted = sortByValue(srt);
			for (Map.Entry<String, Integer> en : sorted.entrySet()) {
				listModel.add(0,en.getKey());
			}
				list.setModel(listModel);
		}
	}	
	protected static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
	       List <Map.Entry<String, Integer>> list = new LinkedList <Map.Entry<String, Integer>>(hm.entrySet());
	        
	        Collections.sort(list, (i1,i2) -> i1.getValue().compareTo(i2.getValue()));
	        
	        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
	        
	        for (Map.Entry<String, Integer> aa : list) {
	            temp.put(aa.getKey(), aa.getValue());
	        }
	        return temp;
	    }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackSort frame = new StackSort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
