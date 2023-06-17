package com.vanndeth.phoneshopmgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vanndeth.phoneshopmgt.dto.BrandDTO;
import com.vanndeth.phoneshopmgt.entity.Brand;
import com.vanndeth.phoneshopmgt.service.BrandService;
import com.vanndeth.phoneshopmgt.service.util.Mapper;

@RestController
@RequestMapping("brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
		Brand brand = Mapper.toBrand(brandDTO);
		brand = brandService.create(brand);
		
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId) {
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBrand(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO) {
		Brand brand = Mapper.toBrand(brandDTO);
		Brand newBrand = brandService.update(brandId, brand);
		return ResponseEntity.ok(Mapper.toBrandDTO(newBrand));
		
	}

}