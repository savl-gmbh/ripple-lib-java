package com.savl.ripple.core.types.shamap;
import com.savl.ripple.core.types.known.tx.result.TransactionResult;

public interface TransactionResultVisitor {
    public void onTransaction(TransactionResult tx);
}
