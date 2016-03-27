package com.jedify;

import com.jedify.config.TwitterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by j1013575 on 3/27/2016.
 */
@Configuration
@Import(TwitterConfig.class)
@ComponentScan
public class AppConfig {

    @Autowired
    TwitterConfig twitterConfig;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    Twitter twitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(twitterConfig.getConsumerKey())
                .setOAuthConsumerSecret(twitterConfig.getConsumerSecret())
                .setOAuthAccessToken(twitterConfig.getAccessToken())
                .setOAuthAccessTokenSecret(twitterConfig.getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

    @Bean
    TwitterConfig twitterConfig() {
        return new TwitterConfig();
    }
}
