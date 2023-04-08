package grpc.ca.agriculture1;

import java.util.concurrent.TimeUnit;

import grpc.ca.agriculture1.climateServiceGrpc.climateServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Service1ClimateClient {
	public static void main(String[] args) {
		String host = "localhost";
		int port = 50051;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		climateServiceBlockingStub blockingstub = climateServiceGrpc.newBlockingStub(channel);
		
		try {
			//method getTemperature
			TemperatureRequest request = TemperatureRequest.newBuilder().setMytemperature("The temperatur is 14 degrees ").build();
			
			TemperatureResponse reply = blockingstub.getTemperature(request);
		
			System.out.println("Message send by the server " + reply.getMytemperatureresponse());
			
			//method getHumidity
			HumidityRequest requestHR = HumidityRequest.newBuilder().setMyhumidity("The humidity is 60% ").build();
			
			HumidityResponse replyHR = blockingstub.getHumidity(requestHR);
		
			System.out.println("Message send by the server " + replyHR.getMyhumidityresponse());
			
			//method GetRain
			RainfallRequest requestRR = RainfallRequest.newBuilder().setMystartdate("The start date is 12th April 2023 ").setMyenddate("The end date is 14th April 2023 ").build();
			
			RainfallResponse replyRR = blockingstub.getRain(requestRR);
		
			System.out.println("Message send by the server " + replyRR.getMyrainfalrResponse());
		}catch(StatusRuntimeException e) {
			e.getStatus();
		} finally {
			try {
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
