package com.savl.ripple.client.subscriptions;
import com.savl.ripple.core.types.known.tx.result.TransactionResult;

public interface TransactionSubscriptionManager {
    public void notifyTransactionResult(TransactionResult tr);
}
