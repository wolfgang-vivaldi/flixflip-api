package com.flixflip.api.movie;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.easynotes.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class MovieController {

	@Autowired
	MovieRepository movieRepository;

	@GetMapping("/movies")
	public List<Movie> getAllMovie() {
		return movieRepository.findAll();
	}

	@PostMapping("/movies")
	public Movie addMovie(@Valid @RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	
	@GetMapping("/movies/{id}")
	public Movie getMovieById(@PathVariable(value = "id") Long id) {
		return movieRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
	}
	
//	@PutMapping("/movies/{id}")
//	public Movie getMovieById(@PathVariable(value = "id") Long id) {
//		return movieRepository.findById(id)
//			.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
//	}
//	
//	@PatchMapping("/movies/{id}")
}
