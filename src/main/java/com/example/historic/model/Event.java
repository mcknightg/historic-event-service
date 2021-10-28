package com.example.historic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Event {

	@Id
	private String id;
	private String date;
	private String description;
	private String lang;
	private String category1;
	private String category2;
	private String granularity;
}