package com.vti.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDto;
import com.vti.dto.DonHangDto;
import com.vti.entity.DonHang;
import com.vti.form.DonHangFilterForm;
import com.vti.form.DonHangFormForCreating;
import com.vti.form.DonHangFormForUpdating;
import com.vti.service.IDonHangService;

@RestController
@RequestMapping(value = "api/v1/donhangs")
@CrossOrigin("*")
public class DonHangController {

	@Autowired
	private IDonHangService service;

	@GetMapping()
	public ResponseEntity<?> getAllDonHangs(
			Pageable pageable, 
			@RequestParam(required = false) String search,
			DonHangFilterForm filter) {
		Page<DonHang> entitiesPage = service.getAllDonHangs(pageable, search, filter);

		// convert entities --> dtos
		Page<DonHangDto> dtoPage = entitiesPage.map(new Function<DonHang, DonHangDto>() {
			@Override
			public DonHangDto apply(DonHang entity) {
				DonHangDto dto = new DonHangDto(entity.getId(), entity.getName(),entity.getSoLuong(),
						new AccountDto(entity.getAuthor().getId(), entity.getAuthor().getFullName()),
						entity.getCreateDate());
				return dto;
			}
		});

		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDonHangByID(@PathVariable(name = "id") short id) {

		DonHang entity = service.getDonHangByID(id);

		DonHangDto dto = new DonHangDto(entity.getId(), entity.getName(),entity.getSoLuong(),
				new AccountDto(entity.getAuthor().getId(), entity.getAuthor().getFullName()),
				entity.getCreateDate());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/name/{name}/exists")
	public ResponseEntity<?> existsByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<>(service.isDonHangExistsByName(name), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDonHang(@RequestBody DonHangFormForCreating form) {
		service.createDonHang(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDonHang(@PathVariable(name = "id") short id,
			@RequestBody DonHangFormForUpdating form) {
		service.updateDonHang(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDonHang(@PathVariable(name = "id") short id) {
		service.deleteDonHang(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteDonHangs(@RequestParam(name = "ids") List<Short> ids) {
		service.deleteDonHangs(ids);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
