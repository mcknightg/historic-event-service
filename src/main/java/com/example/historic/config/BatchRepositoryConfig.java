package com.example.historic.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.DatabaseType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchRepositoryConfig extends DefaultBatchConfigurer {

    private final DataSource dataSource;
    private final PlatformTransactionManager platformTransactionManager;

    public BatchRepositoryConfig(@Qualifier("batchDataSource") DataSource dataSource, PlatformTransactionManager platformTransactionManager) {
        this.dataSource = dataSource;
        this.platformTransactionManager = platformTransactionManager;
    }

    @Override
    protected JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
        factoryBean.setDatabaseType(DatabaseType.H2.getProductName());
        factoryBean.setTablePrefix("BATCH_");
        factoryBean.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");
        factoryBean.setDataSource(this.dataSource);
        factoryBean.setTransactionManager(platformTransactionManager);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Override
    protected JobExplorer createJobExplorer() throws Exception {
        JobExplorerFactoryBean factoryBean = new JobExplorerFactoryBean();
        factoryBean.setDataSource(this.dataSource);
        factoryBean.setTablePrefix("BATCH_");
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
