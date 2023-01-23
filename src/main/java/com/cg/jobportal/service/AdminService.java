package com.cg.jobportal.service;

import java.util.List;

import com.cg.jobportal.entity.Admin;
import com.cg.jobportal.exceptions.AdminAlreadyExistException;
import com.cg.jobportal.exceptions.InvalidAdminException;

import jakarta.validation.Valid;

public interface AdminService {

	Admin saveAdmin(@Valid Admin admin) throws AdminAlreadyExistException;

	List<Admin> getAllAdmins();

	Admin updateAdmin(long adminId, Admin admin) throws InvalidAdminException;

	String loginAdmin(Admin admin);

	Admin getAdminById(long adminId) throws InvalidAdminException;
}
