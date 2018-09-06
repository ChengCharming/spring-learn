package com.java.spihibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.spihibernate.bean.Category;
import com.java.spihibernate.bean.Expense;
import com.java.spihibernate.bean.User;



@Service
@Transactional
public class ExpenseService {
@Autowired
 private HibernateManager hibernateManager ;

	public void saveExpense(Expense expense) {
		hibernateManager.save(expense);
	}
	public  List<Expense> listAllExpense(){
		return hibernateManager.getAllList(Expense.class);
	}
	public Category getCategoryByCode(String code) {
		return hibernateManager.getObjectByCode(Category.class, code);
	}
	public  User getUser(String username,String password) {
		return hibernateManager.getObjectByUser(User.class, username, password);
	}

	
}
