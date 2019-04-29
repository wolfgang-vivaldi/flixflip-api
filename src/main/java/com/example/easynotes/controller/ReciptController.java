package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Recipt;
import com.example.easynotes.repository.ReciptRepository;

@RestController
@RequestMapping("/api")
public class ReciptController {

	@Autowired
	ReciptRepository reciptRepository;

	@GetMapping("/recipts")
	public List<Recipt> getAllRecipts() {
		return reciptRepository.findAll();
	}

	@PostMapping("/recipts")
	public Recipt createRecipt(@Valid @RequestBody Recipt recipt) {
		return reciptRepository.save(recipt);
	}

	@GetMapping("/recipts/{id}")
	public Recipt getReciptById(@PathVariable(value = "id") long reciptId) {
		return reciptRepository.findById(reciptId)
				.orElseThrow(() -> new ResourceNotFoundException("Recipt", "id", reciptId));
	}

	@PutMapping("/recipts/{id}")
	public Recipt updateRecipt(@PathVariable(value = "id") Long reciptId, @Valid @RequestBody Recipt reciptDetails) {
		Recipt recipt = reciptRepository.findById(reciptId)
				.orElseThrow(() -> new ResourceNotFoundException("Recipt", "id", reciptId));
		recipt.setTitle(reciptDetails.getTitle());
		recipt.setAmount(reciptDetails.getAmount());
		Recipt updatedRecipt = reciptRepository.save(recipt);
		return updatedRecipt;
	}

	@DeleteMapping("/recipts/{id}")
	public ResponseEntity<?> deleteReciptById(@PathVariable(value = "id") long reciptId) {
		Recipt recipt = reciptRepository.findById(reciptId)
				.orElseThrow(() -> new ResourceNotFoundException("Recipt", "id", reciptId));

		reciptRepository.delete(recipt);
		return ResponseEntity.ok().build();
	}

}
