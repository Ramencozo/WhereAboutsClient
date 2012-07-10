package jp.ramensroom.hellowebsocketclientx86;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.roderick.weberknecht.WebSocketEventHandler;
import de.roderick.weberknecht.WebSocketMessage;

public class MainWindow extends JFrame{

	private static final int MEMBER_COUNT = 15;
	
	private WebSocketManager manager;
	
	private List<UserStatus> list;
	
	public MainWindow(){
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(MEMBER_COUNT, 1));
		
		
		list = new ArrayList<UserStatus>();
		
		for(int i=0; i<MEMBER_COUNT; i++){
			UserStatus status = new UserStatus(i);
			list.add(status);
			panel.add(list.get(i).getPanel());
		}
				
		container.add(panel);
		
		manager = new WebSocketManager();
		manager.connect("ws://192.168.1.4:38400/echo", new WebSocketEventHandler() {
			@Override
			public void onOpen() {
				System.out.println("---onOpen()---");
			}
			
			@Override
			public void onMessage(WebSocketMessage message) {
				final String msg = message.getText();
				System.out.println("---onMessage()---");
				System.out.println("Message: " + msg);
				
				String[] data = msg.split(",");
				
				int id = Integer.parseInt(data[0]);
				
				for(int i=0; i<list.size(); i++){
					if(id == list.get(i).getID()){
						list.get(i).setName(data[1]);
						list.get(i).setPlace(data[2]);
						break;
					}
				}
			}
			
			@Override
			public void onClose() {
				System.out.println("---onClose()---");
			}
		});
				
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}
}