package br.unitins.client;

import email.EmailServiceGrpc;
import email.Email.AddEmailRequest;
import email.Email.AddEmailResponse;
import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmailGrpcClient {

    @GrpcClient("email-service")
    EmailServiceGrpc.EmailServiceBlockingStub emailServiceBlockingStub;

    public boolean addEmail(String email){
        AddEmailRequest request = AddEmailRequest.newBuilder().setEmail(email).build();

        AddEmailResponse response = emailServiceBlockingStub.addEmail(request);

        return response.getSuccess();
    }
    
}
