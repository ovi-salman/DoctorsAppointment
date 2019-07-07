package doctorAppoinment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.DefaultTableModel;

public class DoctorsOfCardiology extends JFrame implements ActionListener{
	
	//Table Object Reference
	JTable cardiologyDoctorTable;
	
	//Button Object Reference
	JButton continueButton;
	
	//Label Object Reference
	JLabel submitDoctorId;
	
	//TextField Object Reference
	JTextField doctorIdTextField;
	
	String thisLine = null;
	
	public DoctorsOfCardiology(){
		super("Doctors Details");
		this.setLayout(null);
		this.setSize(450, 350);
		this.setLocation(780, 260);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.cyan);
		this.setVisible(true);
		addElements();
		
	}
public void addElements(){
	
        //Add table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Doctor Name");
        model.addColumn("Degree");
        model.addColumn("Room No");
        model.addColumn("App.Time");
        model.addRow(new Object []{"ID","Doctors Name","Degree","Room No","App.Time"});
        
        
        cardiologyDoctorTable = new JTable(model);
        cardiologyDoctorTable.setBounds(0, 50, 450, 70);
        cardiologyDoctorTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        cardiologyDoctorTable.getColumnModel().getColumn(0).setPreferredWidth(2);
        cardiologyDoctorTable.getColumnModel().getColumn(2).setPreferredWidth(2);
        cardiologyDoctorTable.getColumnModel().getColumn(3).setPreferredWidth(2);
        this.add(cardiologyDoctorTable);
        
        //Add Button
        continueButton = new JButton("Submit");
        continueButton.setBounds(170, 230, 80, 40);
        this.add(continueButton);
        continueButton.addActionListener(this);
        
        //Add Label
        submitDoctorId = new JLabel("Give doctor id to set appointment");
        submitDoctorId.setBounds(120, 150, 500, 40);
        this.add(submitDoctorId);
        
        //Add Text Field
        doctorIdTextField = new JTextField();
        doctorIdTextField.setBounds(160, 190, 100, 30);
        this.add(doctorIdTextField);
        
        
        try{ 
            BufferedReader br = new BufferedReader(new FileReader("src/doctorAppoinment/DoctorsOfCardiology.txt"));
            while((thisLine = br.readLine()) != null){
                
                String parts[] = thisLine.split(",");
                model.addRow(new Object[]{parts[0],parts[1],parts[2],parts[3],parts[4]});
                
            }
            
        
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
				if(doctorIdTextField.getText().equals("101")){
			JOptionPane.showMessageDialog(null, "You Successfully Set Appointment With Dr. Ashfaq ul Nipun ");
		}
				else if(doctorIdTextField.getText().equals("102")){
					JOptionPane.showMessageDialog(null, "You Successfully Set Appointment With Dr. Moumita ul Chatterji ");
				}
				else if(doctorIdTextField.getText().equals("103")){
					JOptionPane.showMessageDialog(null, "You Successfully Set Appointment With Dr. Shukanto ul Bisshash ");
				}
		
	}

}
