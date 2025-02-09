package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class FraudDetectorService {

    public static void main(String[] args) throws InterruptedException {
        var fraudeDetectorService = new FraudDetectorService();
        try (var service = new KafkaService(FraudDetectorService.class.getSimpleName(), "ECOMMERCE_NEW_ORDER", fraudeDetectorService::parse, Order.class, Map.of())) {
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, Order> record) throws InterruptedException {
        System.out.println("------------------------------------------");
        System.out.println("Processing new Order, checking for fraud");
        System.out.println(record.key());
        System.out.println(record.value());
        Thread.sleep(5000);
        System.out.println("Order processed");
    }
}
