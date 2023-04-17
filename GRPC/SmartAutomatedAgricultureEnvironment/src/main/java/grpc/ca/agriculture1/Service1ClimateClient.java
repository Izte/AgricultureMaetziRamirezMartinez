package grpc.ca.agriculture1;

import java.util.concurrent.TimeUnit;

import grpc.ca.agriculture1.Service1ClimateServer.LoggingInterceptor;
import grpc.ca.agriculture1.climateServiceGrpc.climateServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import okhttp3.OkHttpClient;


public class Service1ClimateClient {
	public static void main(String[] args) {
		String host = "localhost";
		int port = 50051;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		climateServiceBlockingStub blockingstub = climateServiceGrpc.newBlockingStub(channel);
		
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();
		
		try {
			//method getTemperature
			TemperatureRequest request = TemperatureRequest.newBuilder().setMytemperature("The temperatur is 14 degrees ").build();
			
			TemperatureResponse reply = blockingstub.getTemperature(request);
			
			//String temperature = reply.getMytemperatureresponse();
			
			System.out.println("Message send by the server " + reply.getMytemperatureresponse());
			System.out.println("--------------------------------------------------------------------");
			
			//method getHumidity
			HumidityRequest requestHR = HumidityRequest.newBuilder().setMyhumidity("The humidity is 60% ").build();
			
			HumidityResponse replyHR = blockingstub.getHumidity(requestHR);
		
			//String humidity = replyHR.getMyhumidityresponse();
			System.out.println("Message send by the server " + replyHR.getMyhumidityresponse());
			System.out.println("--------------------------------------------------------------------");
			
			//method GetRain
			RainfallRequest requestRR = RainfallRequest.newBuilder().setMystartdate("The start date is 12th April 2023 ").setMyenddate("The end date is 14th April 2023 ").build();
			
			RainfallResponse replyRR = blockingstub.getRain(requestRR);
			
			//String rainfall = replyRR.getMyrainfalrResponse();
			System.out.println("Message send by the server " + replyRR.getMyrainfalrResponse());
			System.out.println("--------------------------------------------------------------------");
			
			/*
			// make HTTP request using JAX-RS client
			String url = "https://example.com/climate-data";
			Client client = Client.create();
			WebResource webResource = client.resource(url);
						
			ClientResponse response = webResource
									.queryParam("temperature", temperature)
									.queryParam("humidity", humidity)
									.queryParam("rainfall", rainfall)
									.get(ClientResponse.class);
									
			// handle response
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
				
			String output = response.getEntity(String.class);
				
			System.out.println("Output from Server .... \n");
			System.out.println(output);
			*/
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
