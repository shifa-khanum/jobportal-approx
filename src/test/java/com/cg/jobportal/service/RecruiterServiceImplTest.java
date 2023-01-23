
package com.cg.jobportal.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.jobportal.entity.Recruiter;
import com.cg.jobportal.exceptions.RecruiterAlreadyExistException;
import com.cg.jobportal.exceptions.InvalidRecruiterException;
import com.cg.jobportal.repository.RecruiterRepository;


@ExtendWith(MockitoExtension.class)
public class RecruiterServiceImplTest {
	
	@InjectMocks
	private RecruiterServiceImpl recruiterServiceImpl;
	@Mock
	private RecruiterRepository recruiterRepository;

	@Test
	public void saveRecruiter_exception() throws RecruiterAlreadyExistException {
		Recruiter Recruiter = new Recruiter(1, "john", "doe", "johndoe","john1234");
		Mockito.when(recruiterRepository.existsById((long) 1)).thenReturn(true);
		Assertions.assertThrows(RecruiterAlreadyExistException.class, () -> recruiterServiceImpl.saveRecruiter(Recruiter));
		}
	
	@Test
	public void saveRecruiter_success() throws RecruiterAlreadyExistException {
		Recruiter Recruiter = new Recruiter(1, "john", "doe", "johndoe","john1234");
		Mockito.when(recruiterRepository.save(any())).thenReturn(Recruiter);
	Recruiter saveRecruiter = recruiterServiceImpl.saveRecruiter(Recruiter);
	Assertions.assertEquals(1, saveRecruiter.getId());
	}

	@Test
	public void updateRecruiter_success() throws InvalidRecruiterException {
		Recruiter Recruiter = new Recruiter(1, "john", "Smith", "johndoe","john1234");
		Mockito.when(recruiterRepository.existsById((long) 1)).thenReturn(true);
		Mockito.when(recruiterRepository.save(any())).thenReturn(Recruiter);
	Recruiter mockRecruiter = recruiterServiceImpl.updateRecruiter(1, Recruiter);
	Assertions.assertEquals(1, mockRecruiter.getId());
	}

	@Test
	public void updateRecruiter_exception() throws InvalidRecruiterException {
		Recruiter Recruiter = new Recruiter(1, "john", "Smith", "johndoe","john1234");
		Mockito.when(recruiterRepository.existsById((long) 1)).thenReturn(false);
		Assertions.assertThrows(InvalidRecruiterException.class, () -> recruiterServiceImpl.updateRecruiter(1, Recruiter));}
}