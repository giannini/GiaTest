package com.giannini.kafka;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * Author: Fenglin
 * Date: 2017/7/12
 */
public class TestProducer {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.16.10.123:9092");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(props);

        boolean sync = false;
        String topic="page_visits";
        String key = "mykey";
        String value = "myvalue";
        ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>(topic, key, value);
        if (sync) {
            producer.send(producerRecord).get();
        } else {
            producer.send(producerRecord);
        }
        producer.close();
        System.out.println("send done.");
    }

}

