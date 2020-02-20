package id.learn.calculator.client;

import com.proto.calculator.CalculateServiceGrpc;
import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/***
 * Project Name     : learn-java-grpc
 * Username         : Teten Nugraha
 * Date Time        : 2/20/2020
 * email            : Teten.nugraha@allianz.co.id
 * Telegram         : @tennugraha
 */

public class CalculatorClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5052)
                .usePlaintext()
                .build();

        CalculateServiceGrpc.CalculateServiceBlockingStub stub = CalculateServiceGrpc.newBlockingStub(channel);

        SumRequest request = SumRequest.newBuilder()
                .setFirstNumber(50)
                .setSecondNumber(100)
                .build();

        SumResponse response = stub.sum(request);

        System.out.println("Hasil nya adalah "+response.getSumResult());

        channel.shutdown();

    }

}
