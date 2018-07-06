package com.krishnamg.app.service.impl;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import com.krishnamg.app.dtos.AWSSecretDetail;
import com.krishnamg.app.service.AWSSecretsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

@Service
@Transactional
public class AWSSecretServiceImpl implements AWSSecretsService {

    @Autowired
    AWSSecretDetail awsSecretDetail;

    @Override
    public String getSecret() {
        System.out.println("retrieving secret value " + awsSecretDetail.getSecretName());
        AwsClientBuilder.EndpointConfiguration config = new AwsClientBuilder.EndpointConfiguration(awsSecretDetail.getEndpoint(), awsSecretDetail.getRegion());
        AWSSecretsManagerClientBuilder clientBuilder = AWSSecretsManagerClientBuilder.standard();
        clientBuilder.withCredentials(new StaticCredentialsProvider(new BasicAWSCredentials(awsSecretDetail.getAwsSecretId(), "6tguJJesxnf9oHRcoUtKRsagDewbeZ/UkXw3TXru")));
        clientBuilder.setEndpointConfiguration(config);
        AWSSecretsManager client = clientBuilder.build();

        String secret = "";
        ByteBuffer binarySecretData;
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
                .withSecretId(awsSecretDetail.getSecretName());
        GetSecretValueResult getSecretValueResult = null;
        try {
            getSecretValueResult = client.getSecretValue(getSecretValueRequest);
        } catch (ResourceNotFoundException e) {
            System.out.println("The requested secret " + awsSecretDetail.getSecretName() + " was not found");
        } catch (InvalidRequestException e) {
            System.out.println("The request was invalid due to: " + e.getMessage());
        } catch (InvalidParameterException e) {
            System.out.println("The request had invalid params: " + e.getMessage());
        } catch (com.amazonaws.services.secretsmanager.model.AWSSecretsManagerException e) {
            System.out.println(e);
        }

        if (getSecretValueResult == null) {
            return null;
        }

        if (getSecretValueResult.getSecretString() != null) {
            secret = getSecretValueResult.getSecretString();
        } else {
            binarySecretData = getSecretValueResult.getSecretBinary();
            try {
                secret = new String(binarySecretData.array(), "ASCII");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        System.out.println("retrieved secret \n " + secret);
        return secret;
    }

}
