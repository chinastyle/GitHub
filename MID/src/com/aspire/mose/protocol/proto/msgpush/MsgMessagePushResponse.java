// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessagePushResponse.proto

package com.aspire.mose.protocol.proto.msgpush;

public final class MsgMessagePushResponse {
  private MsgMessagePushResponse() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface MessagePushResponseOrBuilder
      extends com.google.protobuf.MessageLiteOrBuilder {
    
    // required .protocol.MessagePushResponse.ResponseRetCode retCode = 1;
    boolean hasRetCode();
    com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode getRetCode();
  }
  public static final class MessagePushResponse extends
      com.google.protobuf.GeneratedMessageLite
      implements MessagePushResponseOrBuilder {
    // Use MessagePushResponse.newBuilder() to construct.
    private MessagePushResponse(Builder builder) {
      super(builder);
    }
    private MessagePushResponse(boolean noInit) {}
    
    private static final MessagePushResponse defaultInstance;
    public static MessagePushResponse getDefaultInstance() {
      return defaultInstance;
    }
    
    public MessagePushResponse getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public enum ResponseRetCode
        implements com.google.protobuf.Internal.EnumLite {
      SUCCESS(0, 0),
      OTHERFAIL(1, 1),
      SYSTEMINTERNALlERROR(2, 2),
      SYSTEMBUSY(3, 3),
      MESSAGEFORMATERROR(4, 101),
      MESSAGEFIELDVALUEERROR(5, 102),
      MESSAGEIDDUPLICATE(6, 308),
      DEVICEIDUNMATCHED(7, 401),
      USERIDUNMATCHED(8, 402),
      USERTOKENUNMATCHED(9, 403),
      APPNOTREGISTERED(10, 404),
      ;
      
      public static final int SUCCESS_VALUE = 0;
      public static final int OTHERFAIL_VALUE = 1;
      public static final int SYSTEMINTERNALlERROR_VALUE = 2;
      public static final int SYSTEMBUSY_VALUE = 3;
      public static final int MESSAGEFORMATERROR_VALUE = 101;
      public static final int MESSAGEFIELDVALUEERROR_VALUE = 102;
      public static final int MESSAGEIDDUPLICATE_VALUE = 308;
      public static final int DEVICEIDUNMATCHED_VALUE = 401;
      public static final int USERIDUNMATCHED_VALUE = 402;
      public static final int USERTOKENUNMATCHED_VALUE = 403;
      public static final int APPNOTREGISTERED_VALUE = 404;
      
      
      public final int getNumber() { return value; }
      
      public static ResponseRetCode valueOf(int value) {
        switch (value) {
          case 0: return SUCCESS;
          case 1: return OTHERFAIL;
          case 2: return SYSTEMINTERNALlERROR;
          case 3: return SYSTEMBUSY;
          case 101: return MESSAGEFORMATERROR;
          case 102: return MESSAGEFIELDVALUEERROR;
          case 308: return MESSAGEIDDUPLICATE;
          case 401: return DEVICEIDUNMATCHED;
          case 402: return USERIDUNMATCHED;
          case 403: return USERTOKENUNMATCHED;
          case 404: return APPNOTREGISTERED;
          default: return null;
        }
      }
      
      public static com.google.protobuf.Internal.EnumLiteMap<ResponseRetCode>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static com.google.protobuf.Internal.EnumLiteMap<ResponseRetCode>
          internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<ResponseRetCode>() {
              public ResponseRetCode findValueByNumber(int number) {
                return ResponseRetCode.valueOf(number);
              }
            };
      
      private final int value;
      
      private ResponseRetCode(int index, int value) {
        this.value = value;
      }
      
      // @@protoc_insertion_point(enum_scope:protocol.MessagePushResponse.ResponseRetCode)
    }
    
    private int bitField0_;
    // required .protocol.MessagePushResponse.ResponseRetCode retCode = 1;
    public static final int RETCODE_FIELD_NUMBER = 1;
    private com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode retCode_;
    public boolean hasRetCode() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode getRetCode() {
      return retCode_;
    }
    
    private void initFields() {
      retCode_ = com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode.SUCCESS;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      if (!hasRetCode()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, retCode_.getNumber());
      }
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, retCode_.getNumber());
      }
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse, Builder>
        implements com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponseOrBuilder {
      // Construct using com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private void maybeForceBuilderInitialization() {
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        retCode_ = com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode.SUCCESS;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse getDefaultInstanceForType() {
        return com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.getDefaultInstance();
      }
      
      public com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse build() {
        com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse buildPartial() {
        com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse result = new com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.retCode_ = retCode_;
        result.bitField0_ = to_bitField0_;
        return result;
      }
      
      public Builder mergeFrom(com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse other) {
        if (other == com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.getDefaultInstance()) return this;
        if (other.hasRetCode()) {
          setRetCode(other.getRetCode());
        }
        return this;
      }
      
      public final boolean isInitialized() {
        if (!hasRetCode()) {
          
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              
              return this;
            default: {
              if (!parseUnknownField(input, extensionRegistry, tag)) {
                
                return this;
              }
              break;
            }
            case 8: {
              int rawValue = input.readEnum();
              com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode value = com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode.valueOf(rawValue);
              if (value != null) {
                bitField0_ |= 0x00000001;
                retCode_ = value;
              }
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // required .protocol.MessagePushResponse.ResponseRetCode retCode = 1;
      private com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode retCode_ = com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode.SUCCESS;
      public boolean hasRetCode() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode getRetCode() {
        return retCode_;
      }
      public Builder setRetCode(com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        retCode_ = value;
        
        return this;
      }
      public Builder clearRetCode() {
        bitField0_ = (bitField0_ & ~0x00000001);
        retCode_ = com.aspire.mose.protocol.proto.msgpush.MsgMessagePushResponse.MessagePushResponse.ResponseRetCode.SUCCESS;
        
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:protocol.MessagePushResponse)
    }
    
    static {
      defaultInstance = new MessagePushResponse(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:protocol.MessagePushResponse)
  }
  
  
  static {
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}