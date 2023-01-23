/*package com.cg.jobportal;

import static org.mockito.ArgumentMatchers.any;import static org.mockito.Mockito.when; 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.jobportal.entity.Admin;
import com.cg.jobportal.exceptions.AdminAlreadyExistException;
import com.cg.jobportal.repository.AdminRepository;
import com.cg.jobportal.service.AdminServiceImpl;
import com.womenempowerment.entity.Scheme;
import com.womenempowerment.exception.SchemeAlreadyExistsException;
import com.womenempowerment.exception.SchemeNotPresentException;
import com.womenempowerment.repository.SchemeRepository;import com.womenempowerment.service.SchemeServiceImpl; 

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
	 
	@InjectMocksprivate
	AdminServiceImpl schemeServiceImpl; 
	@Mockprivate
	AdminRepository schemeRepository; 

	@Test
	public void saveAdmin_exception() throws AdminAlreadyExistException {
		 Admin Admins = new Admin(3, "asdf",  "bvf", "hhjh","abc@gmail","abc123");
		when(AdminRepository.((long) 3)).thenReturn(true);
		Assertions.assertThrows(AdminAlreadyExistsException.class, () -> AdminServiceImpl.addAdmin(Admins));
		 }
	
	 @Test
	public void saveScheme_success() throws SchemeAlreadyExistsException { 
		Scheme schemes = new Scheme(3, "asdf", 2022, "bvf", "hhjh");
	when(schemeRepository.save(any())).thenReturn(schemes);
	Scheme saveSchemes = schemeServiceImpl.addScheme(schemes);
	Assertions.assertEquals(3, saveSchemes.getSchemeId()); 
	} 

	@Test
	public void updateScheme_success() throws SchemeNotPresentException {
		Scheme s = new Scheme(2, "yukjj", 2022, "geh", "eyuu");
	when(schemeRepository.existsById((long) 2)).thenReturn(true);
	when(schemeRepository.save(any())).thenReturn(s);
	Scheme sch = schemeServiceImpl.updateScheme(s);
	Assertions.assertEquals(2, sch.getSchemeId());
	} 

	@Test
	public void updateScheme_exception() throws SchemeNotPresentException {
		Scheme s = new Scheme(2, "yukjj", 2022, "geh", "eyuu");
		when(schemeRepository.existsById((long) 2)).thenReturn(false); 
		Assertions.assertThrows(SchemeNotPresentException.class, () -> schemeServiceImpl.updateScheme(s));}
}*/
