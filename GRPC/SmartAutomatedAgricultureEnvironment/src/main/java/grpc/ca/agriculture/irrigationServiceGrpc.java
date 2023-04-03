package grpc.ca.agriculture;

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
    comments = "Source: Service2.proto")
public final class irrigationServiceGrpc {

  private irrigationServiceGrpc() {}

  public static final String SERVICE_NAME = "smartAgriculture.irrigationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.ca.agriculture.IrrigationParametersRequest,
      grpc.ca.agriculture.IrrigationStatusResponse> getSetIrrigationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIrrigation",
      requestType = grpc.ca.agriculture.IrrigationParametersRequest.class,
      responseType = grpc.ca.agriculture.IrrigationStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.ca.agriculture.IrrigationParametersRequest,
      grpc.ca.agriculture.IrrigationStatusResponse> getSetIrrigationMethod() {
    io.grpc.MethodDescriptor<grpc.ca.agriculture.IrrigationParametersRequest, grpc.ca.agriculture.IrrigationStatusResponse> getSetIrrigationMethod;
    if ((getSetIrrigationMethod = irrigationServiceGrpc.getSetIrrigationMethod) == null) {
      synchronized (irrigationServiceGrpc.class) {
        if ((getSetIrrigationMethod = irrigationServiceGrpc.getSetIrrigationMethod) == null) {
          irrigationServiceGrpc.getSetIrrigationMethod = getSetIrrigationMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.agriculture.IrrigationParametersRequest, grpc.ca.agriculture.IrrigationStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartAgriculture.irrigationService", "SetIrrigation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture.IrrigationParametersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture.IrrigationStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new irrigationServiceMethodDescriptorSupplier("SetIrrigation"))
                  .build();
          }
        }
     }
     return getSetIrrigationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.ca.agriculture.LocationParametersRequest,
      grpc.ca.agriculture.CurrentStatusResponse> getGetIrrigStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIrrigStatus",
      requestType = grpc.ca.agriculture.LocationParametersRequest.class,
      responseType = grpc.ca.agriculture.CurrentStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.ca.agriculture.LocationParametersRequest,
      grpc.ca.agriculture.CurrentStatusResponse> getGetIrrigStatusMethod() {
    io.grpc.MethodDescriptor<grpc.ca.agriculture.LocationParametersRequest, grpc.ca.agriculture.CurrentStatusResponse> getGetIrrigStatusMethod;
    if ((getGetIrrigStatusMethod = irrigationServiceGrpc.getGetIrrigStatusMethod) == null) {
      synchronized (irrigationServiceGrpc.class) {
        if ((getGetIrrigStatusMethod = irrigationServiceGrpc.getGetIrrigStatusMethod) == null) {
          irrigationServiceGrpc.getGetIrrigStatusMethod = getGetIrrigStatusMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.agriculture.LocationParametersRequest, grpc.ca.agriculture.CurrentStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartAgriculture.irrigationService", "GetIrrigStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture.LocationParametersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture.CurrentStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new irrigationServiceMethodDescriptorSupplier("GetIrrigStatus"))
                  .build();
          }
        }
     }
     return getGetIrrigStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.ca.agriculture.CancelationRequest,
      grpc.ca.agriculture.CancelationResponse> getCancelIrrigationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelIrrigation",
      requestType = grpc.ca.agriculture.CancelationRequest.class,
      responseType = grpc.ca.agriculture.CancelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.ca.agriculture.CancelationRequest,
      grpc.ca.agriculture.CancelationResponse> getCancelIrrigationMethod() {
    io.grpc.MethodDescriptor<grpc.ca.agriculture.CancelationRequest, grpc.ca.agriculture.CancelationResponse> getCancelIrrigationMethod;
    if ((getCancelIrrigationMethod = irrigationServiceGrpc.getCancelIrrigationMethod) == null) {
      synchronized (irrigationServiceGrpc.class) {
        if ((getCancelIrrigationMethod = irrigationServiceGrpc.getCancelIrrigationMethod) == null) {
          irrigationServiceGrpc.getCancelIrrigationMethod = getCancelIrrigationMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.agriculture.CancelationRequest, grpc.ca.agriculture.CancelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartAgriculture.irrigationService", "CancelIrrigation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture.CancelationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture.CancelationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new irrigationServiceMethodDescriptorSupplier("CancelIrrigation"))
                  .build();
          }
        }
     }
     return getCancelIrrigationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static irrigationServiceStub newStub(io.grpc.Channel channel) {
    return new irrigationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static irrigationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new irrigationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static irrigationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new irrigationServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static abstract class irrigationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void setIrrigation(grpc.ca.agriculture.IrrigationParametersRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture.IrrigationStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetIrrigationMethod(), responseObserver);
    }

    /**
     */
    public void getIrrigStatus(grpc.ca.agriculture.LocationParametersRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture.CurrentStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIrrigStatusMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.ca.agriculture.CancelationRequest> cancelIrrigation(
        io.grpc.stub.StreamObserver<grpc.ca.agriculture.CancelationResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCancelIrrigationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetIrrigationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ca.agriculture.IrrigationParametersRequest,
                grpc.ca.agriculture.IrrigationStatusResponse>(
                  this, METHODID_SET_IRRIGATION)))
          .addMethod(
            getGetIrrigStatusMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.ca.agriculture.LocationParametersRequest,
                grpc.ca.agriculture.CurrentStatusResponse>(
                  this, METHODID_GET_IRRIG_STATUS)))
          .addMethod(
            getCancelIrrigationMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.ca.agriculture.CancelationRequest,
                grpc.ca.agriculture.CancelationResponse>(
                  this, METHODID_CANCEL_IRRIGATION)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class irrigationServiceStub extends io.grpc.stub.AbstractStub<irrigationServiceStub> {
    private irrigationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private irrigationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected irrigationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new irrigationServiceStub(channel, callOptions);
    }

    /**
     */
    public void setIrrigation(grpc.ca.agriculture.IrrigationParametersRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture.IrrigationStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetIrrigationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getIrrigStatus(grpc.ca.agriculture.LocationParametersRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture.CurrentStatusResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetIrrigStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.ca.agriculture.CancelationRequest> cancelIrrigation(
        io.grpc.stub.StreamObserver<grpc.ca.agriculture.CancelationResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCancelIrrigationMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class irrigationServiceBlockingStub extends io.grpc.stub.AbstractStub<irrigationServiceBlockingStub> {
    private irrigationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private irrigationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected irrigationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new irrigationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.ca.agriculture.IrrigationStatusResponse setIrrigation(grpc.ca.agriculture.IrrigationParametersRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetIrrigationMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.ca.agriculture.CurrentStatusResponse> getIrrigStatus(
        grpc.ca.agriculture.LocationParametersRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetIrrigStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class irrigationServiceFutureStub extends io.grpc.stub.AbstractStub<irrigationServiceFutureStub> {
    private irrigationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private irrigationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected irrigationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new irrigationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ca.agriculture.IrrigationStatusResponse> setIrrigation(
        grpc.ca.agriculture.IrrigationParametersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIrrigationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_IRRIGATION = 0;
  private static final int METHODID_GET_IRRIG_STATUS = 1;
  private static final int METHODID_CANCEL_IRRIGATION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final irrigationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(irrigationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_IRRIGATION:
          serviceImpl.setIrrigation((grpc.ca.agriculture.IrrigationParametersRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.agriculture.IrrigationStatusResponse>) responseObserver);
          break;
        case METHODID_GET_IRRIG_STATUS:
          serviceImpl.getIrrigStatus((grpc.ca.agriculture.LocationParametersRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.agriculture.CurrentStatusResponse>) responseObserver);
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
        case METHODID_CANCEL_IRRIGATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.cancelIrrigation(
              (io.grpc.stub.StreamObserver<grpc.ca.agriculture.CancelationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class irrigationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    irrigationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.ca.agriculture.IrrigationService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("irrigationService");
    }
  }

  private static final class irrigationServiceFileDescriptorSupplier
      extends irrigationServiceBaseDescriptorSupplier {
    irrigationServiceFileDescriptorSupplier() {}
  }

  private static final class irrigationServiceMethodDescriptorSupplier
      extends irrigationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    irrigationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (irrigationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new irrigationServiceFileDescriptorSupplier())
              .addMethod(getSetIrrigationMethod())
              .addMethod(getGetIrrigStatusMethod())
              .addMethod(getCancelIrrigationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
