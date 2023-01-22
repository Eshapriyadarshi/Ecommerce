/*
 * package com.pelatro.Myecom.service;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.pelatro.Myecom.commonresponse.MyecomResponse; import
 * com.pelatro.Myecom.model.ProductCategory; import
 * com.pelatro.Myecom.model.ProductSubcategory; import
 * com.pelatro.Myecom.repository.ProductCategoryRepository; import
 * com.pelatro.Myecom.repository.SubCategoryRepository; import
 * com.pelatro.Myecom.service.interfaces.SubCategoryService;
 * 
 * @Service public class SubCategoryServiceImplementation implements
 * SubCategoryService{
 * 
 * @Autowired private SubCategoryRepository subCategoryRepo;
 * 
 * @Autowired private ProductCategoryRepository categoryRepo;
 * 
 * @Override public MyecomResponse displayAllSubcategories(String categoryName)
 * { MyecomResponse response = new MyecomResponse();
 * 
 * try { ProductCategory p=categoryRepo.findByName(categoryName.toLowerCase());
 * long categoryId=p.getCategoryId(); List<ProductSubcategory>
 * subCategories=subCategoryRepo.findByCategory(categoryId);
 * if(subCategories.isEmpty()) {
 * response.setStatus("No subcategories in the category");
 * response.setContent(null); System.out.println("-----no subcategory-----"); }
 * else { response.setStatus("OK"); response.setContent(subCategories);
 * System.out.println("----- sending subcategories list------"); }
 * 
 * } catch (Exception e) { e.printStackTrace(); response.setStatus("FAILURE"); }
 * return response; }
 * 
 * }
 */