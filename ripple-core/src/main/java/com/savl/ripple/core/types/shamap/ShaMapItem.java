package com.savl.ripple.core.types.shamap;

import com.savl.ripple.core.coretypes.hash.prefixes.Prefix;
import com.savl.ripple.core.serialized.BytesSink;

abstract public class ShaMapItem<T> {
    abstract void toBytesSink(BytesSink sink);
    public abstract ShaMapItem<T> copy();
    public abstract T value();
    public abstract Prefix hashPrefix();
}
