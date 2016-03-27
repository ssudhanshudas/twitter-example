package com.jedify;

import com.google.gson.Gson;
import com.jedify.socialnets.twitter.FeederService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import twitter4j.Query;


/**
 * Created by j1013575 on 3/27/2016.
 */
public class ApplicationCli {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationCli.class);
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        FeederService feederService = ctx.getBean(FeederService.class);

        LOGGER.info(new Gson().toJson(feederService.getHomeTimeLines()));

        Query query = new Query("world cup");
        LOGGER.info(new Gson().toJson(feederService.search(query)));


    }
}
