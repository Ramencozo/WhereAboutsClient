package jp.ramensroom.hellowebsocketclientx86;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class UserStatus{
	
	private static final int FONT_SIZE = 42;
	
	private int myID;
	
	private JPanel panel;
	private JLabel idLabel;
	private JTextField nameField;
//	private JTextField orgField;
	private JTextField placeField;

	public UserStatus(int id){	
		myID = id;
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout());
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(1, 2));
		infoPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		infoPanel.setPreferredSize(new Dimension(FONT_SIZE * 20, FONT_SIZE + 10));
		
		idLabel = new JLabel(myID + ":");
		idLabel.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, FONT_SIZE));
		
		nameField = new JTextField("John Doe");
		nameField.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, FONT_SIZE));
		nameField.setBorder(new LineBorder(Color.blue, 2));
		
//		orgField = new JTextField("none");
//		orgField.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, FONT_SIZE));
//		orgField.setBorder(new LineBorder(Color.blue, 2));
		
		placeField = new JTextField("Anywhere");
		placeField.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, FONT_SIZE));
		placeField.setBorder(new LineBorder(Color.blue, 2));
		
		idPanel.add(idLabel);

		infoPanel.add(nameField);
//		infoPanel.add(orgField);
		infoPanel.add(placeField);
		
		panel.add(idPanel);
		panel.add(infoPanel);
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	public int getID(){
		return myID;
	}
	
	public void setName(String name){
		nameField.setText(name);
	}
	public String getName(){
		return nameField.getText();
	}

//	public void setOrg(String org){
//		orgField.setText(org);
//	}
//	public String getOrg(){
//		return orgField.getText();
//	}

	public void setPlace(String place){
		placeField.setText(place);
	}
	public String getPlace(){
		return placeField.getText();
	}
}