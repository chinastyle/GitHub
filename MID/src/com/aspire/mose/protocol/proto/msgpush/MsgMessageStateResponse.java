// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageStateResponse.proto

package com.aspire.mose.protocol.proto.msgpush;

public final class MsgMessageStateResponse {
  private MsgMessageStateResponse() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface MessageStateResponseOrBuilder
      extends com.google.protobuf.MessageLiteOrBuilder {
    
    // required .protocol.MessageStateResponse.ResponseRetCode retCode = 1;
    boolean hasRetCode();
    com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode getRetCode();
  }
  public static final class MessageStateResponse extends
      com.google.protobuf.GeneratedMessageLite
      implements MessageStateResponseOrBuilder {
    // Use MessageStateResponse.newBuilder() to construct.
    private MessageStateResponse(Builder builder) {
      super(builder);
    }
    private MessageStateResponse(boolean noInit) {}
    
    private static final MessageStateResponse defaultInstance;
    public static MessageStateResponse getDefaultInstance() {
      return defaultInstance;
    }
    
    public MessageStateResponse getDefaultInstanceForType() {
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
      DEVICENOTEXIST(6, 201),
      USERNOTEXIST(7, 203),
      USERTOKENNOTEXIST(8, 205),
      USERTOKENUSERIDUNMATCHED(9, 206),
      TERMINALAPPNOTEXIST(10, 207),
      MESSAGEIDNOTEXIST(11, 307),
      ;
      
      public static final int SUCCESS_VALUE = 0;
      public static final int OTHERFAIL_VALUE = 1;
      public static final int SYSTEMINTERNALlERROR_VALUE = 2;
      public static final int SYSTEMBUSY_VALUE = 3;
      public static final int MESSAGEFORMATERROR_VALUE = 101;
      public static final int MESSAGEFIELDVALUEERROR_VALUE = 102;
      public static final int DEVICENOTEXIST_VALUE = 201;
      public static final int USERNOTEXIST_VALUE = 203;
      public static final int USERTOKENNOTEXIST_VALUE = 205;
      public static final int USERTOKENUSERIDUNMATCHED_VALUE = 206;
      public static final int TERMINALAPPNOTEXIST_VALUE = 207;
      public static final int MESSAGEIDNOTEXIST_VALUE = 307;
      
      
      public final int getNumber() { return value; }
      
      public static ResponseRetCode valueOf(int value) {
        switch (value) {
          case 0: return SUCCESS;
          case 1: return OTHERFAIL;
          case 2: return SYSTEMINTERNALlERROR;
          case 3: return SYSTEMBUSY;
          case 101: return MESSAGEFORMATERROR;
          case 102: return MESSAGEFIELDVALUEERROR;
          case 201: return DEVICENOTEXIST;
          case 203: return USERNOTEXIST;
          case 205: return USERTOKENNOTEXIST;
          case 206: return USERTOKENUSERIDUNMATCHED;
          case 207: return TERMINALAPPNOTEXIST;
          case 307: return MESSAGEIDNOTEXIST;
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
      
      // @@protoc_insertion_point(enum_scope:protocol.MessageStateResponse.ResponseRetCode)
    }
    
    private int bitField0_;
    // required .protocol.MessageStateResponse.ResponseRetCode retCode = 1;
    public static final int RETCODE_FIELD_NUMBER = 1;
    private com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode retCode_;
    public boolean hasRetCode() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode getRetCode() {
      return retCode_;
    }
    
    private void initFields() {
      retCode_ = com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode.SUCCESS;
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
    
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse parseDelimitedFrom(
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
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse, Builder>
        implements com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponseOrBuilder {
      // Construct using com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.newBuilder()
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
        retCode_ = com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode.SUCCESS;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse getDefaultInstanceForType() {
        return com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.getDefaultInstance();
      }
      
      public com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse build() {
        com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse buildPartial() {
        com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse result = new com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.retCode_ = retCode_;
        result.bitField0_ = to_bitField0_;
        return result;
      }
      
      public Builder mergeFrom(com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse other) {
        if (other == com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.getDefaultInstance()) return this;
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
              com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode value = com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode.valueOf(rawValue);
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
      
      // required .protocol.MessageStateResponse.ResponseRetCode retCode = 1;
      private com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode retCode_ = com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode.SUCCESS;
      public boolean hasRetCode() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode getRetCode() {
        return retCode_;
      }
      public Builder setRetCode(com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        retCode_ = value;
        
        return this;
      }
      public Builder clearRetCode() {
        bitField0_ = (bitField0_ & ~0x00000001);
        retCode_ = com.aspire.mose.protocol.proto.msgpush.MsgMessageStateResponse.MessageStateResponse.ResponseRetCode.SUCCESS;
        
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:protocol.MessageStateResponse)
    }
    
    static {
      defaultInstance = new MessageStateResponse(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:protocol.MessageStateResponse)
  }
  
  
  static {
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}
