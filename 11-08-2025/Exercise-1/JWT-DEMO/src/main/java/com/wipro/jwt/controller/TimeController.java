package com.wipro.jwt.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

	@PostMapping("time")
	public LocalDateTime getCurrentTime()
	{
		return LocalDateTime.now();
	}
}
