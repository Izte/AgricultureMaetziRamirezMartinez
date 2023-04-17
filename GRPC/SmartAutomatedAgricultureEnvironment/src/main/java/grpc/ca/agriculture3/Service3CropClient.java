package grpc.ca.agriculture3;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

import grpc.ca.agriculture3.Service3CropServer.Listener;
import grpc.ca.agriculture3.cropServiceGrpc.cropServiceBlockingStub;
import grpc.ca.agriculture3.cropServiceGrpc.cropServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Service3CropClient {

	private static cropServiceBlockingStub blockingstub;
	private static cropServiceStub asyncStub;

	public static void main(String[] args) {
		String host = "localhost";
		int port = 50054;

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		blockingstub = cropServiceGrpc.newBlockingStub(channel);
		asyncStub = cropServiceGrpc.newStub(channel);

		GetCropStatus();
		System.out.println("--------------------------------------------------------------------");

		GetCropPlan();
		System.out.println("--------------------------------------------------------------------");

		try {
	        // Create a JmDNS instance for service discovery
	        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

	        // Add a listener for service events
	        Listener listener = new Listener();
	        jmdns.addServiceListener("_service3._tcp.local.", listener);
	        System.out.println("Discovered _service3._tcp.local.");
	        
	        // Wait for services to be discovered
	        Thread.sleep(5000);

	        // Close the JmDNS instance
	        jmdns.close();
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
		
		
	}

	// Discovery service
	public static class Listener implements ServiceListener {

		@Override
		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added: " + event.getInfo());
		}

		@Override
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed: " + event.getInfo());
		}

		@Override
		public void serviceResolved(ServiceEvent event) {
			System.out.println("Service resolved: " + event.getInfo());
		}
	}

	public static void GetCropStatus() {
		// create the request stream

		StreamObserver<CropStatusResponse> replyCS = new StreamObserver<CropStatusResponse>() {

			@Override
			public void onNext(CropStatusResponse msg) {
				// TODO Auto-generated method stub
				System.out.println("Message send by the server " + msg.getMycropstatus());
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
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void GetCropPlan() {
		// Determine the overall crop status based on the types of crops
	    // For example, if all crops are healthy, return "healthy"
	    // If any crops are unhealthy, return "unhealthy"
	    // If some crops are healthy and some are unhealthy, return "mixed"
		CropPlanRequest requestCPR = CropPlanRequest.newBuilder().setMycroptype("Healthy").setMycroptype("Unhealthy").build();
		StreamObserver<CropPlanResponse> responseObserver = new StreamObserver<CropPlanResponse>() {

			@Override
			public void onNext(CropPlanResponse value) {
				// TODO Auto-generated method stub
				System.out.println("Message send by the server: " + value.getCropPlan());
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

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
