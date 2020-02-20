package id.learn.client;

import com.proto.dummy.DummyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {


    public static void main(String[] args) {
        System.out.println("Hello GRPC Client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50581)
                .usePlaintext()
                .build();

        System.out.println("Creating Stub");

        DummyServiceGrpc.DummyServiceBlockingStub syncClient = DummyServiceGrpc.newBlockingStub(channel);

        System.out.println("Shudown channel client");
        channel.shutdown();
    }
}
