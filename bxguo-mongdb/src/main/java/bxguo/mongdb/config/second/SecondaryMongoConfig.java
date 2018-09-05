package bxguo.mongdb.config.second;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by bxguo on 2018/9/6 0:14
 */
@Configuration
@EnableMongoRepositories(basePackages = "bxguo.mongdb.config.second",
        mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE)
public class SecondaryMongoConfig {

    public static final String MONGO_TEMPLATE = "secondaryMongoTemplate";
}
