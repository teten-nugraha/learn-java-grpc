package id.learn.calculator.server;

import com.proto.calculator.CalculateServiceGrpc;
import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import io.grpc.stub.StreamObserver;

/***
 * Project Name     : learn-java-grpc
 * Username         : Teten Nugraha
 * Date Time        : 2/20/2020
 * email            : Teten.nugraha@allianz.co.id
 * Telegram         : @tennugraha
 */

public class CalculatorServiceImpl extends CalculateServiceGrpc.CalculateServiceImplBase {

    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        SumResponse sumResponse  =SumResponse.newBuilder()
                .setSumResult((request.getFirstNumber()) + (request.getSecondNumber()))
                .build();

        responseObserver.onNext(sumResponse);

        responseObserver.onCompleted();
    }
}
