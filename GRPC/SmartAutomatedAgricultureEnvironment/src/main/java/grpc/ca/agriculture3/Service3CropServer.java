package grpc.ca.agriculture3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.ca.agriculture3.cropServiceGrpc.cropServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service3CropServer extends cropServiceImplBase{
	public static void main(String[] args) {
		Service3CropServer cropserver = new Service3CropServer();
		
		//Registration
		Properties prop = cropserver.getProperties();
		cropserver.registerService(prop);
		
		int port = Integer.valueOf(prop.getProperty("service_port"));//#.50054;
		
		Server server;
		try {
			server = ServerBuilder.forPort(port).addService(cropserver).build().start();
			System.out.println("Server 3 for Crop Service is running...");
			server.awaitTermination();
		
		} catch(IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	}
	
	private Properties getProperties() {
		
		Properties prop = null;
		
		try (InputStream input = new FileInputStream("src/main/resources/Service3.properties")){
			prop = new Properties();
			
			//load a properties file
			prop.load(input);
			
			//get the property value and print it out
			System.out.println("Service 3 Crop properties: ");
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
		
			//Register a service
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);
            
            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
            
            // Wait a bit
            Thread.sleep(1000);

            // Unregister all services
            //jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public StreamObserver<CropTypeRequest> getCropStatus(StreamObserver<CropStatusResponse> responseObserver) {
		// TODO Auto-generated method stub
		//return super.getCropStatus(responseObserver);
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
