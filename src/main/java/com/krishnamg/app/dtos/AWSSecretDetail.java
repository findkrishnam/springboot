package com.krishnamg.app.dtos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties(ignoreUnknownFields = true)
@PropertySource("classpath:application.properties")
public class AWSSecretDetail {

    private String secretName;
    private String secretEndpoint;
    private String secretRegion;
    private String keyId;
    private String keySecret;

    public AWSSecretDetail(){
    }

    public String getSecretName() {
        return secretName;
    }
    @Value("${aws.secretName}")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public String getEndpoint() {
        return secretEndpoint;
    }
    @Value("${aws.secretEndpoint}")
    public void setEndpoint(String endpoint) {
        this.secretEndpoint = endpoint;
    }

    public String getRegion() {
        return secretRegion;
    }
    @Value("${aws.secretRegion}")
    public void setRegion(String region) {
        this.secretRegion = region;
    }

    public String getAwsSecretId() {
        return keyId;
    }
    @Value("${aws.keyId}")
    public void setAwsSecretId(String awsSecretId) {
        this.keyId = awsSecretId;
    }

    public String getAwsSecretKey() {
        return keySecret;
    }
    @Value("${aws.key.secret}")
    public void setAwsSecretKey(String awsSecretKey) {
        this.keySecret = awsSecretKey;
    }

    @PostConstruct
    public void init(){
        System.out.println("secret detail bean constructed, here are the details"+toString());
    }

    @Override
    public String toString() {
        return "AWSSecretDetail{" +
                "secretName='" + secretName + '\'' +
                ", secretEndpoint='" + secretEndpoint + '\'' +
                ", secretRegion='" + secretRegion + '\'' +
                ", keyId='" + keyId + '\'' +
                ", keySecret='" + keySecret + '\'' +
                '}';
    }
}
