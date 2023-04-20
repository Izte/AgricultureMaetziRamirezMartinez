package grpc.ca.agriculture3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import org.apache.log4j.PropertyConfigurator;

import grpc.ca.agriculture1.Service1ClimateServer.Listener;
import grpc.ca.agriculture1.Service1ClimateServer.LoggingInterceptor;
import grpc.ca.agriculture3.cropServiceGrpc.cropServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;

public class Service3CropServer extends cropServiceImplBase{
	public static void main(String[] args) {
		Service3CropServer cropserver = new Service3CropServer();
		
		//Registration
		Properties prop = cropserver.getProperties();
		cropserver.registerService(prop);
		
		// Initialize Log4j
        PropertyConfigurator.configure("src/main/resources/Service3.properties");
		
		int port = Integer.valueOf(prop.getProperty("service_port"));//#.50054;
		
		Server server;
		
		try {
	        // Create a JmDNS instance for service discovery
	        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

	        // Add a listener for service events
	        Listener listener = new Listener();
	        jmdns.addServiceListener("_service3._tcp.local.", listener);
	        System.out.println("Discovered _service3._tcp.local. \n");
	        
	        // Wait for services to be discovered
	        Thread.sleep(5000);

	        // Close the JmDNS instance
	        jmdns.close();
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
		
		try {
			server = ServerBuilder.forPort(port).addService(cropserver).build().start();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Server 3 for Crop Service is running... \n");
			server.awaitTermination();
		
		} catch(IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("Error starting gRPC server", e);
			System.exit(1);
	
		}
	}
	
	private Properties getProperties() {
		
		Properties prop = new Properties();
		
		try (InputStream input = new FileInputStream("src/main/resources/Service3.properties")){
			
			//load a properties file
			prop.load(input);
			
			//get the property value and print it out
			System.out.println("Service 3 Crop properties: ");
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " +prop.getProperty("service_port"));
	        System.out.println("--------------------------------------------------------------------");

		} catch(IOException ex) {
			ex.printStackTrace();
			System.exit(1);
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
		
			//Register a service
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);
            
            System.out.printf("\n registrering service with type %s and name %s \n", service_type, service_name);
            System.out.println("--------------------------------------------------------------------");
            
            // Wait a bit
            Thread.sleep(1000);

            // Unregister all services
            //jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
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
	
	private OkHttpClient client;
	
	public class LoggingInterceptor implements Interceptor {
	    
	    private final Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());

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
	public StreamObserver<CropTypeRequest> getCropStatus(StreamObserver<CropStatusResponse> responseObserver) {
		// TODO Auto-generated method stub
		//System.out.println("Receiving Crop Type Request ");
		ArrayList<String> list = new ArrayList<String>();
		return new StreamObserver<CropTypeRequest>() {
			
			
			@Override
		    public void onNext(CropTypeRequest request) {
		      // Add each request to the list
		      list.add(request.getMycroptype());
		    }
			
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method 
				//Log the error
				System.err.println("Error in getCropStatus: " + t.getMessage());
	            // Send an error response to the client
	            responseObserver.onError(t);
			}
			
			@Override
		    public void onCompleted() {
				System.out.println("Receiving Crop Type Request ");
								
				// Process all the requests and send back a single response
				//String cropStatus = determineCropStatus(list);
				String cropStatus = determineCropStatus(list);
				CropStatusResponse replay = CropStatusResponse.newBuilder().setMycropstatus("The crop status is " + cropStatus).build();

		      responseObserver.onNext(replay);
		      responseObserver.onCompleted();
		    }
		};
		
	}
	
	private String determineCropStatus(List<String> cropTypes) {
	    // Determine the overall crop status based on the types of crops
	    // For example, if all crops are healthy, return "healthy"
	    // If any crops are unhealthy, return "unhealthy"
	    // If some crops are healthy and some are unhealthy, return "mixed"
		
		boolean hasHealthyCrops = false;
	    boolean hasUnhealthyCrops = false;

	    for (String cropType : cropTypes) {
	        if (cropType.equalsIgnoreCase("healthy")) {
	            hasHealthyCrops = true;
	        } else if (cropType.equalsIgnoreCase("unhealthy")) {
	            hasUnhealthyCrops = true;
	        }
	    }

	    if (hasHealthyCrops && !hasUnhealthyCrops) {
	        return "healthy";
	    } else if (!hasHealthyCrops && hasUnhealthyCrops) {
	        return "unhealthy";
	    } else {
	        return "mixed";
	    }
		
	}

	@Override
	public void getCropPlan(CropPlanRequest request, StreamObserver<CropPlanResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.getCropPlan(request, responseObserver);
		System.out.println("--Receiving Crop Plan Request from Client--");
		
		for(int i=0; i<5; i++) {
			CropPlanResponse replay = CropPlanResponse.newBuilder().setCropPlan("This is the crop plan: " + request.getMycroptype()).build();
			
			responseObserver.onNext(replay);
		}
		responseObserver.onCompleted();
	}

}
