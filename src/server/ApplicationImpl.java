package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import common.Application;

public class ApplicationImpl extends UnicastRemoteObject implements Application {
    Battery battery = new Battery(92, 67);
    RobotLocation location = new RobotLocation("bedroom", 65.7, 45.8);
    AppDataDisplay display;
    JFrame frame;

    public ApplicationImpl() throws Exception {
	display = new AppDataDisplay(battery, location);
	frame = new JFrame();
    }

    @Override
    public void startAutoMode() throws RemoteException {
	frame.getContentPane().setLayout(null);

	JTextArea txt = new JTextArea();
	txt.setBounds(40, 100, 300, 190);
	frame.getContentPane().add(txt);

	JButton resetbtn = new JButton("Reset");
	resetbtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		txt.setText("");
	    }
	});
	resetbtn.setBounds(200, 50, 140, 23);
	frame.getContentPane().add(resetbtn);

	JButton submitbtn = new JButton("Start Auto Mode");
	submitbtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		display.startMyAutoMode();
		txt.setText("Auto mode starting.........\n");
		txt.append("The robot is generating the map of the.........\n");
		txt.append(display.toString());
	    }
	});
	submitbtn.setBounds(40, 50, 140, 23);
	frame.getContentPane().add(submitbtn);

	frame.setVisible(true);
	frame.setSize(400, 400);
    }

}
