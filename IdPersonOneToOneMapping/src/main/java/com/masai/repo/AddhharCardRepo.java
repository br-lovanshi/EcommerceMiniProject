package com.masai.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.AddharCard;

@Repository
public interface AddhharCardRepo extends JpaRepository<AddharCard, Integer> {



}
