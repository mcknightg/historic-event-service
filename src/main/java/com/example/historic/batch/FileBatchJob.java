package com.example.historic.batch;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.core.io.Resource;
import java.io.FileNotFoundException;
import java.io.File;

public interface FileBatchJob<I,O> {
    void run(File file, int chunkSize) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException,FileNotFoundException;
    void run(String stepName, Resource resource, int chunkSize) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException;
    ItemProcessor<I,O> processor();
    ItemWriter<O> writer();
    ItemReader<I> reader(Resource resource);
}
