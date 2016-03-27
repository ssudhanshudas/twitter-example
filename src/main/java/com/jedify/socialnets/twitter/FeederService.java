package com.jedify.socialnets.twitter;

import com.jedify.common.FeedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j1013575 on 3/27/2016.
 */
@Component
public class FeederService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeederService.class);

    private final Twitter twitter;

    @Autowired
    public FeederService(Twitter twitter) {
        this.twitter = twitter;
    }

    public void updateStatus(String message) {
        try {
            twitter.updateStatus(message);
        } catch (TwitterException e) {
            LOGGER.error("Error updating the status", e);
            throw new FeedException("Error updating the status");
        }
    }

    public void updateStatus(StatusUpdate status) {
        try {
            twitter.updateStatus(status);
        } catch (TwitterException e) {
            LOGGER.error("Error updating the status", e);
            throw new FeedException("Error updating the status");
        }
    }

    public List<Tweet> getHomeTimeLines() {
        List<Tweet> tweets = new ArrayList<Tweet>();
        try {
            List<Status> statuses = twitter.getHomeTimeline();
            for (Status status : statuses) {
                tweets.add(new Tweet.Builder().withStatus(status).build());
            }
        } catch (TwitterException e) {
            LOGGER.error("Error retrieving the home timeline", e);
            throw new FeedException("Error retrieving the home timeline");
        }
        return tweets;
    }

    public List<Tweet> search(Query query) {
        List<Tweet> tweets = new ArrayList<Tweet>();
        try {
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                tweets.add(new Tweet.Builder().withStatus(status).build());
            }
        } catch (TwitterException e) {
            LOGGER.error("Error getting tweets for the provided query", e);
            throw new FeedException("Error getting tweets for the provided query ");
        }
        return tweets;
    }
}
