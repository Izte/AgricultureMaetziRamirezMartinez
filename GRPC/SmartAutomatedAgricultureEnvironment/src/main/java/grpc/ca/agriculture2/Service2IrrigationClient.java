package grpc.ca.agriculture2;

import grpc.ca.agriculture2.irrigationServiceGrpc.irrigationServiceBlockingStub;
import grpc.ca.agriculture2.irrigationServiceGrpc.irrigationServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class Service2IrrigationClient {
	private static irrigationServiceBlockingStub blockingstub;
	private static irrigationServiceStub asyncStub;
	public static void main(String[] args) {
		String host = "localhost";
		int port = 50052;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		blockingstub = irrigationServiceGrpc.newBlockingStub(channel);
		
	}
	
	public static void SetIrrigation() {
		// Method SetIrrigation
		IrrigationParametersRequest requestIP = IrrigationParametersRequest.newBuilder().setMyirrigationparameters("The irrigation parameter are between 10 to 15 ").build();
		
		IrrigationStatusResponse replyIS = blockingstub.setIrrigation(requestIP);
		
		System.out.println("Message send by the server " + replyIS.getMyirrigationstatusResponse());
	}
	
	public static void GetIrrigStatus() {
		// Method GetIrrigStatus
		LocationParametersRequest requestLP = LocationParametersRequest.newBuilder().setLatitude(51).setLongitude(31).build();
		
		//Iterator<CurrentStatusResponse> replyCS = blockingstub.getIrrigStatus(requestLP);
		
		StreamObserver<CurrentStatusResponse> replyCS = new StreamObserver<CurrentStatusResponse>() {

			@Override
			public void onNext(CurrentStatusResponse value) {
				// TODO Auto-generated method stub
				System.out.println("Message send by the server " + value.getMycurrentstatusResponse());

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("Current Status");
			}
			
		};
		
		asyncStub.getIrrigStatus(requestLP, replyCS);
		
		try {
			Thread.sleep(15000);
		} catch(InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void CancelIrrigation() throws InterruptedException {
		// Method CancelIrrigation
		StreamObserver<CancelationResponse> responseObserver = new StreamObserver<CancelationResponse>() {

			@Override
			public void onNext(CancelationResponse msg) {
				// TODO Auto-generated method stub
				System.out.println("Receiving cancelation response " + msg.getMycancelationresponse());
				
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
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(15000);
		} catch(InterruptedException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
