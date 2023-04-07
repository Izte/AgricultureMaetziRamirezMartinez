package grpc.ca.agriculture3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import grpc.ca.agriculture3.cropServiceGrpc.cropServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service3CropServer extends cropServiceImplBase{
	public static void main(String[] args) {
		Service3CropServer cropserver = new Service3CropServer();
		int port = 50054;
		
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
