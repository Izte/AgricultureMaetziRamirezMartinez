package grpc.ca.agriculture3;

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
		
		GetCropPlan();
		
	}
	
	public static void GetCropStatus() {
		//create the request stream
		
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
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
			
	}
	
	public static void GetCropPlan() {
		
		CropPlanRequest requestCPR = CropPlanRequest.newBuilder().setMycroptype("Healthy").build();
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
		} catch(InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

