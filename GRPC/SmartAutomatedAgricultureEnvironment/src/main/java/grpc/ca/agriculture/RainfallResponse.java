// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Service1.proto

package grpc.ca.agriculture;

/**
 * Protobuf type {@code smartAgriculture.RainfallResponse}
 */
public  final class RainfallResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:smartAgriculture.RainfallResponse)
    RainfallResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RainfallResponse.newBuilder() to construct.
  private RainfallResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RainfallResponse() {
    myRainfallResponse_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RainfallResponse(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            myRainfallResponse_ = s;
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
    return grpc.ca.agriculture.ClimateService.internal_static_smartAgriculture_RainfallResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.ca.agriculture.ClimateService.internal_static_smartAgriculture_RainfallResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.ca.agriculture.RainfallResponse.class, grpc.ca.agriculture.RainfallResponse.Builder.class);
  }

  public static final int MYRAINFALLRESPONSE_FIELD_NUMBER = 1;
  private volatile java.lang.Object myRainfallResponse_;
  /**
   * <code>string myRainfallResponse = 1;</code>
   */
  public java.lang.String getMyRainfallResponse() {
    java.lang.Object ref = myRainfallResponse_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      myRainfallResponse_ = s;
      return s;
    }
  }
  /**
   * <code>string myRainfallResponse = 1;</code>
   */
  public com.google.protobuf.ByteString
      getMyRainfallResponseBytes() {
    java.lang.Object ref = myRainfallResponse_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      myRainfallResponse_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getMyRainfallResponseBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, myRainfallResponse_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getMyRainfallResponseBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, myRainfallResponse_);
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
    if (!(obj instanceof grpc.ca.agriculture.RainfallResponse)) {
      return super.equals(obj);
    }
    grpc.ca.agriculture.RainfallResponse other = (grpc.ca.agriculture.RainfallResponse) obj;

    boolean result = true;
    result = result && getMyRainfallResponse()
        .equals(other.getMyRainfallResponse());
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
    hash = (37 * hash) + MYRAINFALLRESPONSE_FIELD_NUMBER;
    hash = (53 * hash) + getMyRainfallResponse().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.ca.agriculture.RainfallResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.ca.agriculture.RainfallResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.ca.agriculture.RainfallResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.ca.agriculture.RainfallResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.ca.agriculture.RainfallResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.ca.agriculture.RainfallResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.ca.agriculture.RainfallResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.ca.agriculture.RainfallResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.ca.agriculture.RainfallResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.ca.agriculture.RainfallResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.ca.agriculture.RainfallResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.ca.agriculture.RainfallResponse parseFrom(
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
  public static Builder newBuilder(grpc.ca.agriculture.RainfallResponse prototype) {
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
   * Protobuf type {@code smartAgriculture.RainfallResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:smartAgriculture.RainfallResponse)
      grpc.ca.agriculture.RainfallResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.ca.agriculture.ClimateService.internal_static_smartAgriculture_RainfallResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.ca.agriculture.ClimateService.internal_static_smartAgriculture_RainfallResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.ca.agriculture.RainfallResponse.class, grpc.ca.agriculture.RainfallResponse.Builder.class);
    }

    // Construct using grpc.ca.agriculture.RainfallResponse.newBuilder()
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
      myRainfallResponse_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.ca.agriculture.ClimateService.internal_static_smartAgriculture_RainfallResponse_descriptor;
    }

    @java.lang.Override
    public grpc.ca.agriculture.RainfallResponse getDefaultInstanceForType() {
      return grpc.ca.agriculture.RainfallResponse.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.ca.agriculture.RainfallResponse build() {
      grpc.ca.agriculture.RainfallResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.ca.agriculture.RainfallResponse buildPartial() {
      grpc.ca.agriculture.RainfallResponse result = new grpc.ca.agriculture.RainfallResponse(this);
      result.myRainfallResponse_ = myRainfallResponse_;
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
      if (other instanceof grpc.ca.agriculture.RainfallResponse) {
        return mergeFrom((grpc.ca.agriculture.RainfallResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.ca.agriculture.RainfallResponse other) {
      if (other == grpc.ca.agriculture.RainfallResponse.getDefaultInstance()) return this;
      if (!other.getMyRainfallResponse().isEmpty()) {
        myRainfallResponse_ = other.myRainfallResponse_;
        onChanged();
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
      grpc.ca.agriculture.RainfallResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.ca.agriculture.RainfallResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object myRainfallResponse_ = "";
    /**
     * <code>string myRainfallResponse = 1;</code>
     */
    public java.lang.String getMyRainfallResponse() {
      java.lang.Object ref = myRainfallResponse_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        myRainfallResponse_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string myRainfallResponse = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMyRainfallResponseBytes() {
      java.lang.Object ref = myRainfallResponse_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        myRainfallResponse_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string myRainfallResponse = 1;</code>
     */
    public Builder setMyRainfallResponse(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      myRainfallResponse_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string myRainfallResponse = 1;</code>
     */
    public Builder clearMyRainfallResponse() {
      
      myRainfallResponse_ = getDefaultInstance().getMyRainfallResponse();
      onChanged();
      return this;
    }
    /**
     * <code>string myRainfallResponse = 1;</code>
     */
    public Builder setMyRainfallResponseBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      myRainfallResponse_ = value;
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


    // @@protoc_insertion_point(builder_scope:smartAgriculture.RainfallResponse)
  }

  // @@protoc_insertion_point(class_scope:smartAgriculture.RainfallResponse)
  private static final grpc.ca.agriculture.RainfallResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.ca.agriculture.RainfallResponse();
  }

  public static grpc.ca.agriculture.RainfallResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RainfallResponse>
      PARSER = new com.google.protobuf.AbstractParser<RainfallResponse>() {
    @java.lang.Override
    public RainfallResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RainfallResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RainfallResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RainfallResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.ca.agriculture.RainfallResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

