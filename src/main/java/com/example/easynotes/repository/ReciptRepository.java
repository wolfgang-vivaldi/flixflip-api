package com.example.easynotes.repository;

import com.example.easynotes.model.Recipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface ReciptRepository extends JpaRepository<Recipt, Long> {

}