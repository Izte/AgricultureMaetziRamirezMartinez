package grpc.ca.agriculture1;

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
    comments = "Source: Service1.proto")
public final class climateServiceGrpc {

  private climateServiceGrpc() {}

  public static final String SERVICE_NAME = "smartAgriculture.climateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.ca.agriculture1.TemperatureRequest,
      grpc.ca.agriculture1.TemperatureResponse> getGetTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTemperature",
      requestType = grpc.ca.agriculture1.TemperatureRequest.class,
      responseType = grpc.ca.agriculture1.TemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.ca.agriculture1.TemperatureRequest,
      grpc.ca.agriculture1.TemperatureResponse> getGetTemperatureMethod() {
    io.grpc.MethodDescriptor<grpc.ca.agriculture1.TemperatureRequest, grpc.ca.agriculture1.TemperatureResponse> getGetTemperatureMethod;
    if ((getGetTemperatureMethod = climateServiceGrpc.getGetTemperatureMethod) == null) {
      synchronized (climateServiceGrpc.class) {
        if ((getGetTemperatureMethod = climateServiceGrpc.getGetTemperatureMethod) == null) {
          climateServiceGrpc.getGetTemperatureMethod = getGetTemperatureMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.agriculture1.TemperatureRequest, grpc.ca.agriculture1.TemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartAgriculture.climateService", "GetTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture1.TemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture1.TemperatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new climateServiceMethodDescriptorSupplier("GetTemperature"))
                  .build();
          }
        }
     }
     return getGetTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.ca.agriculture1.HumidityRequest,
      grpc.ca.agriculture1.HumidityResponse> getGetHumidityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHumidity",
      requestType = grpc.ca.agriculture1.HumidityRequest.class,
      responseType = grpc.ca.agriculture1.HumidityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.ca.agriculture1.HumidityRequest,
      grpc.ca.agriculture1.HumidityResponse> getGetHumidityMethod() {
    io.grpc.MethodDescriptor<grpc.ca.agriculture1.HumidityRequest, grpc.ca.agriculture1.HumidityResponse> getGetHumidityMethod;
    if ((getGetHumidityMethod = climateServiceGrpc.getGetHumidityMethod) == null) {
      synchronized (climateServiceGrpc.class) {
        if ((getGetHumidityMethod = climateServiceGrpc.getGetHumidityMethod) == null) {
          climateServiceGrpc.getGetHumidityMethod = getGetHumidityMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.agriculture1.HumidityRequest, grpc.ca.agriculture1.HumidityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartAgriculture.climateService", "GetHumidity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture1.HumidityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture1.HumidityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new climateServiceMethodDescriptorSupplier("GetHumidity"))
                  .build();
          }
        }
     }
     return getGetHumidityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.ca.agriculture1.RainfallRequest,
      grpc.ca.agriculture1.RainfallResponse> getGetRainMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRain",
      requestType = grpc.ca.agriculture1.RainfallRequest.class,
      responseType = grpc.ca.agriculture1.RainfallResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.ca.agriculture1.RainfallRequest,
      grpc.ca.agriculture1.RainfallResponse> getGetRainMethod() {
    io.grpc.MethodDescriptor<grpc.ca.agriculture1.RainfallRequest, grpc.ca.agriculture1.RainfallResponse> getGetRainMethod;
    if ((getGetRainMethod = climateServiceGrpc.getGetRainMethod) == null) {
      synchronized (climateServiceGrpc.class) {
        if ((getGetRainMethod = climateServiceGrpc.getGetRainMethod) == null) {
          climateServiceGrpc.getGetRainMethod = getGetRainMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.agriculture1.RainfallRequest, grpc.ca.agriculture1.RainfallResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartAgriculture.climateService", "GetRain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture1.RainfallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.agriculture1.RainfallResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new climateServiceMethodDescriptorSupplier("GetRain"))
                  .build();
          }
        }
     }
     return getGetRainMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static climateServiceStub newStub(io.grpc.Channel channel) {
    return new climateServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static climateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new climateServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static climateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new climateServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static abstract class climateServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTemperature(grpc.ca.agriculture1.TemperatureRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture1.TemperatureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTemperatureMethod(), responseObserver);
    }

    /**
     */
    public void getHumidity(grpc.ca.agriculture1.HumidityRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture1.HumidityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetHumidityMethod(), responseObserver);
    }

    /**
     */
    public void getRain(grpc.ca.agriculture1.RainfallRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture1.RainfallResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRainMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTemperatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ca.agriculture1.TemperatureRequest,
                grpc.ca.agriculture1.TemperatureResponse>(
                  this, METHODID_GET_TEMPERATURE)))
          .addMethod(
            getGetHumidityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ca.agriculture1.HumidityRequest,
                grpc.ca.agriculture1.HumidityResponse>(
                  this, METHODID_GET_HUMIDITY)))
          .addMethod(
            getGetRainMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ca.agriculture1.RainfallRequest,
                grpc.ca.agriculture1.RainfallResponse>(
                  this, METHODID_GET_RAIN)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class climateServiceStub extends io.grpc.stub.AbstractStub<climateServiceStub> {
    private climateServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private climateServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected climateServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new climateServiceStub(channel, callOptions);
    }

    /**
     */
    public void getTemperature(grpc.ca.agriculture1.TemperatureRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture1.TemperatureResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHumidity(grpc.ca.agriculture1.HumidityRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture1.HumidityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetHumidityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRain(grpc.ca.agriculture1.RainfallRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.agriculture1.RainfallResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRainMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class climateServiceBlockingStub extends io.grpc.stub.AbstractStub<climateServiceBlockingStub> {
    private climateServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private climateServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected climateServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new climateServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.ca.agriculture1.TemperatureResponse getTemperature(grpc.ca.agriculture1.TemperatureRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTemperatureMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.ca.agriculture1.HumidityResponse getHumidity(grpc.ca.agriculture1.HumidityRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetHumidityMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.ca.agriculture1.RainfallResponse getRain(grpc.ca.agriculture1.RainfallRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRainMethod(), getCallOptions(), request);
    }

	public HumidityResponse getMyhumidityresponse(HumidityRequest requestHR) {
		// TODO Auto-generated method stub
		return null;
	}

	public HumidityResponse getMyhumidty(HumidityRequest requestHR) {
		// TODO Auto-generated method stub
		return null;
	}
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class climateServiceFutureStub extends io.grpc.stub.AbstractStub<climateServiceFutureStub> {
    private climateServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private climateServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected climateServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new climateServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ca.agriculture1.TemperatureResponse> getTemperature(
        grpc.ca.agriculture1.TemperatureRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTemperatureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ca.agriculture1.HumidityResponse> getHumidity(
        grpc.ca.agriculture1.HumidityRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetHumidityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ca.agriculture1.RainfallResponse> getRain(
        grpc.ca.agriculture1.RainfallRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRainMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TEMPERATURE = 0;
  private static final int METHODID_GET_HUMIDITY = 1;
  private static final int METHODID_GET_RAIN = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final climateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(climateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TEMPERATURE:
          serviceImpl.getTemperature((grpc.ca.agriculture1.TemperatureRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.agriculture1.TemperatureResponse>) responseObserver);
          break;
        case METHODID_GET_HUMIDITY:
          serviceImpl.getHumidity((grpc.ca.agriculture1.HumidityRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.agriculture1.HumidityResponse>) responseObserver);
          break;
        case METHODID_GET_RAIN:
          serviceImpl.getRain((grpc.ca.agriculture1.RainfallRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.agriculture1.RainfallResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class climateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    climateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.ca.agriculture1.ClimateService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("climateService");
    }
  }

  private static final class climateServiceFileDescriptorSupplier
      extends climateServiceBaseDescriptorSupplier {
    climateServiceFileDescriptorSupplier() {}
  }

  private static final class climateServiceMethodDescriptorSupplier
      extends climateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    climateServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (climateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new climateServiceFileDescriptorSupplier())
              .addMethod(getGetTemperatureMethod())
              .addMethod(getGetHumidityMethod())
              .addMethod(getGetRainMethod())
              .build();
        }
      }
    }
    return result;
  }
}
