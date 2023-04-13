package grpc.ca.agriculture3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
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
		
		cropStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	StreamObserver<CropStatusResponse> replyCS = new StreamObserver<CropStatusResponse>() {

            			@Override
            			public void onNext(CropStatusResponse msg) {
            				// TODO Auto-generated method stub
            				textPane.setText("");
                            textPane.setText("Message sent by the server: " + msg.getMycropstatus());
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
                	
                	CropPlanRequest requestCPR = CropPlanRequest.newBuilder().setMycroptype("Healthy").build();
            		StreamObserver<CropPlanResponse> responseObserver = new StreamObserver<CropPlanResponse>() {

            			@Override
            			public void onNext(CropPlanResponse value) {
            				// TODO Auto-generated method stub
							textPane.setText("");
		                    textPane.setText("Message sent by the server: " + value.getCropPlan());
							
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
	
}
