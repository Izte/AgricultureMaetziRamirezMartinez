package grpc.ca.agriculture3;

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

import grpc.ca.agriculture3.cropServiceGrpc.cropServiceBlockingStub;
import grpc.ca.agriculture3.cropServiceGrpc.cropServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class Service3GUIApplication {
	public static void main(String[] args) {
		JFrame  frame = new JFrame ("Crop Service");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();
		//stubs --- generate from proto
		
		cropServiceBlockingStub blockingStub = cropServiceGrpc.newBlockingStub(channel);
		cropServiceStub asyncStub = cropServiceGrpc.newStub(channel);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel panelText = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JTextPane textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension( 450, 480 ) );
        textPane.setEditable(false);
		
        JButton cropStatusButton = new JButton("Get CropStatus");
		JButton cropPlanButton = new JButton("Get CropPlan");
        
		panel.add(cropStatusButton, BorderLayout.NORTH);
		panel.add(cropPlanButton, BorderLayout.CENTER);
        panelText.add(textPane, BorderLayout.CENTER);
        
        frame.getContentPane().add(panel, BorderLayout.WEST);
		frame.getContentPane().add(panelText, BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(640,480);
		
		discoveryService3Crop("_service3._tcp.local.");
		
		cropStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	StreamObserver<CropStatusResponse> replyCS = new StreamObserver<CropStatusResponse>() {

            			@Override
            			public void onNext(CropStatusResponse msg) {
            				// TODO Auto-generated method stub
            				textPane.setText("");
                            textPane.setText("Message sent by the server: \n" + msg.getMycropstatus());
            			}

            			@Override
            			public void onError(Throwable t) {
            				// TODO Auto-generated method stub
            				t.printStackTrace();
            			}

            			@Override
            			public void onCompleted() {
            				// TODO Auto-generated method stub
            				System.out.println("Crop Status finished ");
            			}
            			
            		};
                	
            		StreamObserver<CropTypeRequest> requestCT = asyncStub.getCropStatus(replyCS);
            		try {
            			requestCT.onNext(CropTypeRequest.newBuilder().setMycroptype("Corn").build());
            			Thread.sleep(500);
            			
            			requestCT.onNext(CropTypeRequest.newBuilder().setMycroptype("Potato").build());
            			Thread.sleep(500);
            			
            			requestCT.onNext(CropTypeRequest.newBuilder().setMycroptype("Squash").build());
            			Thread.sleep(500);
            			
            			// Mark the end of request
            			requestCT.onCompleted();
            			
            			Thread.sleep(10000);
            		} catch (RuntimeException ex) {
            			ex.printStackTrace();
            		} catch(InterruptedException ex) {
            			ex.printStackTrace();
            		}
                	
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                }
			}
		});
		
		cropPlanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	
                	CropPlanRequest requestCPR = CropPlanRequest.newBuilder().setMycroptype("Irrigate the crop twice per week ").build();
            		StreamObserver<CropPlanResponse> responseObserver = new StreamObserver<CropPlanResponse>() {

            			@Override
            			public void onNext(CropPlanResponse value) {
            				// TODO Auto-generated method stub
							textPane.setText("");
		                    textPane.setText("Message sent by the server: \n" + value.getCropPlan());
							
						}

						@Override
						public void onError(Throwable t) {
							// TODO Auto-generated method stub
							t.printStackTrace();
						}

						@Override
						public void onCompleted() {
							// TODO Auto-generated method stub
							System.out.println("Crop Plan");
						}
                		
					};
					asyncStub.getCropPlan(requestCPR, responseObserver);
                    
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                }
			}
		});
		
	}
	
	private static void discoveryService3Crop(String service_type) {

		try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            jmdns.addServiceListener(service_type, new ServiceListener() {
                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Crop Service resolved: " + event.getInfo());

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
                    System.out.println("Crop Service removed: " + event.getInfo());
                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Crop Service added: " + event.getInfo());
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
