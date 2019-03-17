package com.Harish.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Harish.shoppingbackend.dao.CategoryDAO;
import com.Harish.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.Harish.shoppingbackend");
		context.scan("com.Harish.shoppingbackend.config");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	
	/*  @Test public void testAddCategory() { category = new Category();
	  
	  category.setName("Laptops");
	  category.setDescription("This is description for Laptops");
	  category.setImageURL("CAT_2.png");
	  
	  assertEquals("Successfully added a category inside the table",true,
	  categoryDAO.add(category)); }
	  
	  /*@Test public void testGetCategory() { category = categoryDAO.get(1);
	 * assertEquals("Successfully fected a single category form the table!"
	 * ,"Television",category.getName()); }
	 * 
	 * /*@Test public void testUpdateCategory() { category = categoryDAO.get(1);
	 * 
	 * category.setName("TV");
	 * assertEquals("Successfully updated a single category in the table!",true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(1);
	 * 
	 * assertEquals("Successfully deleted a single category in the table!",true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * 
	 * assertEquals("Successfully fectched the list of categories form the table!",2
	 * ,categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {
		// add operation
		category = new Category();

		category.setName("Laptops");
		category.setDescription("This is description for Laptops");
		category.setImageURL("CAT_1.png");

		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("This is description for Television");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));

		// fetching and updating the Category
		category = categoryDAO.get(2);

		category.setName("TV");
		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));

		// deleting operation

		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));

	   //fetching the list of Category
		assertEquals("Successfully fectched the list of categories form the table!",1,categoryDAO.list().size()); 
	
	
	}

}
