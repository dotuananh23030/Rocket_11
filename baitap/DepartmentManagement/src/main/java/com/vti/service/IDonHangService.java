package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.DonHang;
import com.vti.form.DonHangFilterForm;
import com.vti.form.DonHangFormForCreating;
import com.vti.form.DonHangFormForUpdating;

public interface IDonHangService {

	public Page<DonHang> getAllDonHangs(Pageable pageable, String search, DonHangFilterForm filter);

	public DonHang getDonHangByID(short id);

	public DonHang getDonHangByName(String name);

	public void createDonHang(DonHangFormForCreating form);

	public void updateDonHang(short id, DonHangFormForUpdating form);

	public void deleteDonHang(short id);

	public boolean isDonHangExistsByID(short id);

	public boolean isDonHangExistsByName(String name);

	public void deleteDonHangs(List<Short> ids);
}
