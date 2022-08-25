import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.zhuoran.grpc.HelloRequest;
import org.zhuoran.grpc.HelloResponse;
import org.zhuoran.grpc.HelloServiceGrpc;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Baeldung")
                .setLastName("gRPC")
                .build());

        channel.shutdown();
    }
}
