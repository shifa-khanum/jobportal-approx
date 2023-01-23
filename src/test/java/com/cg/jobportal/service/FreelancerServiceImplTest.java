
package com.cg.jobportal.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.jobportal.entity.Freelancer;
import com.cg.jobportal.exceptions.FreelancerAlreadyExistException;
import com.cg.jobportal.exceptions.InvalidFreelancerException;
import com.cg.jobportal.repository.FreelancerRepository;

@ExtendWith(MockitoExtension.class)
public class FreelancerServiceImplTest {

	@InjectMocks
	private FreelancerServiceImpl freelancerServiceImpl;
	@Mock
	private FreelancerRepository freelancerRepository;

	@Test
	public void savefreelancer_exception() throws FreelancerAlreadyExistException {
		Freelancer freelancer = new Freelancer(1, "john", "doe", "johndoe", "john1234");
		Mockito.when(freelancerRepository.existsById((long) 1)).thenReturn(true);
		Assertions.assertThrows(FreelancerAlreadyExistException.class,
				() -> freelancerServiceImpl.saveFreelancer(freelancer));
	}

	@Test
	public void savefreelancer_success() throws FreelancerAlreadyExistException {
		Freelancer freelancer = new Freelancer(1, "john", "doe", "johndoe", "john1234");
		Mockito.when(freelancerRepository.save(any())).thenReturn(freelancer);
		Freelancer savefreelancer = freelancerServiceImpl.saveFreelancer(freelancer);
		Assertions.assertEquals(1, savefreelancer.getId());
	}

	@Test
	public void updatefreelancer_success() throws InvalidFreelancerException {
		Freelancer freelancer = new Freelancer(1, "john", "Smith", "johndoe", "john1234");
		Mockito.when(freelancerRepository.existsById((long) 1)).thenReturn(true);
		Mockito.when(freelancerRepository.save(any())).thenReturn(freelancer);
		Freelancer mockFreelancer = freelancerServiceImpl.updateFreelancer(freelancer);
		Assertions.assertEquals(1, mockFreelancer.getId());
	}

	@Test
	public void updatefreelancer_exception() throws InvalidFreelancerException {
		Freelancer freelancer = new Freelancer(1, "john", "Smith", "johndoe", "john1234");
		Mockito.when(freelancerRepository.existsById((long) 1)).thenReturn(false);
		Assertions.assertThrows(InvalidFreelancerException.class,
				() -> freelancerServiceImpl.updateFreelancer(freelancer));
	}
}