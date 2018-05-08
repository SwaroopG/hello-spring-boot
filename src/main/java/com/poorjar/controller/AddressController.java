package com.poorjar.controller;

import com.google.common.base.Strings;
import com.poorjar.entity.Address;
import com.poorjar.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;
    @PersistenceContext
    private EntityManager entityManager;

    private static Logger logger = LoggerFactory.getLogger(AddressController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/addresses")
    public List<Address> handleRequest() {
        return this.addressRepository.findAll();
    }

    /**
     * This is the exact city name search. Case Insensitive.
     * <b>Usage<b/>: http://localhost:8080/addresses?city=olathe
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addresses", params = {"city"})
    public List<Address> handleGetAddressesByCityExactName(@RequestParam("city") String city) {
        logger.error("In..handleGetAddressByCity...");
        if (Strings.isNullOrEmpty(city)) {
            return Collections.emptyList();
        }

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Address> query = builder.createQuery(Address.class);
        Root<Address> root = query.from(Address.class);
        Predicate predicate = AddressCriteria.equalCity(city.toLowerCase()).toPredicate(root, query, builder);
        query.where(predicate);
        List<Address> result = entityManager.createQuery(query).getResultList();
        return result;
    }

    /**
     * This is the LIKE %city% and LIKE %country% search. Case Insensitive.
     * <b>Usage<b/>: http://localhost:8080/addresses?city=over&country=us
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addresses", params = {"city", "country"})
    public List<Address> handleGetAddressByCityAndCountry(@RequestParam("city") String city, @RequestParam("country") String country) {
        logger.error("In..handleGetAddressByCityAndCountry...");
        if (Strings.isNullOrEmpty(city) && Strings.isNullOrEmpty(country)) {
            return Collections.emptyList();
        }

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Address> query = builder.createQuery(Address.class);
        Root<Address> root = query.from(Address.class);
        Predicate predicate = Specifications.where(AddressCriteria.likeCity(city.toLowerCase())).
            and(AddressCriteria.likeCountry(country.toLowerCase())).toPredicate(root, query, builder);
        query.where(predicate);
        List<Address> result = entityManager.createQuery(query).getResultList();
        return result;
    }
}


