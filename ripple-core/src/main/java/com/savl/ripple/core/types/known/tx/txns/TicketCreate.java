package com.savl.ripple.core.types.known.tx.txns;

import com.savl.ripple.core.serialized.enums.TransactionType;
import com.savl.ripple.core.types.known.tx.Transaction;

public class TicketCreate extends Transaction {
    public TicketCreate() {
        super(TransactionType.TicketCreate);
    }
}
