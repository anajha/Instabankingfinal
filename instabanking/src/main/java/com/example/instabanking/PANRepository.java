package com.example.instabanking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.instabanking.UserPAN;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Transactional
public interface PANRepository extends JpaRepository<UserPAN, String> {
	
	public UserPAN findBypan(String pan);
	public List<UserPAN> findAll();
}