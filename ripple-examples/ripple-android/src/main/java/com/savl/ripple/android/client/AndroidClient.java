package com.savl.ripple.android.client;

import com.savl.ripple.android.logging.AndroidHandler;
import com.savl.ripple.client.Client;
import com.savl.ripple.client.transport.impl.JavaWebSocketTransportImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AndroidClient extends Client {
    static {
        Logger logger = Client.logger;
        AndroidHandler handler = new AndroidHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
    }
    public AndroidClient() {
        super(new JavaWebSocketTransportImpl());
    }
}
