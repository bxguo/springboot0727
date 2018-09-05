package bxguo.mongdb.config.primary;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by bxguo on 2018/9/6 0:12
 */
@Configuration
@EnableMongoRepositories(basePackages = "bxguo.mongdb.config.primary", mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE)
public class PrimaryMongoConfig {
    public static final String MONGO_TEMPLATE = "primaryMongoTemplate";
}
