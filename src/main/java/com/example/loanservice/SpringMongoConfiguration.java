package com.example.loanservice;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.scheduling.config.ScheduledTask;

@Configuration
public class SpringMongoConfiguration extends AbstractMongoClientConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;

    @Override
    public MongoClient mongoClient() {
        String myHost = System.getenv("MONGODB_HOST");
        log.info("MONGODB_HOST ------> " + myHost);
        return MongoClients.create("mongodb://"+(myHost == null ? mongoHost : myHost)+":"+mongoPort);
    }

    @Override
    protected String getDatabaseName() {
        return mongoDB;
    }
}
