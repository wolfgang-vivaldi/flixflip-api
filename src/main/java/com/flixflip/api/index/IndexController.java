package com.flixflip.api.index;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String splash() {
		return "Flixflip API V.0.1";
	}
}
