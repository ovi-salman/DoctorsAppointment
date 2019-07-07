package doctorAppoinment;

import java.awt.Color;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DepartmentDoctor extends JFrame implements ActionListener {
	//Reference of Labels
	JLabel departmenLabel;
	JLabel doctorLabel;

	//Reference of ComboBox
	JComboBox rDepartmentTypeBox;
	String[] departmentTypeBox = { "Cardiology", "Surgery" };
	
	//Reference of Button
	JButton continueBtn;
	
	//Constructor
		public DepartmentDoctor() {
			super("Department");
			this.setLayout(null);
			this.setSize(450,350);
			this.setLocation(780, 260);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.getContentPane().setBackground(Color.cyan);
			addComponent();
			this.setVisible(true);
			
		}
	
	public void addComponent(){
		
		//Add Label
		departmenLabel = new JLabel("Department :");
		departmenLabel.setBounds(80,80, 80, 30);
		this.add(departmenLabel);
		
		
		//Add Button
		continueBtn = new JButton("Continue");
		continueBtn.setBounds(140, 140, 100, 60);
		this.add(continueBtn);
		
		//Add ComboBox
		rDepartmentTypeBox = new JComboBox(departmentTypeBox);
		rDepartmentTypeBox.setBounds(180,80, 100, 30);
		this.add(rDepartmentTypeBox);
		
		//Add Action Listener
		continueBtn.addActionListener(this);
		
		
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(rDepartmentTypeBox.getSelectedItem()=="Cardiology"){
		DoctorsOfCardiology doctorsOfCardiology = new DoctorsOfCardiology();
		dispose();
		}
		else{
			DoctorsOfSurgery doctorsOfSurgery = new DoctorsOfSurgery();
			dispose();
		}
		
	}
	
	
	
	
}
