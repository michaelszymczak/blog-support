package com.michaelszymczak.sample.tddrefalgo;

import com.michaelszymczak.sample.tddrefalgo.encoding.PayloadSchema;
import com.michaelszymczak.sample.tddrefalgo.encoding.ProtocolDecoder;
import com.michaelszymczak.sample.tddrefalgo.encoding.ProtocolEncoder;

class RegisteredApp<D extends ProtocolDecoder<D, L>, E extends ProtocolEncoder<E, M>, L, M> {
    private final PayloadSchema protocolSchemaId;
    private final D protocolDecoder;
    private final E protocolEncoder;
    private final L decodedMessageListener;

    RegisteredApp(
            PayloadSchema payloadSchema,
            D protocolDecoder,
            E protocolEncoder,
            L decodedMessageListener) {
        this.protocolSchemaId = payloadSchema;
        this.protocolDecoder = protocolDecoder;
        this.protocolEncoder = protocolEncoder;
        this.decodedMessageListener = decodedMessageListener;
    }

    int getProtocolSchemaId() {
        return protocolSchemaId.id();
    }

    D getProtocolDecoder() {
        return protocolDecoder;
    }

    E getProtocolEncoder() {
        return protocolEncoder;
    }

    L getDecodedMessageListener() {
        return decodedMessageListener;
    }
}
