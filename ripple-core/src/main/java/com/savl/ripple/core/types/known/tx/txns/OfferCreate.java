package com.savl.ripple.core.types.known.tx.txns;

import com.savl.ripple.core.coretypes.Amount;
import com.savl.ripple.core.coretypes.uint.UInt32;
import com.savl.ripple.core.fields.Field;
import com.savl.ripple.core.serialized.enums.TransactionType;
import com.savl.ripple.core.types.known.tx.Transaction;

public class OfferCreate extends Transaction {
    public OfferCreate() {
        super(TransactionType.OfferCreate);
    }
    public UInt32 expiration() {return get(UInt32.Expiration);}
    public UInt32 offerSequence() {return get(UInt32.OfferSequence);}
    public Amount takerPays() {return get(Amount.TakerPays);}
    public Amount takerGets() {return get(Amount.TakerGets);}
    public void expiration(UInt32 val) {put(Field.Expiration, val);}
    public void offerSequence(UInt32 val) {put(Field.OfferSequence, val);}
    public void takerPays(Amount val) {put(Field.TakerPays, val);}
    public void takerGets(Amount val) {put(Field.TakerGets, val);}
}
