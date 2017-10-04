package com.example.instabanking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.instabanking.UserDriving;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Transactional
public interface DrivingRepository extends JpaRepository<UserDriving, String> {
	
	public UserDriving findBypan(String pan);
	public List<UserDriving> findAll();

}

