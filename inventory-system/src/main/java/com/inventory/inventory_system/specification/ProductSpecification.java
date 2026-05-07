package com.inventory.inventory_system.specification;

import org.springframework.data.jpa.domain.Specification;

import com.inventory.inventory_system.dto.ProductFilterDto;
import com.inventory.inventory_system.entity.Product;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ProductSpecification {

	public static Specification<Product> filter(ProductFilterDto filter) {

		return new Specification<Product>() {

			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Predicate predicate = cb.conjunction(); // TRUE (base condition)

				// 🔍 NAME FILTER
				if (filter.getName() != null && !filter.getName().isEmpty()) {
					predicate = cb.and(predicate,
							cb.like(cb.lower(root.get("name")), "%" + filter.getName().trim().toLowerCase() + "%"));
				}

				// 💰 MIN PRICE
				if (filter.getMinPrice() != null) {
					predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("price"), filter.getMinPrice()));
				}

				// 💰 MAX PRICE
				if (filter.getMaxPrice() != null) {
					predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("price"), filter.getMaxPrice()));
				}

				// 📦 AVAILABLE QUANTITY
				if (filter.getMinAvailableQuantity() != null) {
					predicate = cb.and(predicate,
							cb.greaterThanOrEqualTo(root.get("availableQuantity"), filter.getMinAvailableQuantity()));
				}
//				if (filter.getName() != null && !filter.getName().trim().isEmpty()) {
//					predicate = cb.and(predicate,
//							cb.like(cb.lower(root.get("name")), "%" + filter.getName().trim().toLowerCase() + "%"));
//				}
				return predicate; 
			}
		};
	}
}
