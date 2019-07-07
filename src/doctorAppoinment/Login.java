 package doctorAppoinment;
 
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Login extends JFrame {
	
	
	
	//label object reference
	JLabel labelEmail;
	JLabel labelPass;
	JLabel labelGroup;
	//textField object reference
	JTextField emailField;
	JPasswordField passField;
	//Button object reference
	JButton btnLogin;
	JButton btnSignUp;
	//ComboBox object reference
	JComboBox cBoxUserType;
	String[] userTypes = { "Patient", "Doctor"};
	
	boolean isLoggedIn = false;
	//Constructor
	public Login(){
		super("Login Page");
		this.setLayout(null);
		this.setSize(450, 350);
		this.setLocation(780,260);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		addComponent();
		this.setVisible(true);
		addAction();
	}
	
	
	//Add Component Function
	public void addComponent(){
		//Add label
		labelEmail = new JLabel("Email : ");
		labelPass = new JLabel("Password : ");
		labelGroup = new JLabel("Group :");
		labelEmail.setBounds(10, 10, 100, 30);
		labelPass.setBounds(10, 50, 100, 30);
		labelGroup.setBounds(10, 90, 200, 30);
		this.add(labelEmail);
		this.add(labelPass);
		this.add(labelGroup);
		//Add Text Field
		emailField = new JTextField();
		passField = new JPasswordField();
		emailField.setBounds(170,10,150,30);
		passField.setBounds(170, 50, 150, 30);
		this.add(emailField);
		this.add(passField);
		//Add Button
		btnLogin = new JButton("Login");
		btnSignUp = new JButton("Signup");
		btnLogin.setBounds(170,160, 80, 30);
		btnSignUp.setBounds(170,200, 80, 30);
		this.add(btnLogin);
		this.add(btnSignUp);
		//Add Combo Box
		cBoxUserType = new JComboBox(userTypes);
		cBoxUserType.setBounds(170, 90, 100, 30);
		this.add(cBoxUserType);
		//add Color
		this.getContentPane().setBackground(Color.cyan);
	
	}
	
	
	//Add Action
	public void addAction(){
		//Add Action For Sign In Button
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(emailField.getText().isEmpty() || passField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please Submit Your Email & Password");
				}
				else{
				
				String thisLine = null;
				
			//Code for Patient
	       if(cBoxUserType.getSelectedItem()=="Patient"){
	        try{
	            BufferedReader br = new BufferedReader(new FileReader("src/doctorAppoinment/PatientLoginDetails.txt"));
	            while((thisLine = br.readLine()) != null){
	                String[] parts = thisLine.split(",");
	                //System.out.println(thisLine);
	                
	               if(emailField.getText().contentEquals(parts[0]) && passField.getText().contains(parts[1])){
	            	   isLoggedIn=true;
	            	   break;
	                }
	              
	            }
	            if(isLoggedIn==true){
	            	JOptionPane.showMessageDialog(null, "Successfully Sing In");
	            	DepartmentDoctor departmentDoctor =new DepartmentDoctor();
	            	dispose();
                }
               else  JOptionPane.showMessageDialog(null, "Try Again");
	        }  
	        
	        catch(Exception exception){
	        	exception.printStackTrace();
	        }
	        }
	       
	       //Code for Doctor
	       else if(cBoxUserType.getSelectedItem()=="Doctor"){
		        try{
		            BufferedReader br = new BufferedReader(new FileReader("src/doctorAppoinment/DoctorLoginDetails.txt"));
		            while((thisLine = br.readLine()) != null){
		                String[] parts = thisLine.split(",");
		                
		                
			               if(emailField.getText().contentEquals(parts[0]) && passField.getText().contains(parts[1])){
			            	   isLoggedIn=true;
			            	   break;
			                }
			               
			                
		                
		            }
		            if(isLoggedIn==true){
	                	JOptionPane.showMessageDialog(null, "Successfuly Log In");
	                }
	                else  JOptionPane.showMessageDialog(null, "Try Again");
		        }    
		        catch(Exception exception){
		        	exception.printStackTrace();
		        }
		        }
			}
		}
		});
		
		//Add Action for SignUp Button
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				SignUp signup = new SignUp();

				signup.setVisible(true);
				
				dispose();
				
			}
		});
		
	}
	}

