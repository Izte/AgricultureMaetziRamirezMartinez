package grpc.ca.agriculture2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
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
		
		irrigationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	
                	IrrigationParametersRequest request = IrrigationParametersRequest.newBuilder().setMyirrigationparameters("between 10 to 15 ").build();
                	IrrigationStatusResponse replyIS = blockingStub.setIrrigation(request);
                	
                    textPane.setText("");
                    textPane.setText("Message sent by the server: " + replyIS.getMyirrigationstatusResponse());
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
		                    textPane.setText("Message sent by the server: " + value.getMycurrentstatusResponse());
							
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
                            textPane.setText("Message sent by the server: " + msg.getMycancelationresponse());
                            
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
}
