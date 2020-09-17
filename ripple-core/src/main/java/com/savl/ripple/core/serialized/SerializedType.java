package com.savl.ripple.core.serialized;

import com.savl.ripple.core.fields.Type;

public interface SerializedType {
    Object toJSON();
    byte[] toBytes();
    String toHex();
    void toBytesSink(BytesSink to);
    Type type();
}
