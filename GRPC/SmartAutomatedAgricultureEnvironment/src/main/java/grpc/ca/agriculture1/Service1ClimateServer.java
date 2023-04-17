package grpc.ca.agriculture1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
import java.net.InetAddress;
//import java.net.URLConnection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
//import javax.print.DocFlavor.URL;

import grpc.ca.agriculture1.climateServiceGrpc.climateServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.log4j.PropertyConfigurator;


public class Service1ClimateServer extends climateServiceImplBase {
	public static void main(String[] args) {
		Service1ClimateServer climateserviceserver = new Service1ClimateServer();

		// Registration
		Properties prop = climateserviceserver.getProperties();
		climateserviceserver.registerService(prop);
		
		// Initialize Log4j
        PropertyConfigurator.configure("src/main/resources/Service1.properties");

		int port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

		Server server;
		/*
		// create an instance of the outer class and use it to make requests
        Service1ClimateServer server1 = new Service1ClimateServer();
        // use the client to make requests
        Request request = new Request.Builder()
            .url("https://www.example.com")
            .build();
        try {
            Response response = server1.client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
		*/
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
		
		try {
			server = ServerBuilder.forPort(port).addService(climateserviceserver).build().start();
			System.out.println("Server 1 for Climate Service is running...");
			server.awaitTermination();

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Properties getProperties() {

		Properties prop = null;

		try (InputStream input = new FileInputStream("src/main/resources/Service1.properties")) {
			prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println("Service 1 Climate properties: ");
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
			System.out.println("\t service_name: " + prop.getProperty("service_name"));
			System.out.println("\t service_description: " + prop.getProperty("service_description"));
			System.out.println("\t service_port: " + prop.getProperty("service_port"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

	private void registerService(Properties prop) {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			String service_type = prop.getProperty("service_type");// "_service1._tcp.local.";
			String service_name = prop.getProperty("service_name");// "service1";
			int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

			String service_description_properties = prop.getProperty("service_description");// "path=index.html";

			// Registration service information
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
					service_description_properties);
			jmdns.registerService(serviceInfo);

			System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

			// Wait a bit for the service to register
			Thread.sleep(1000);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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
	
	//private OkHttpClient client;
	
	public static class LoggingInterceptor implements Interceptor {
	    /*
		// create the OkHttpClient with the logging
		LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
		*/
	    private static final Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());

	    @Override public Response intercept(Chain chain) throws IOException {
	        Request request = chain.request();

	        long t1 = System.nanoTime();
	        logger.log(Level.INFO, String.format("Sending request %s on %s%n%s",
	              request.url(), chain.connection(), request.headers()));

	        Response response = chain.proceed(request);

	        long t2 = System.nanoTime();
	        logger.log(Level.INFO, String.format("Received response for %s in %.1fms%n%s",
	              response.request().url(), (t2 - t1) / 1e6d, response.headers()));

	        return response;
	    }
	}

	@Override
	public void getTemperature(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {
		// TODO Auto-generated method stub
		System.out.println("--Receiving Temperature Request from Client--");
		try {
			TemperatureResponse reply = TemperatureResponse.newBuilder()
					.setMytemperatureresponse("The temperature is " + request.getMytemperature()).build();
	
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		} catch (Exception e) {
			//handle the exception and return an error response
			responseObserver.onError(Status.INTERNAL.withDescription("Internal server error").asRuntimeException());
		}
	}

	@Override
	public void getHumidity(HumidityRequest request, StreamObserver<HumidityResponse> responseObserver) {
		// TODO Auto-generated method stub

		System.out.println("--Receiving Humidity Request from Client--");
		try {
			HumidityResponse reply = HumidityResponse.newBuilder()
					.setMyhumidityresponse("The humidity is: " + request.getMyhumidity()).build();
	
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		} catch (Exception e) {
			//handle the exception and return an error response
			responseObserver.onError(Status.INTERNAL.withDescription("Internal server error").asRuntimeException());
		}
	}

	@Override
	public void getRain(RainfallRequest request, StreamObserver<RainfallResponse> responseObserver) {
		// TODO Auto-generated method stub

		System.out.println("--Receiving Rainfall Request from Client--");
		try {
			RainfallResponse reply = RainfallResponse.newBuilder()
					.setMyrainfalrResponse("The rainfall: " + request.getMystartdate() + request.getMyenddate()).build();
	
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		} catch (Exception e) {
			//handle the exception and return an error response
			responseObserver.onError(Status.INTERNAL.withDescription("Internal server error").asRuntimeException());
		}

	}

}
