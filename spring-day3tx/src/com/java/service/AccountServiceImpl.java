package com.java.service;

import javax.annotation.Resource;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.java.dao.AccountDao;

import javafx.beans.property.ReadOnlyBooleanProperty;
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
public class AccountServiceImpl implements AccountService {
//	private TransactionTemplate tt;
	private AccountDao ad;
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false )
	public void transfer(Integer id, Integer id2, double money) {
		
	
		ad.decreaseMoney(id, money);
		
		//int i=1/0;
		
		ad.increaseMoney(id2, money);

	}
	

	public void setAd(AccountDao ad) {
		this.ad = ad;
	}
	/*	@Override
	public void transfer(final Integer id,final Integer id2,final double money) {
		
	   tt.execute(new TransactionCallbackWithoutResult() {
		
		@Override
		protected void doInTransactionWithoutResult(TransactionStatus arg0) {
			ad.decreaseMoney(id, money);
			ad.increaseMoney(id2, money);
			
		}
	});
		

	}*/
	/*public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}*/
	
}
