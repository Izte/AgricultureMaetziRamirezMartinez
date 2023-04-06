package grpc.ca.agriculture2;

import java.io.IOException;

import grpc.ca.agriculture2.irrigationServiceGrpc.irrigationServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service2IrrigationServer extends irrigationServiceImplBase{
	public static void main(String[] args) {
		Service2IrrigationServer irrigationserver = new Service2IrrigationServer();
		int port = 50052;
		
		Server server;
		try {
			server = ServerBuilder.forPort(port).addService(irrigationserver).build().start();
			System.out.println("Server 2 for Irrigation Service is running...");
			server.awaitTermination();
		
		} catch(IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//hola
		}
	}

	@Override
	public void setIrrigation(IrrigationParametersRequest request,
			StreamObserver<IrrigationStatusResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.setIrrigation(request, responseObserver);
		System.out.println("--Receiving Irrigation Parameters from Client--");
		
		IrrigationStatusResponse replay = IrrigationStatusResponse.newBuilder().setMyirrigationstatusResponse("The irrigation parameters is " + request.getMyirrigationparameters()).build();
		
		responseObserver.onNext(replay);
		responseObserver.onCompleted();
	}

	@Override
	public void getIrrigStatus(LocationParametersRequest request,
			StreamObserver<CurrentStatusResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.getIrrigStatus(request, responseObserver);
		
		System.out.println("--Receiving Location Parameters Request from Client--");
		
		CurrentStatusResponse replay = CurrentStatusResponse.newBuilder().setMycurrentstatusResponse("The current status is " + request.getLatitude() + request.getLongitude()).build();
		
		responseObserver.onNext(replay);
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
				//String cancelationString = request.getCancelationString();
				
				CancelationResponse replay = CancelationResponse.newBuilder().setMycancelationresponse(request.getCancelationString()).build();
			
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
	            responseObserver.onCompleted();
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

			}
		};
	}
}
