package grpc.ca.agriculture3;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service Definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Service3.proto")
public final class cropServiceGrpc {

  private cropServiceGrpc() {}

  public static final String SERVICE_NAME = "smartAgriculture.cropService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.ca.agriculture3.CropTypeRequest,
      grpc.ca.agriculture3.CropStatusResponse> getGetCropStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCropStatus",
      requestType = grpc.ca.agriculture3.CropTypeRequest.class,
      responseType = grpc.ca.agriculture3.CropStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.ca.agriculture3.CropTypeRequest,
      grpc.ca.agriculture3.CropStatusResponse> getGetCropStatusMethod() {
    io.grpc.MethodDescriptor<grpc.ca.agriculture3.CropTypeRequest, grpc.ca.agriculture3.CropStatusResponse> getGetCropStatusMethod;
    if ((getGetCropStatusMethod = cropServiceGrpc.getGetCropStatusMethod) == null) {
      synchronized (cropServiceGrpc.class) {
        if ((getGetCropStatusMethod = cropServiceGrpc.getGetCropStatusMethod) == null) {
          cropServiceGrpc.getGetCropStatusMethod = getGetCropStatusMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.agriculture3.CropTypeRequest, grpc.ca.agriculture3.CropStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartAgriculture.cropService", "GetCropStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture3.CropTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture3.CropStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new cropServiceMethodDescriptorSupplier("GetCropStatus"))
                  .build();
          }
        }
     }
     return getGetCropStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.ca.agriculture3.CropPlanRequest,
      grpc.ca.agriculture3.CropPlanResponse> getGetCropPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCropPlan",
      requestType = grpc.ca.agriculture3.CropPlanRequest.class,
      responseType = grpc.ca.agriculture3.CropPlanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.ca.agriculture3.CropPlanRequest,
      grpc.ca.agriculture3.CropPlanResponse> getGetCropPlanMethod() {
    io.grpc.MethodDescriptor<grpc.ca.agriculture3.CropPlanRequest, grpc.ca.agriculture3.CropPlanResponse> getGetCropPlanMethod;
    if ((getGetCropPlanMethod = cropServiceGrpc.getGetCropPlanMethod) == null) {
      synchronized (cropServiceGrpc.class) {
        if ((getGetCropPlanMethod = cropServiceGrpc.getGetCropPlanMethod) == null) {
          cropServiceGrpc.getGetCropPlanMethod = getGetCropPlanMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.agriculture3.CropPlanRequest, grpc.ca.agriculture3.CropPlanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartAgriculture.cropService", "GetCropPlan"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture3.CropPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture3.CropPlanResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new cropServiceMethodDescriptorSupplier("GetCropPlan"))
                  .build();
          }
        }
     }
     return getGetCropPlanMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static cropServiceStub newStub(io.grpc.Channel channel) {
    return new cropServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static cropServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new cropServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static cropServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new cropServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static abstract class cropServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.ca.agriculture3.CropTypeRequest> getCropStatus(
        io.grpc.stub.StreamObserver<grpc.ca.agriculture3.CropStatusResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetCropStatusMethod(), responseObserver);
    }

    /**
     */
    public void getCropPlan(grpc.ca.agriculture3.CropPlanRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture3.CropPlanResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCropPlanMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCropStatusMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.ca.agriculture3.CropTypeRequest,
                grpc.ca.agriculture3.CropStatusResponse>(
                  this, METHODID_GET_CROP_STATUS)))
          .addMethod(
            getGetCropPlanMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.ca.agriculture3.CropPlanRequest,
                grpc.ca.agriculture3.CropPlanResponse>(
                  this, METHODID_GET_CROP_PLAN)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class cropServiceStub extends io.grpc.stub.AbstractStub<cropServiceStub> {
    private cropServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private cropServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cropServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new cropServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.ca.agriculture3.CropTypeRequest> getCropStatus(
        io.grpc.stub.StreamObserver<grpc.ca.agriculture3.CropStatusResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetCropStatusMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getCropPlan(grpc.ca.agriculture3.CropPlanRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture3.CropPlanResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetCropPlanMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class cropServiceBlockingStub extends io.grpc.stub.AbstractStub<cropServiceBlockingStub> {
    private cropServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private cropServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cropServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new cropServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<grpc.ca.agriculture3.CropPlanResponse> getCropPlan(
        grpc.ca.agriculture3.CropPlanRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetCropPlanMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class cropServiceFutureStub extends io.grpc.stub.AbstractStub<cropServiceFutureStub> {
    private cropServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private cropServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cropServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new cropServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_CROP_PLAN = 0;
  private static final int METHODID_GET_CROP_STATUS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final cropServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(cropServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CROP_PLAN:
          serviceImpl.getCropPlan((grpc.ca.agriculture3.CropPlanRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.agriculture3.CropPlanResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CROP_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getCropStatus(
              (io.grpc.stub.StreamObserver<grpc.ca.agriculture3.CropStatusResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class cropServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    cropServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.ca.agriculture3.CropService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("cropService");
    }
  }

  private static final class cropServiceFileDescriptorSupplier
      extends cropServiceBaseDescriptorSupplier {
    cropServiceFileDescriptorSupplier() {}
  }

  private static final class cropServiceMethodDescriptorSupplier
      extends cropServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    cropServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (cropServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new cropServiceFileDescriptorSupplier())
              .addMethod(getGetCropStatusMethod())
              .addMethod(getGetCropPlanMethod())
              .build();
        }
      }
    }
    return result;
  }
}
