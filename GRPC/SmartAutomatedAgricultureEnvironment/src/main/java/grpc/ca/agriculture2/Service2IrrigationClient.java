package grpc.ca.agriculture2;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

import grpc.ca.agriculture1.Service1ClimateClient.Listener;
import grpc.ca.agriculture1.Service1ClimateServer.LoggingInterceptor;
import grpc.ca.agriculture2.irrigationServiceGrpc.irrigationServiceBlockingStub;
import grpc.ca.agriculture2.irrigationServiceGrpc.irrigationServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import okhttp3.OkHttpClient;

public class Service2IrrigationClient {
	private static irrigationServiceBlockingStub blockingstub;
	private static irrigationServiceStub asyncStub;

	public static void main(String[] args) throws InterruptedException {
		String host = "localhost";
		int port = 50052;

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();

		blockingstub = irrigationServiceGrpc.newBlockingStub(channel);
		asyncStub = irrigationServiceGrpc.newStub(channel);

		SetIrrigation();
		System.out.println("--------------------------------------------------------------------");

		GetIrrigStatus();
		System.out.println("--------------------------------------------------------------------");

		CancelIrrigation();
		System.out.println("--------------------------------------------------------------------");

		try {
			// Create a JmDNS instance for service discovery
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Add a listener for service events
			Listener listener = new Listener();
			jmdns.addServiceListener("_service2._tcp.local.", listener);
			System.out.println("Discovery _service2._tcp.local. \n");

			// Wait for services to be discovered
			Thread.sleep(5000);

			// Close the JmDNS instance
			jmdns.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
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

	public static void SetIrrigation() {
		// Method SetIrrigation
		IrrigationParametersRequest requestIP = IrrigationParametersRequest.newBuilder()
				.setMyirrigationparameters(" between 10 to 15 ").build();

		IrrigationStatusResponse replyIS = blockingstub.setIrrigation(requestIP);

		System.out.println("Message send by the server: \n" + replyIS.getMyirrigationstatusResponse());
	}

	public static void GetIrrigStatus() {
		// Method GetIrrigStatus
		LocationParametersRequest requestLP = LocationParametersRequest.newBuilder().setLatitude(51).setLongitude(31)
				.build();

		// Iterator<CurrentStatusResponse> replyCS =
		// blockingstub.getIrrigStatus(requestLP);

		StreamObserver<CurrentStatusResponse> replyCS = new StreamObserver<CurrentStatusResponse>() {

			@Override
			public void onNext(CurrentStatusResponse value) {
				// TODO Auto-generated method stub
				System.out.println("Message send by the server \n" + value.getMycurrentstatusResponse());

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
		} catch (InterruptedException e) {
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

			requestObserver
					.onNext(CancelationRequest.newBuilder().setMycancelationrequest("Cancel irrigation ").build());
			requestObserver.onCompleted();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
