package grpc.ca.agriculture3;

import grpc.ca.agriculture3.cropServiceGrpc.cropServiceBlockingStub;
import grpc.ca.agriculture3.cropServiceGrpc.cropServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.StreamObservers;


public class Service3CropClient {

	private static cropServiceBlockingStub blockingstub;
	private static cropServiceStub asyncStub;
	
	public static void main(String[] args) {
		String host = "localhost";
		int port = 50054;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		blockingstub = cropServiceGrpc.newBlockingStub(channel);
	}
	
	public static void GetCropStatus() {
		//create the request stream
		CropTypeRequest requestCT = CropTypeRequest.newBuilder().setMycroptype("Healty").build();
		
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
		//asyncStub.getCropStatus(requestCT, replyCS);
		
		asyncStub.getCropStatus(replyCS);
		asyncStub.getCropPlan(null, null);
			
		}
	}

