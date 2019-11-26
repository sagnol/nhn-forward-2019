package com.nhn.forward2019.reactivekafka.service;

import com.nhn.forward2019.reactivekafka.core.HundredGenerator;
import com.nhn.forward2019.reactivekafka.core.KafkaManager;
import reactor.core.publisher.BaseSubscriber;
import reactor.kafka.receiver.ReceiverRecord;

public abstract class SubscriberDemoService extends DemoService implements HundredGenerator {

    public SubscriberDemoService(String serviceName, KafkaManager kafkaManager) {
        super(serviceName, kafkaManager);
    }

    protected abstract BaseSubscriber<ReceiverRecord<String, String>> getSubscriber();

    @Override
    protected void consume() {
        BaseSubscriber<ReceiverRecord<String, String>> subscriber = getSubscriber();

        kafkaManager.consumer(serviceName)
                .subscribe(subscriber);

        disposable = subscriber;
    }
}
