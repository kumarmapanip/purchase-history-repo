package com.rvy.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rvy.entity.PurchaseHistory;
import com.rvy.model.Store;
import com.rvy.repository.PurchaseHistoryRepo;
import com.rvy.service.PurchaseHistoryService;
import com.rvy.service.PurchaseHistoryServiceImpl;

@ExtendWith(SpringExtension.class)
class PurchaseHistoryServiceIntegrationTest {

	@TestConfiguration
	static class PurchaseHistoryServiceImplTestContextConfiguration {
		@Bean
		public PurchaseHistoryService Service() {
			return new PurchaseHistoryServiceImpl();
		
		}
	}
	
	@Autowired
	private PurchaseHistoryService purchaseService;
	
	@MockBean
	private PurchaseHistoryRepo repository;
	
	PurchaseHistory purchaseHistory=null;
	@BeforeEach
	public void initTests()
	{
		purchaseHistory = new PurchaseHistory();
		Store store = new Store(13,"Gupta Store","Basantia",7978256456L,"gupta@gmail.com");
		purchaseHistory.setStoreDetail(store);
		purchaseHistory.set_id("alpha123");
		
		Mockito.when(repository.findById("6ef")).thenReturn(null);
		//PurchaseHistory ph1 = purchaseService.getPurchaseHistoryById(purchaseHistory.get_id());
		Mockito.when(repository.findById(purchaseHistory.get_id())).thenReturn(Optional.of(purchaseHistory));
		//Mockito.when(repository.findById(ph1.get_id()).get()).thenReturn(purchaseHistory);
	}
	
	@Test
	public void Test1()
	{
		try
		{
			PurchaseHistory ph = repository.findById(purchaseHistory.get_id()).get();
			assertThat(ph.getStoreDetail().getName()==purchaseHistory.getStoreDetail().getName());
			assertThat(ph.getStoreDetail().getStoreId()==purchaseHistory.getStoreDetail().getStoreId());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test2()
	{
		try
		{
			assertThat(repository.findById("6ef")==null);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
