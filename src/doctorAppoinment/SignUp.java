package doctorAppoinment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;

public class SignUp extends JFrame {

	// Label Object Reference
	JLabel fullName;
	JLabel emailLabel;
	JLabel passLabel;
	JLabel groupLabel;

	// Text Field Object Reference
	JTextField fullNameField;
	JTextField fieldEmail;
	JPasswordField fieldPass;

	// Button Object Reference
	JButton signUpButton;

	// ComboBox object reference
	JComboBox cuserTypeBox;
	String[] userTypeBox = { "Patient", "Doctor" };
	boolean isRegisterd = false;
	String thisLine = null;

	public SignUp() {
		super("Signup");
		this.setLayout(null);
		this.setSize(450, 350);
		this.setLocation(780, 260);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.cyan);
		addComponent();
		addAction();
	}

	public void addComponent() {
		// Add Label
		fullName = new JLabel("Full Name :");
		emailLabel = new JLabel("Email :");
		passLabel = new JLabel("Password :");
		groupLabel = new JLabel("Group");
		fullName.setBounds(100, 20, 100, 30);
		emailLabel.setBounds(100, 70, 100, 30);
		passLabel.setBounds(100, 120, 100, 30);
		this.add(fullName);
		this.add(emailLabel);
		this.add(passLabel);

		// Add Text Field
		fullNameField = new JTextField();
		fieldEmail = new JTextField();
		fieldPass = new JPasswordField();
		fullNameField.setBounds(180, 20, 150, 30);
		fieldEmail.setBounds(180, 70, 150, 30);
		fieldPass.setBounds(180, 120, 150, 30);
		this.add(fullNameField);
		this.add(fieldEmail);
		this.add(fieldPass);

		// Add Signup Button
		signUpButton = new JButton("Sign Up");
		signUpButton.setBounds(180, 220, 80, 50);
		this.add(signUpButton);

		// Add Combo Box
		cuserTypeBox = new JComboBox(userTypeBox);
		cuserTypeBox.setBounds(180, 170, 100, 30);
		this.add(cuserTypeBox);

	}

	// Add Action
	public void addAction() {
		signUpButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Check for Blank Submission for Email and Password

				String p = new String(fieldPass.getPassword());
				if (fieldEmail.getText().isEmpty() || p.isEmpty() || fullNameField.getText().isEmpty()){

					JOptionPane.showMessageDialog(null, "Please Submit Your full Name & Email & Password");
				}
				// Check For Already Signed Up For Patient
				else {
					if (cuserTypeBox.getSelectedItem() == "Patient") {
						try {

							BufferedReader br = new BufferedReader(
									new FileReader("src/doctorAppoinment/PatientLoginDetails.txt"));
							while ((thisLine = br.readLine()) != null) {
								String[] parts = thisLine.split(",");

								if ((parts[0].equals(fieldEmail.getText()))) {
									JOptionPane.showMessageDialog(null,
											"You Are Already Signed Up as Patient Plz login");
									isRegisterd = true;

									dispose();
									Login login = new Login();
									break;
								}

							}
							br.close();

							if (isRegisterd == false) {
								BufferedWriter bw = new BufferedWriter(
										new FileWriter("src/doctorAppoinment/PatientLoginDetails.txt", true));
								bw.write(fieldEmail.getText() + "," + fieldPass.getText() + ","
										+ fullNameField.getText());
								bw.newLine();

								bw.flush();

								JOptionPane.showMessageDialog(null,
										"Sign Up Successfull As Patient now you can Signin");
								dispose();
								Login login = new Login();
							}

						} catch (Exception exception) {
							exception.printStackTrace();
						}
					}

					// Check For Already Signed Up For Doctor

					else {
						try {

							BufferedReader br = new BufferedReader(
									new FileReader("src/doctorAppoinment/DoctorLoginDetails.txt"));
							while ((thisLine = br.readLine()) != null) {
								String[] parts = thisLine.split(",");

								if ((parts[0].equals(fieldEmail.getText()))) {

									JOptionPane.showMessageDialog(null,
											"You Are Already Signed Up as Doctor Plz login");
									isRegisterd = true;
									dispose();
									Login login = new Login();
									break;
								}
							}
							br.close();
							if (isRegisterd == false) {
								BufferedWriter bw = new BufferedWriter(
										new FileWriter("src/doctorAppoinment/DoctorLoginDetails.txt", true));
								bw.write(fieldEmail.getText() + "," + fieldPass.getText() + ","
										+ fullNameField.getText());
								bw.newLine();

								bw.flush();

								JOptionPane.showMessageDialog(null, "Sign Up Successfull now you can Signin");
								dispose();
								Login login = new Login();
							}

						} catch (Exception exception) {
							exception.printStackTrace();
						}

					}
				}
			}

		});

	}

}