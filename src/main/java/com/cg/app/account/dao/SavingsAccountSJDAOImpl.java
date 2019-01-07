package com.cg.app.account.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.app.account.SavingsAccount;

@Repository
public class SavingsAccountSJDAOImpl implements SavingsAccountDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}

	@Override 
	public SavingsAccount createNewAccount(SavingsAccount account) throws ClassNotFoundException,SQLException {
		jdbcTemplate.update("INSERT INTO ACCOUNT VALUES(?,?,?,?,?,?)",new Object[] { account.getBankAccount().getAccountNumber(),
				
		account.getBankAccount().getAccountHolderName(),account.getBankAccount().getAccountBalance(),account.isSalary(),null,"SA"});
		return null;
		
	}
	
	@Override
	public int deleteAccount(int accountNumber) throws ClassNotFoundException, SQLException {
		
		 
		    String query="DELETE FROM account WHERE account_id=?";  
		    return jdbcTemplate.update(query);  
	} 
	

	@Override
	public SavingsAccount getAccountByName(String accountHolderName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SavingsAccount> getAccountByBalance(double minmumBalance, double maximumBalance)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double checkAccountBalance(int accountNumber) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccount() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBalance(int accountNumber, double currentBalance) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SavingsAccount updateAccount(int accountNumber, int userChoice, String nameORSalary)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SavingsAccount> sortAllSavingsAccount(int choice) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public SavingsAccount updateAccount(SavingsAccount account) {
	 * jdbcTemplate.update("UPDATE ACCOUNT SET account_bal=? where account_id=?",new
	 * Object[] {SavingsAccountMapper.getAccountBalance(),
	 * SavingsAccountMapper,null}); return null; }
	 */

	@Override
	public SavingsAccount getAccountById(int accountNumber) throws ClassNotFoundException, SQLException {
		
		return null;
	}

	@Override
	public SavingsAccount updateAccount(SavingsAccount account) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
