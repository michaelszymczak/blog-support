package com.michaelszymczak.sample.tddrefalgo.encoding.pricingprotocol;

import com.michaelszymczak.sample.tddrefalgo.Setup;
import com.michaelszymczak.sample.tddrefalgo.domain.messages.pricingprotocol.MessageWithPricingProtocol;
import com.michaelszymczak.sample.tddrefalgo.domain.messages.pricingprotocol.PricingMessage;
import com.michaelszymczak.sample.tddrefalgo.domain.messages.pricingprotocol.PricingProtocolPublisher;
import com.michaelszymczak.sample.tddrefalgo.encoding.AppPublisher;
import com.michaelszymczak.sample.tddrefalgo.encoding.lengthbased.LengthBasedMessageEncoding;

public class EncodingPricingProtocolPublisher implements PricingProtocolPublisher {

    private final MessageWithPricingProtocol messageWithPricingProtocol = new MessageWithPricingProtocol();
    private final LengthBasedMessageEncoding.Encoder encoder = Setup.encoder();
    private final AppPublisher appPublisher;

    public EncodingPricingProtocolPublisher(AppPublisher appPublisher) {

        this.appPublisher = appPublisher;
    }


    @Override
    public void publish(PricingMessage message) {
        appPublisher.setWrittenPosition(encoder.wrap(appPublisher.buffer(), appPublisher.writtenPosition())
                .encode(messageWithPricingProtocol.withPayload(message)));
    }
}
