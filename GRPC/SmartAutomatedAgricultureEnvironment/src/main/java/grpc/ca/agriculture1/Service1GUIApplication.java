package grpc.ca.agriculture1;

import java.awt.EventQueue;

import javax.jmdns.ServiceInfo;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import grpc.ca.agriculture1.climateServiceGrpc.climateServiceBlockingStub;
import grpc.ca.agriculture1.climateServiceGrpc.climateServiceStub;

public class Service1GUIApplication {
	
	private static climateServiceBlockingStub blockingstub;
	private static climateServiceStub asyncStub;
	
	private ServiceInfo service1ServiceInfo;
	
	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textNumber2;
	private JTextArea textResponse ;
	
	// Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service1GUIApplication window = new Service1GUIApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Create the application
	public Service1GUIApplication() {
		
	}

}
