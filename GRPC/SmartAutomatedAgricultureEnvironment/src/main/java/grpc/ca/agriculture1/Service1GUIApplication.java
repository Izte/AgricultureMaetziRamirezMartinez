package grpc.ca.agriculture1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.JButton;

import grpc.ca.agriculture1.climateServiceGrpc.climateServiceBlockingStub;
import grpc.ca.agriculture1.climateServiceGrpc.climateServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Service1GUIApplication {
	
	private static void discoveryService1Climate(String service_type) {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            jmdns.addServiceListener(service_type, new ServiceListener() {
                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Climate Service resolved: " + event.getInfo());

                    ServiceInfo climateInfo = event.getInfo();

                    int port = climateInfo.getPort();

                    System.out.println("resolving " + service_type + " with properties ...");
                    System.out.println("\t service_port: " + port);
                    System.out.println("\t service_type:" + event.getType());
                    System.out.println("\t service_name: " + event.getName());
                    System.out.println("\t service_description: " + climateInfo.getNiceTextString());
                    System.out.println("\t host: " + climateInfo.getHostAddresses()[0]);
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Climate Service removed: " + event.getInfo());
                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Climate Service added: " + event.getInfo());
                }
            });

            // Wait a bit
            Thread.sleep(2000);

            jmdns.close();

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		JFrame  frame = new JFrame ("Climate Service");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		//stubs --- generate from proto
		
		climateServiceBlockingStub blockingStub = climateServiceGrpc.newBlockingStub(channel);
		climateServiceStub asyncStub = climateServiceGrpc.newStub(channel);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel panelText = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JTextPane textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension( 600, 480 ) );
        textPane.setEditable(false);
        
        JButton temperatureButton = new JButton("Get Temperature");
		JButton humidityButton = new JButton("Get Humidity");
		JButton rainfullButton = new JButton("Get Rainfall");
        
		panel.add(temperatureButton, BorderLayout.NORTH);
		panel.add(humidityButton, BorderLayout.CENTER);
		panel.add(rainfullButton, BorderLayout.SOUTH);
        panelText.add(textPane, BorderLayout.CENTER);
        
        frame.getContentPane().add(panel, BorderLayout.WEST);
		frame.getContentPane().add(panelText, BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600,500);
		
		discoveryService1Climate("_service1._tcp.local.");
		
		temperatureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	
                	TemperatureRequest request = TemperatureRequest.newBuilder().setMytemperature("The temperatur is 14 degrees").build();
                	TemperatureResponse reply = blockingStub.getTemperature(request);
                	
                    textPane.setText("");
                    textPane.setText("Message sent by the server: " + reply.getMytemperatureresponse());
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                }
			}
		});

		humidityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	HumidityRequest request = HumidityRequest.newBuilder().setMyhumidity("The humidity is 60% ").build();
                	
                	HumidityResponse reply = blockingStub.getHumidity(request);
                	
                    textPane.setText("");
                    textPane.setText("Message sent by the server: " + reply.getMyhumidityresponse());
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                }
			}
		});
		
		rainfullButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	RainfallRequest request = RainfallRequest.newBuilder().setMystartdate("From 12th to 14ht April 2023, ").setMyenddate("light rain showers 0.1mm ").build();
                            
                	RainfallResponse reply = blockingStub.getRain(request);
                    textPane.setText("light rain showers 0.1mm ");
                    textPane.setText("Message sent by the server: " + reply.getMyrainfalrResponse());
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                }
			}
		});
	}
	
}//end class