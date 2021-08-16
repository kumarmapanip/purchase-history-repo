//package com.rvy.dao;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.rvy.PurchaseHistorySupermarketApplication;
//import com.rvy.entity.PurchaseHistory;
//import com.rvy.model.Customer;
//import com.rvy.model.Store;
//import com.rvy.repository.PurchaseHistoryRepo;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { PurchaseHistorySupermarketApplication.class })
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@DataJpaTest
//class PurchaseHistoryRepositoryIntegrationTest {
//
//	@Autowired
//    private TestEntityManager entityManager;
//	
//	@Autowired
//	private PurchaseHistoryRepo repository;
//
//	
//	@Test
//	public void insertCheckSize() {
//		
//		Integer _prevSz = repository.findAll().size();
//		Store store = new Store(13,"Gupta Store","Basantia",7978256456L,"gupta@gmail.com");
//		PurchaseHistory ph1 = new PurchaseHistory(null, new Customer(100,200,"Kumar Mapanip",null,null,null,null,null,null,null,null,null,null),null,null,store);
//		PurchaseHistory ph2 = new PurchaseHistory(null, new Customer(101,201,"Milly Brown",null,null,null,null,null,null,null,null,null,null),null,null,store);
//		
//		int ctr=0;
//		/*entityManager.persistAndFlush(ph1);++ctr;
//		entityManager.persistAndFlush(ph2);++ctr;*/
//
//		List<PurchaseHistory> phList = repository.findAll();
//		
//		assertThat(phList).hasSize(_prevSz+ctr);
//		
//	}
//	
////	@Test
////	public void checkingIds() {
////		
////		Customer customer1 = new Customer(null,19080,"Shakal Welcme","sw@gmail.com","Magarmachhcity");
////		entityManager.persistAndFlush(customer1);
////		
////		Customer customerFromDb = repository.findById(customer1.getCustomerId()).get();
////		assertThat(customerFromDb).isEqualTo(customer1);
////	}
////	
////	@Test
////	public void checkingDaoFunctions()
////	{
////		Customer customer = new Customer(null,19080,"Shakal Welcome","sw@gmail.com","Magarmachhcity");
////		entityManager.persistAndFlush(customer);
////		
////		Customer custDb = repository.findByName("Shakal Welcome");
////		assertThat(custDb.getEmail()).isEqualTo(customer.getEmail());
////		assertThat(customer.getCity()).isEqualTo(custDb.getCity());
////	}
////	
////	
////    @Test
////    public void whenInvalidContactDetails_thenReturnNull() {
////    		Customer cust = repository.findByName("Trojan Virus");
////    		List<Customer> custList = new ArrayList<>();
////    		if(cust!=null)custList.add(cust);
////    		assertThat(custList).isEmpty();
////    }
//    
//
//    @Test
//    public void whenInvalidId_thenReturnNull() {
//    	PurchaseHistory fromDb = repository.findById("a11").orElse(null);
//        assertThat(fromDb).isNull();
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//    
//    
//
//
