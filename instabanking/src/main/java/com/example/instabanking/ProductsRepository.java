package com.example.instabanking;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.instabanking.Products;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Transactional
public interface ProductsRepository extends JpaRepository<Products, Integer> {
	
	public Products findByid(Integer id);

}