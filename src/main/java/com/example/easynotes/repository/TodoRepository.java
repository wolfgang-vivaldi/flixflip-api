package com.example.easynotes.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	List<Todo> findByStatus(boolean status);

//    List<Todo> find

//    Stream<Todo> findByStatus(boolean status);
}
