package com.community.core.config;

import com.community.core.config.simple.FanFunCustomerServiceImpl;
import org.broadleafcommerce.common.demo.AutoImportPersistenceUnit;
import org.broadleafcommerce.common.demo.AutoImportSql;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jeff Fischer
 */
@Configuration
@ComponentScan("com.community.core")
public class CoreConfig {
    @Bean
    public AutoImportSql blCommunitySolrIndexerData() {
        return new AutoImportSql(AutoImportPersistenceUnit.BL_PU,"/sql/load_solr_reindex_community.sql", 9999);
    }

    @Bean
    protected CustomerService blCustomerService() {
        return new FanFunCustomerServiceImpl();
    }

}
