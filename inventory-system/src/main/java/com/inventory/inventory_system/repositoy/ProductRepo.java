package com.inventory.inventory_system.repositoy;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.inventory.inventory_system.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
	

    boolean existsByName(String name);
    

}
