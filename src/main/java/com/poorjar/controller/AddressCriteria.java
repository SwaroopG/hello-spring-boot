package com.poorjar.controller;

import com.poorjar.entity.Address;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AddressCriteria {
    public static Specification<Address> equalCity(String city) {
        return new Specification<Address>() {
            @Override
            public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(criteriaBuilder.lower(root.get("city")), city);
            }
        };
    }

    public static Specification<Address> likeCity(String city) {
        return new Specification<Address>() {
            @Override
            public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("city")), "%" + city + "%");
            }
        };
    }

    public static Specification<Address> likeCountry(String country) {
        return new Specification<Address>() {
            @Override
            public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("country")), "%" + country + "%");
            }
        };
    }
}
