package grpc.ca.agriculture1;
import java.io.IOException;
import grpc.ca.agriculture1.climateServiceGrpc.climateServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service1ClimateServer extends climateServiceImplBase{
	public static void main(String[] args) {
		Service1ClimateServer climateserviceserver = new Service1ClimateServer();
		int port = 50051;
		
		Server server;
		try {
			server = ServerBuilder.forPort(port).addService(climateserviceserver).build().start();
			System.out.println("Server 1 for Climate Service is running...");
			server.awaitTermination();
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getTemperature(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.getTemperature(request, responseObserver);
		System.out.println("--Receiving Temperature Request from Client--");
		
		TemperatureResponse replay = TemperatureResponse.newBuilder().setMytemperatureresponse("The temperature is " + request.getMytemperature()).build();
		
		responseObserver.onNext(replay);
		responseObserver.onCompleted();
	}

	@Override
	public void getHumidity(HumidityRequest request, StreamObserver<HumidityResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.getHumidity(request, responseObserver);
		
		System.out.println("--Receiving Humidity Request from Client--");
		
		HumidityResponse replay = HumidityResponse.newBuilder().setMyhumidityresponse("The humidity is: " + request.getMyhumidity()).build();
		
		responseObserver.onNext(replay);
		responseObserver.onCompleted();
	}
	
	@Override
	public void getRain(RainfallRequest request, StreamObserver<RainfallResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.getRain(request, responseObserver);
		
		System.out.println("--Receiving Rainfall Request from Client--");
		
		RainfallResponse replay = RainfallResponse.newBuilder().setMyrainfalrResponse("The rainfall is: " + request.getMystartdate() + request.getMyenddate()).build();
		
		responseObserver.onNext(replay);
		responseObserver.onCompleted();
		
	}

}