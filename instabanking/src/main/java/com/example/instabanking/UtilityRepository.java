package com.example.instabanking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.instabanking.UserUtility;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Transactional
public interface UtilityRepository extends JpaRepository<UserUtility, String> {
	
	public UserUtility findBypan(String pan);
	public List<UserUtility> findAll();
	

}