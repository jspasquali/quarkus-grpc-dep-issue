# quarkus-grpc-dep-issue project

Reproducing issue mentionned in https://github.com/quarkusio/quarkus/issues/15057

```
mvn clean install
java -jar grpc-service/target/grpc-service-1.0.0-SNAPSHOT-runner.jar
```

Output:
```
2021-02-17 11:41:22,561 INFO  [io.quarkus] (main) grpc-service 1.0.0-SNAPSHOT on JVM (powered by Quarkus 1.11.3.Final) started in 3.166s. Listening on: http://0.0.0.0:8080
2021-02-17 11:41:22,567 INFO  [io.quarkus] (main) Profile prod activated.
2021-02-17 11:41:22,568 INFO  [io.quarkus] (main) Installed features: [cdi, mutiny, smallrye-context-propagation, vertx]
```

i.e. grpc server is not started.


But if the proto folder is copied into grpc-service, it works:

```
cp -R grpc-grammar/src/main/proto grpc-service/src/main
mvn clean install
java -jar grpc-service/target/grpc-service-1.0.0-SNAPSHOT-runner.jar
```

Output:
```
2021-02-17 11:44:15,654 INFO  [io.qua.grp.run.GrpcServerRecorder] (vert.x-eventloop-thread-1) gRPC Server started on 0.0.0.0:9000 [SSL enabled: false]
2021-02-17 11:44:15,751 INFO  [io.quarkus] (main) grpc-service 1.0.0-SNAPSHOT on JVM (powered by Quarkus 1.11.3.Final) started in 3.863s. Listening on: http://0.0.0.0:8080
2021-02-17 11:44:15,752 INFO  [io.quarkus] (main) Profile prod activated.
2021-02-17 11:44:15,752 INFO  [io.quarkus] (main) Installed features: [cdi, grpc-server, mutiny, smallrye-context-propagation, vertx]
```
