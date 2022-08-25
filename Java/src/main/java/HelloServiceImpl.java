import io.grpc.stub.StreamObserver;
import org.zhuoran.grpc.HelloRequest;
import org.zhuoran.grpc.HelloResponse;
import org.zhuoran.grpc.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        System.out.println(greeting);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
