// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Service2.proto

package grpc.ca.agriculture;

/**
 * <pre>
 * Define the messages for GetIrrigStatus method
 * </pre>
 *
 * Protobuf type {@code smartAgriculture.LocationParametersRequest}
 */
public  final class LocationParametersRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:smartAgriculture.LocationParametersRequest)
    LocationParametersRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LocationParametersRequest.newBuilder() to construct.
  private LocationParametersRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LocationParametersRequest() {
    latitude_ = 0F;
    longitude_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LocationParametersRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 13: {

            latitude_ = input.readFloat();
            break;
          }
          case 21: {

            longitude_ = input.readFloat();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.ca.agriculture.IrrigationService.internal_static_smartAgriculture_LocationParametersRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.ca.agriculture.IrrigationService.internal_static_smartAgriculture_LocationParametersRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.ca.agriculture.LocationParametersRequest.class, grpc.ca.agriculture.LocationParametersRequest.Builder.class);
  }

  public static final int LATITUDE_FIELD_NUMBER = 1;
  private float latitude_;
  /**
   * <code>float latitude = 1;</code>
   */
  public float getLatitude() {
    return latitude_;
  }

  public static final int LONGITUDE_FIELD_NUMBER = 2;
  private float longitude_;
  /**
   * <code>float longitude = 2;</code>
   */
  public float getLongitude() {
    return longitude_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (latitude_ != 0F) {
      output.writeFloat(1, latitude_);
    }
    if (longitude_ != 0F) {
      output.writeFloat(2, longitude_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (latitude_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, latitude_);
    }
    if (longitude_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, longitude_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.ca.agriculture.LocationParametersRequest)) {
      return super.equals(obj);
    }
    grpc.ca.agriculture.LocationParametersRequest other = (grpc.ca.agriculture.LocationParametersRequest) obj;

    boolean result = true;
    result = result && (
        java.lang.Float.floatToIntBits(getLatitude())
        == java.lang.Float.floatToIntBits(
            other.getLatitude()));
    result = result && (
        java.lang.Float.floatToIntBits(getLongitude())
        == java.lang.Float.floatToIntBits(
            other.getLongitude()));
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + LATITUDE_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getLatitude());
    hash = (37 * hash) + LONGITUDE_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getLongitude());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.ca.agriculture.LocationParametersRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.ca.agriculture.LocationParametersRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.ca.agriculture.LocationParametersRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Define the messages for GetIrrigStatus method
   * </pre>
   *
   * Protobuf type {@code smartAgriculture.LocationParametersRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:smartAgriculture.LocationParametersRequest)
      grpc.ca.agriculture.LocationParametersRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.ca.agriculture.IrrigationService.internal_static_smartAgriculture_LocationParametersRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.ca.agriculture.IrrigationService.internal_static_smartAgriculture_LocationParametersRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.ca.agriculture.LocationParametersRequest.class, grpc.ca.agriculture.LocationParametersRequest.Builder.class);
    }

    // Construct using grpc.ca.agriculture.LocationParametersRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      latitude_ = 0F;

      longitude_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.ca.agriculture.IrrigationService.internal_static_smartAgriculture_LocationParametersRequest_descriptor;
    }

    @java.lang.Override
    public grpc.ca.agriculture.LocationParametersRequest getDefaultInstanceForType() {
      return grpc.ca.agriculture.LocationParametersRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.ca.agriculture.LocationParametersRequest build() {
      grpc.ca.agriculture.LocationParametersRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.ca.agriculture.LocationParametersRequest buildPartial() {
      grpc.ca.agriculture.LocationParametersRequest result = new grpc.ca.agriculture.LocationParametersRequest(this);
      result.latitude_ = latitude_;
      result.longitude_ = longitude_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.ca.agriculture.LocationParametersRequest) {
        return mergeFrom((grpc.ca.agriculture.LocationParametersRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.ca.agriculture.LocationParametersRequest other) {
      if (other == grpc.ca.agriculture.LocationParametersRequest.getDefaultInstance()) return this;
      if (other.getLatitude() != 0F) {
        setLatitude(other.getLatitude());
      }
      if (other.getLongitude() != 0F) {
        setLongitude(other.getLongitude());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.ca.agriculture.LocationParametersRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.ca.agriculture.LocationParametersRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private float latitude_ ;
    /**
     * <code>float latitude = 1;</code>
     */
    public float getLatitude() {
      return latitude_;
    }
    /**
     * <code>float latitude = 1;</code>
     */
    public Builder setLatitude(float value) {
      
      latitude_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float latitude = 1;</code>
     */
    public Builder clearLatitude() {
      
      latitude_ = 0F;
      onChanged();
      return this;
    }

    private float longitude_ ;
    /**
     * <code>float longitude = 2;</code>
     */
    public float getLongitude() {
      return longitude_;
    }
    /**
     * <code>float longitude = 2;</code>
     */
    public Builder setLongitude(float value) {
      
      longitude_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float longitude = 2;</code>
     */
    public Builder clearLongitude() {
      
      longitude_ = 0F;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:smartAgriculture.LocationParametersRequest)
  }

  // @@protoc_insertion_point(class_scope:smartAgriculture.LocationParametersRequest)
  private static final grpc.ca.agriculture.LocationParametersRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.ca.agriculture.LocationParametersRequest();
  }

  public static grpc.ca.agriculture.LocationParametersRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LocationParametersRequest>
      PARSER = new com.google.protobuf.AbstractParser<LocationParametersRequest>() {
    @java.lang.Override
    public LocationParametersRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LocationParametersRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LocationParametersRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LocationParametersRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.ca.agriculture.LocationParametersRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

