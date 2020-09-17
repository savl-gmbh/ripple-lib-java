package com.savl.ripple.core.types.shamap;

import com.savl.ripple.core.types.known.sle.LedgerEntry;

public interface LedgerEntryVisitor {
    public void onEntry(LedgerEntry entry);
}
