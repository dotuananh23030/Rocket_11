package com.vti.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.vti.entity.Account;
import com.vti.entity.DonHang;
import com.vti.form.DonHangFilterForm;
import com.vti.form.DonHangFormForCreating;
import com.vti.form.DonHangFormForUpdating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDonHangRepository;
import com.vti.specification.DonHangSpecification;

@Service
@Transactional
public class DonHangService implements IDonHangService {

	@Autowired
	private IDonHangRepository donHangRepository;

	@Autowired
	private IAccountRepository accountRepository;

	public Page<DonHang> getAllDonHangs (Pageable pageable,String search,DonHangFilterForm filter) {
		
		Specification<DonHang> where = null;
		
		if(!StringUtils.isEmpty(search)) {
			DonHangSpecification nameSpecification = new DonHangSpecification("name","LIKE",search);
			DonHangSpecification authorSpecification = new DonHangSpecification("author.fullName", "LIKE",search);
			where = Specification.where(nameSpecification).or(authorSpecification);
		}		
	if(filter != null && filter.getMinDate() != null) {
		DonHangSpecification minDateSpecification = new DonHangSpecification("createDate",">=",filter.getMinDate());
		if(where == null) {
			where = Specification.where(minDateSpecification);
		}else {
			where = where.and(minDateSpecification);
		}
	}
	
	if(filter != null && filter.getMaxDate() != null) {
		DonHangSpecification maxDateSpecification = new DonHangSpecification("createDate","<=",filter.getMaxDate());
		if(where == null) {
			where = Specification.where(maxDateSpecification);
		}else {
			where = where.and(maxDateSpecification);
		}
	}
		return donHangRepository.findAll(where,pageable);
	}

	public DonHang getDonHangByID(short id) {
		return donHangRepository.findById(id).get();
	}

	public DonHang getDonHangByName(String name) {
		return donHangRepository.findByName(name);
	}

	public void createDonHang(DonHangFormForCreating form) {
		// convert form --> entity

		// get author
		Account author = accountRepository.findById(form.getAuthorId()).get();

		DonHang DonHang = new DonHang(form.getName(),form.getSoLuong());
		DonHang.setAuthor(author);

		donHangRepository.save(DonHang);
	}

	public void updateDonHang(short id, DonHangFormForUpdating form) {
		DonHang DonHang = getDonHangByID(id);
		DonHang.setName(form.getName());
		DonHang.setModifiedDate(new Date());
		donHangRepository.save(DonHang);
	}

	public void deleteDonHang(short id) {
		donHangRepository.deleteById(id);
	}

	public boolean isDonHangExistsByID(short id) {
		return donHangRepository.existsById(id);
	}

	public boolean isDonHangExistsByName(String name) {
		return donHangRepository.existsByName(name);
	}

	public void deleteDonHangs(List<Short> ids) {
		donHangRepository.deleteByIds(ids);
	}
}
