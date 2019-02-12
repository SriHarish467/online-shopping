package com.Harish.shoppingbackend.dao;

import java.util.List;

import com.Harish.shoppingbackend.dto.Category;

public interface CategoryDAO {

	
	List<Category> list();
	Category get(int id);
}
