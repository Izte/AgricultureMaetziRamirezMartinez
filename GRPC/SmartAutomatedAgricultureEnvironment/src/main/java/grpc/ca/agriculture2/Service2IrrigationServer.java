package grpc.ca.agriculture2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
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
import grpc.ca.agriculture2.irrigationServiceGrpc.irrigationServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Interceptor.Chain;

public class Service2IrrigationServer extends irrigationServiceImplBase{
	public static void main(String[] args) {
		Service2IrrigationServer irrigationserver = new Service2IrrigationServer();
		
		//Registration
		Properties prop = irrigationserver.getProperties();
		irrigationserver.registerService(prop);
		
		// Initialize Log4j
        PropertyConfigurator.configure("src/main/resources/Service1.properties");
		
		int port = Integer.valueOf(prop.getProperty("service_port"));//#.50052;
		
		Server server;
		
		try {
	        // Create a JmDNS instance for service discovery
	        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

	        // Add a listener for service events
	        Listener listener = new Listener();
	        jmdns.addServiceListener("_service1_tcp.local.", listener);
	        System.out.println("Discovered _service2_tcp.local.");
	        
	        // Wait for services to be discovered
	        Thread.sleep(5000);

	        // Close the JmDNS instance
	        jmdns.close();
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
		
		try {
			server = ServerBuilder.forPort(port).addService(irrigationserver).build().start();
			System.out.println("Server 2 for Irrigation Service is running...");
			server.awaitTermination();
		
		} catch(IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	}
	
	private Properties getProperties() {
		
		Properties prop = null;
		
		try (InputStream input = new FileInputStream("src/main/resources/Service2.properties")){
			prop = new Properties();
			
			//load a properties file
			prop.load(input);
			
			//get the property value and print it out
			System.out.println("Service 2 Irrigation properties: ");
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
			String service_name = prop.getProperty("service_name")  ;// "service2";
			int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50052;
			
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
	
	public class LoggingInterceptor implements Interceptor {
	    /*
		// create the OkHttpClient with the logging
		LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
	    client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
		*/
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
	public void setIrrigation(IrrigationParametersRequest request,
			StreamObserver<IrrigationStatusResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.setIrrigation(request, responseObserver);
		System.out.println("--Receiving Irrigation Parameters from Client--");
		
		IrrigationStatusResponse replay = IrrigationStatusResponse.newBuilder().setMyirrigationstatusResponse("The irrigation parameters are " + request.getMyirrigationparameters()).build();
		
		responseObserver.onNext(replay);
		responseObserver.onCompleted();
	}

	@Override
	public void getIrrigStatus(LocationParametersRequest request,
			StreamObserver<CurrentStatusResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.getIrrigStatus(request, responseObserver);
		
		System.out.println("--Receiving Location Parameters Request from Client--");
		
		for(int i=0; i < 5; i++) {
			CurrentStatusResponse replay = CurrentStatusResponse.newBuilder().setMycurrentstatusResponse("Current Latitude and Lonitude " + request.getLatitude() + request.getLongitude()).build();
		
			responseObserver.onNext(replay);
		}
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<CancelationRequest> cancelIrrigation(StreamObserver<CancelationResponse> responseObserver) {
		// TODO Auto-generated method stub
		//return super.cancelIrrigation(responseObserver);
		return new StreamObserver<CancelationRequest>() {
			@Override
			public void onNext(CancelationRequest request) {
				System.out.println("Receiving Cancelation Request: ");
								
				CancelationResponse replay = CancelationResponse.newBuilder().setMycancelationresponse(request.getMycancelationrequest()).build();
			
				// cancel the irrigation process using the cancellation string
	            // and handle any errors that may occur
	            /*try {
	                cancelIrrigationProcess(cancelationString);
	            } catch (IrrigationProcessNotFoundException e) {
	                // log the error and send an error response back to the client
	                System.err.println("Error: " + e.getMessage());
	                responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asException());
	                return;
	            } catch (IrrigationProcessAlreadyCancelledException e) {
	                // log the error and send an error response back to the client
	                System.err.println("Error: " + e.getMessage());
	                responseObserver.onError(Status.FAILED_PRECONDITION.withDescription(e.getMessage()).asException());
	                return;
	            } catch (Exception e) {
	                // log the error and send an error response back to the client
	                System.err.println("Error: " + e.getMessage());
	                responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asException());
	                return;
	            }*/

	            // send an empty response back to the client to confirm cancellation
	            //responseObserver.onNext(CancelationResponse.getDefaultInstance());
	            responseObserver.onNext(replay);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
	            System.err.println("Error: " + t.getMessage());
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
	            System.out.println("Client has completed the request.");
	            responseObserver.onCompleted();
			}
		};
	}
	/*
	private void cancelIrrigationProcess(String cancellationString) throws IrrigationProcessNotFoundException, IrrigationProcessAlreadyCancelledException {
	    // search for the irrigation process using the cancellation string
	    IrrigationProcess process = findIrrigationProcessByCancellationString(cancellationString);

	    // if the process was not found, throw an exception
	    if (process == null) {
	        throw new IrrigationProcessNotFoundException("Irrigation process not found for cancellation string: " + cancellationString);
	    }

	    // if the process was already cancelled, throw an exception
	    if (process.isCancelled()) {
	        throw new IrrigationProcessAlreadyCancelledException("Irrigation process already cancelled for cancellation string: " + cancellationString);
	    }

	    // cancel the process
	    process.cancel();
	}*/
}
