package com.cg.jobportal.service;

import java.util.List;
import java.util.Optional;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.jobportal.entity.Admin;
import com.cg.jobportal.exceptions.AdminAlreadyExistException;
import com.cg.jobportal.exceptions.InvalidAdminException;
import com.cg.jobportal.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin saveAdmin(Admin admin) throws AdminAlreadyExistException {
	/*	Admin admin1 = new Admin();
		String userName = admin.getUserName();
		String email = admin.getEmail();
		String firstName = admin.getFirstName();
		String lastName = admin.getLastName();
		String password = admin.getPassword();
		if (!(firstName == null || lastName == null || password == null || userName == null || email == null)  && !adminRepository.existsByUserName(admin1.getUserName()) ) {
			admin1.setUserName(userName);
			admin1.setFirstName(firstName);
			admin1.setLastName(lastName);
			admin1.setPassword(password);
			admin1.setEmail(email);*/
		if(!adminRepository.existsByUserName(admin.getUserName())) {
			return adminRepository.save(admin);
		}
		else{
			throw new AdminAlreadyExistException();
		}
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(long adminId) throws InvalidAdminException {

		if (adminRepository.existsById(adminId)) {
			return adminRepository.findById(adminId).get();

		} else {
			throw new InvalidAdminException();
		}
	}

	@Override
	public Admin updateAdmin(long adminId, Admin admin) throws InvalidAdminException {
		if (adminRepository.existsById(adminId)) {
			return adminRepository.save(admin);
		} else {
			throw new InvalidAdminException();
		}

	}

	@Override
	public String loginAdmin(Admin admin) {
		Optional<Admin> a = Optional.of(adminRepository.findByUserName(admin.getUserName()));
		//List<Admin> b = adminRepository.getByPassword(admin.getPassword());
		if (a.isPresent()) {
		if(a.get().getPassword().equals(admin.getPassword())) {
			return "Login Successfull";
		}
		
	}
		return "Invalid email or password";

	}
}
