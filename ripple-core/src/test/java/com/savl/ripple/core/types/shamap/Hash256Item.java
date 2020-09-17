package com.savl.ripple.core.types.shamap;

import com.savl.ripple.core.coretypes.hash.Hash256;
import com.savl.ripple.core.coretypes.hash.prefixes.Prefix;
import com.savl.ripple.core.serialized.BytesSink;

public class Hash256Item extends ShaMapItem<Hash256> {
    Hash256 item;

    public Hash256Item(Hash256 item) {
        this.item = item;
    }

    @Override
    void toBytesSink(BytesSink sink) {
        item.toBytesSink(sink);
    }

    @Override
    public ShaMapItem<Hash256> copy() {
        return new Hash256Item(item);
    }

    @Override
    public Hash256 value() {
        return item;
    }

    @Override
    public Prefix hashPrefix() {
        return new Prefix() {
            @Override
            public byte[] bytes() {
                return new byte[]{};
            }
        };
    }
}
