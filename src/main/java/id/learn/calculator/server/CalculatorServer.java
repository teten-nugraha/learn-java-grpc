package id.learn.calculator.server;

import id.learn.server.GreetServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/***
 * Project Name     : learn-java-grpc
 * Username         : Teten Nugraha
 * Date Time        : 2/20/2020
 * email            : Teten.nugraha@allianz.co.id
 * Telegram         : @tennugraha
 */

public class CalculatorServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello GRPC Server");

        final Server server = ServerBuilder.forPort(5052)
                .addService(new CalculatorServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Successfully shutdown server");
        }));

        server.awaitTermination();
    }
}
