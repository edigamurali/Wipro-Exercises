package com.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.dto.Subject;

@Service
public class SubjectServiceImp implements SubjectServiceI {

	@Autowired
	KafkaTemplate<String,Subject> kafkTemplate;

	@Override
	public void sendSubjectData(Subject subject) {
		
		kafkTemplate.send("learn-subject", subject);
	}

	

}
