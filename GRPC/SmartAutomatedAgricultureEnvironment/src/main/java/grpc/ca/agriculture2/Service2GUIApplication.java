package grpc.ca.agriculture2;

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

import grpc.ca.agriculture2.irrigationServiceGrpc.irrigationServiceBlockingStub;
import grpc.ca.agriculture2.irrigationServiceGrpc.irrigationServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class Service2GUIApplication {

	public static void main(String[] args) {
		JFrame  frame = new JFrame ("Irrigation Service");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
		//stubs --- generate from proto
		
		irrigationServiceBlockingStub blockingStub = irrigationServiceGrpc.newBlockingStub(channel);
		irrigationServiceStub asyncStub = irrigationServiceGrpc.newStub(channel);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel panelText = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JTextPane textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension( 450, 480 ) );
        textPane.setEditable(false);
        
        JButton irrigationButton = new JButton("Set Irrigation");
		JButton irrigStatusButton = new JButton("Get Irrigation Status");
		JButton cancelIrrigButton = new JButton("Cancel Irrigation");
		
		panel.add(irrigationButton, BorderLayout.NORTH);
		panel.add(irrigStatusButton, BorderLayout.CENTER);
		panel.add(cancelIrrigButton, BorderLayout.SOUTH);
        panelText.add(textPane, BorderLayout.CENTER);
        
        frame.getContentPane().add(panel, BorderLayout.WEST);
		frame.getContentPane().add(panelText, BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(640,480);
		
		discoveryService2Irrigation("_service2._tcp.local.");
		
		irrigationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	
                	IrrigationParametersRequest request = IrrigationParametersRequest.newBuilder().setMyirrigationparameters("between 10 to 15 ").build();
                	IrrigationStatusResponse replyIS = blockingStub.setIrrigation(request);
                	
                    textPane.setText("");
                    textPane.setText("Message sent by the server: \n" + replyIS.getMyirrigationstatusResponse());
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                }
			}
		});
		
		irrigStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	
                	LocationParametersRequest requestLP = LocationParametersRequest.newBuilder().setLatitude(51).setLongitude(31).build();
                	//CurrentStatusResponse replyCS = blockingStub.getIrrigStatus(requestLP);
                	
                	StreamObserver<CurrentStatusResponse> replyCS = new StreamObserver<CurrentStatusResponse>() {

						@Override
						public void onNext(CurrentStatusResponse value) {
							// TODO Auto-generated method stub
							textPane.setText("");
		                    textPane.setText("Message sent by the server: \n" + value.getMycurrentstatusResponse());
							
						}

						@Override
						public void onError(Throwable t) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onCompleted() {
							// TODO Auto-generated method stub
							System.out.println("Current Status");
						}
                		
					};
					asyncStub.getIrrigStatus(requestLP, replyCS);
                    
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                }
			}
		});
		
		cancelIrrigButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                                	
                	StreamObserver<CancelationResponse> responseObserver = new StreamObserver<CancelationResponse>() {

            			@Override
            			public void onNext(CancelationResponse msg) {
            				// TODO Auto-generated method stub
            				
            				textPane.setText("");
                            textPane.setText("Message sent by the server: \n" + msg.getMycancelationresponse());
                            
            			}

            			@Override
            			public void onError(Throwable t) {
            				// TODO Auto-generated method stub
            				t.printStackTrace();
            			}

            			@Override
            			public void onCompleted() {
            				// TODO Auto-generated method stub
            				System.out.println("Cancelation is completed");
            			}
            		
            		};
            		StreamObserver<CancelationRequest> requestObserver = asyncStub.cancelIrrigation(responseObserver);
            		
            		try {
            		
            			requestObserver.onNext(CancelationRequest.newBuilder().setMycancelationrequest("Cancel irrigation ").build());
            			requestObserver.onCompleted();
            		}catch(RuntimeException ex){
            			ex.printStackTrace();
            		}
            		
            		try {
            			Thread.sleep(15000);
            		} catch(InterruptedException ex) {
            			//TODO Auto-generated catch block
            			ex.printStackTrace();
            		}
                	
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                }
			}
		});
		
	}
	
	private static void discoveryService2Irrigation(String service_type) {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            jmdns.addServiceListener(service_type, new ServiceListener() {
                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Irrigation Service resolved: " + event.getInfo());

                    ServiceInfo climateInfo = event.getInfo();

                    int port = climateInfo.getPort();

                    System.out.println("\n resolving " + service_type + " with the following properties: ");
                    System.out.println("\n service_type:" + event.getType());
                    System.out.println("\n service_name: " + event.getName());
                    System.out.println("\n service_description: " + climateInfo.getNiceTextString());
                    System.out.println("\n service_port: " + port);                                       
                    System.out.println("\n host: " + climateInfo.getHostAddresses()[0]);
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Irrigation Service removed: " + event.getInfo());
                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Irrigation Service added: " + event.getInfo());
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
}
