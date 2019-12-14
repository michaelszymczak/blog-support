package com.michaelszymczak.sample.tddrefalgo.encoding;

import com.michaelszymczak.sample.tddrefalgo.domain.messages.PayloadSchema;
import org.agrona.MutableDirectBuffer;

public interface ProtocolEncoder<E extends ProtocolEncoder<E, M>, M> {

    E wrap(MutableDirectBuffer buffer, int offset);

    int encode(M message);

    PayloadSchema payloadSchema();

    Class<M> messageType();
}
