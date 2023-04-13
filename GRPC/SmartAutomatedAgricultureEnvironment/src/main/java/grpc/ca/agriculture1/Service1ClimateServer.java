package grpc.ca.agriculture1;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.ca.agriculture1.climateServiceGrpc.climateServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service1ClimateServer extends climateServiceImplBase{
	public static void main(String[] args) {
		Service1ClimateServer climateserviceserver = new Service1ClimateServer();
		
		//Registration
		Properties prop = climateserviceserver.getProperties();
		climateserviceserver.registerService(prop);
		
		int port = Integer.valueOf(prop.getProperty("service_port"));//#.50051;
		
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
	
	private Properties getProperties() {
		
		Properties prop = null;
		
		try (InputStream input = new FileInputStream("src/main/resources/Service1.properties")){
			prop = new Properties();
			
			//load a properties file
			prop.load(input);
			
			//get the property value and print it out
			System.out.println("Service 1 Climate properties: ");
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " +prop.getProperty("service_port"));

		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}
	
	private void registerService(Properties prop) {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			String service_type = prop.getProperty("service_type");//"_http._tcp.local.";
			String service_name = prop.getProperty("service_name")  ;// "service1";
			int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;
			
			String service_description_properties = prop.getProperty("service_description");//"path=index.html";
		
			// Registration service information
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
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
		
		// Create a new thread for the service discovery
		/*new Thread(() -> {
		    try {
		        // Create a JmDNS instance
		        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

		        // Wait a bit for the service to register
		        Thread.sleep(1000);

		        // Get the service information
		        ServiceInfo[] infos = jmdns.list(prop.getProperty("service_type"));
		        for (ServiceInfo info : infos) {
		            System.out.printf("Found service: %s %s:%d\n", info.getName(), info.getHostAddresses()[0], info.getPort());
		        }

		    } catch (IOException | InterruptedException e) {
		        e.printStackTrace();
		    }
		}).start();*/
	}

	@Override
	public void getTemperature(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.getTemperature(request, responseObserver);
		System.out.println("--Receiving Temperature Request from Client--");
		
		TemperatureResponse reply = TemperatureResponse.newBuilder().setMytemperatureresponse("The temperature is " + request.getMytemperature()).build();
		
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

	@Override
	public void getHumidity(HumidityRequest request, StreamObserver<HumidityResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.getHumidity(request, responseObserver);
		
		System.out.println("--Receiving Humidity Request from Client--");
		
		HumidityResponse reply = HumidityResponse.newBuilder().setMyhumidityresponse("The humidity is: " + request.getMyhumidity()).build();
		
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
	
	@Override
	public void getRain(RainfallRequest request, StreamObserver<RainfallResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.getRain(request, responseObserver);
		
		System.out.println("--Receiving Rainfall Request from Client--");
		
		RainfallResponse reply = RainfallResponse.newBuilder().setMyrainfalrResponse("The rainfall is: " + request.getMystartdate() + request.getMyenddate()).build();
		
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
		
	}

}

