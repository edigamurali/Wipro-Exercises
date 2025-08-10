package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.Subject;
import com.wipro.service.SubjectServiceImp;

@RestController
@RequestMapping("/subject")
public class SubjectProducerController {

    @Autowired
    SubjectServiceImp subjectService;

    @PostMapping
	void sendSubjectData(@RequestBody Subject subject)
	{
    	subjectService.sendSubjectData(subject);
	}


}
