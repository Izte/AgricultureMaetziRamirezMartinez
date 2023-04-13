package grpc.ca.agriculture2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.ca.agriculture2.irrigationServiceGrpc.irrigationServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service2IrrigationServer extends irrigationServiceImplBase{
	public static void main(String[] args) {
		Service2IrrigationServer irrigationserver = new Service2IrrigationServer();
		
		//Registration
		Properties prop = irrigationserver.getProperties();
		irrigationserver.registerService(prop);
		
		int port = Integer.valueOf(prop.getProperty("service_port"));//#.50052;
		
		Server server;
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
			CurrentStatusResponse replay = CurrentStatusResponse.newBuilder().setMycurrentstatusResponse("The current status is " + request.getLatitude() + request.getLongitude()).build();
		
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
				
				// extract the cancellation string from the request
				//String cancelationString = request.getMycancelationrequest();
				
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
