package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EmailService {

    public static void main(String[] args) throws InterruptedException {
        var emailService = new EmailService();

        try (var service = new KafkaService(EmailService.class.getSimpleName(), "ECOMMERCE_SEND_EMAIL", emailService::parse)) {
            service.run();
        }
    }

    private void parse (ConsumerRecord<String, String> record) throws InterruptedException {
        System.out.println("------------------------------------------");
        System.out.println("Send Email");
        System.out.println(record.key());
        System.out.println(record.value());
        Thread.sleep(1000);
        System.out.println("Email Sent");
    }
}
