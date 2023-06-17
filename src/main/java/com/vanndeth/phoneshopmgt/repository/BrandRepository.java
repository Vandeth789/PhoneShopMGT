package com.vanndeth.phoneshopmgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanndeth.phoneshopmgt.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
