package com.jedify.socialnets.twitter;

import twitter4j.Status;

import java.util.Date;

/**
 * Created by j1013575 on 3/27/2016.
 */
public class Tweet {
    private long id;
    private Date createdAt;
    private String content;
    private String source;
    private String user;
    private int reTweetCount;
    private boolean isReTweeted;

    public Tweet(Builder builder) {
        this.id = builder.id;
        this.createdAt = builder.createdAt;
        this.content = builder.content;
        this.source = builder.source;
        this.user = builder.user;
        this.isReTweeted = builder.isReTweeted;
        this.reTweetCount = builder.reTweetCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getReTweetCount() {
        return reTweetCount;
    }

    public void setReTweetCount(int reTweetCount) {
        this.reTweetCount = reTweetCount;
    }

    public boolean isReTweeted() {
        return isReTweeted;
    }

    public void setReTweeted(boolean reTweeted) {
        isReTweeted = reTweeted;
    }

    public static class Builder {
        private long id;
        private Date createdAt;
        private String content;
        private String source;
        private String user;
        private int reTweetCount;
        private boolean isReTweeted;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder withContent(String content) {
            this.content = content;
            return this;
        }

        public Builder withSource(String source) {
            this.source = source;
            return this;
        }

        public Builder withUser(String user) {
            this.user = user;
            return this;
        }

        public Builder withReTweetCount(int reTweetCount) {
            this.reTweetCount = reTweetCount;
            return this;
        }

        public Builder withIsReTweeted(boolean isReTweeted) {
            this.isReTweeted = isReTweeted;
            return this;
        }

        public Builder withStatus(Status status) {
          return new Builder()
                  .withId(status.getId())
                  .withContent(status.getText())
                  .withCreatedAt(status.getCreatedAt())
                  .withSource(status.getSource())
                  .withUser(status.getUser().getName())
                  .withIsReTweeted(status.isRetweeted())
                  .withReTweetCount(status.getRetweetCount());
        }

        public Tweet build() {
            return new Tweet(this);
        }
    }
}
