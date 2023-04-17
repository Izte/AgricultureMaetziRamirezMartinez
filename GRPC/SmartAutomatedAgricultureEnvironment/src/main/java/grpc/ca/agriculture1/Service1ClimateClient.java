package grpc.ca.agriculture1;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

import grpc.ca.agriculture1.Service1ClimateServer.Listener;
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
			// method getTemperature
			TemperatureRequest request = TemperatureRequest.newBuilder()
					.setMytemperature("The temperatur is 14 degrees ").build();

			TemperatureResponse reply = blockingstub.getTemperature(request);

			// String temperature = reply.getMytemperatureresponse();

			System.out.println("Message send by the server " + reply.getMytemperatureresponse());
			System.out.println("--------------------------------------------------------------------");

			// method getHumidity
			HumidityRequest requestHR = HumidityRequest.newBuilder().setMyhumidity("The humidity is 60% ").build();

			HumidityResponse replyHR = blockingstub.getHumidity(requestHR);

			// String humidity = replyHR.getMyhumidityresponse();
			System.out.println("Message send by the server " + replyHR.getMyhumidityresponse());
			System.out.println("--------------------------------------------------------------------");

			// method GetRain
			RainfallRequest requestRR = RainfallRequest.newBuilder()
					.setMystartdate("The start date is 12th April 2023 ")
					.setMyenddate("The end date is 14th April 2023 ").build();

			RainfallResponse replyRR = blockingstub.getRain(requestRR);

			// String rainfall = replyRR.getMyrainfalrResponse();
			System.out.println("Message send by the server " + replyRR.getMyrainfalrResponse());
			System.out.println("--------------------------------------------------------------------");

			try {
		        // Create a JmDNS instance for service discovery
		        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

		        // Add a listener for service events
		        Listener listener = new Listener();
		        jmdns.addServiceListener("_service1._tcp.local.", listener);
		        System.out.println("Discovery _service1._tcp.local.");
		        
		        // Wait for services to be discovered
		        Thread.sleep(5000);

		        // Close the JmDNS instance
		        jmdns.close();
		    } catch (IOException | InterruptedException e) {
		        e.printStackTrace();
		    }
			
		} catch (StatusRuntimeException e) {
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

}
