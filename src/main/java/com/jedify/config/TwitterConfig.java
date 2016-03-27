package com.jedify.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by j1013575 on 3/27/2016.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class TwitterConfig {
    @Value("${twitter.credential.consumerKey}")
    private String consumerKey;

    @Value("${twitter.credential.consumerSecret}")
    private String consumerSecret;

    @Value("${twitter.credential.accessToken}")
    private String accessToken;

    @Value("${twitter.credential.accessTokenSecret}")
    private String accessTokenSecret;

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
}