package org.jsp;

import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class ServiceImpl extends GreeterGrpc.GreeterImplBase {

  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    String name = request.getName();
    String message = "Hello " + name;
    responseObserver.onNext(HelloReply.newBuilder().setMessage(message).build());
    responseObserver.onCompleted();
  }
}
