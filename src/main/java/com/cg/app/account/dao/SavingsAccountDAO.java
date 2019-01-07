package com.cg.app.account.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.cg.app.account.SavingsAccount;
import com.cg.app.exception.AccountNotFoundException;
@Repository
public interface SavingsAccountDAO {

	SavingsAccount createNewAccount(SavingsAccount account)
			throws ClassNotFoundException, SQLException;

	SavingsAccount updateAccount(SavingsAccount account);

	SavingsAccount getAccountById(int accountNumber)
			throws ClassNotFoundException, SQLException;

	int deleteAccount(int accountNumber)
			throws ClassNotFoundException, SQLException;

	SavingsAccount getAccountByName(String accountHolderName)
			throws ClassNotFoundException, SQLException;

	List<SavingsAccount> getAccountByBalance(double minmumBalance,
			double maximumBalance) throws ClassNotFoundException, SQLException;

	double checkAccountBalance(int accountNumber)
			throws  ClassNotFoundException,
			SQLException;

	List<SavingsAccount> getAllSavingsAccount() throws ClassNotFoundException,
			SQLException;

	void updateBalance(int accountNumber, double currentBalance)
			throws ClassNotFoundException, SQLException;

	SavingsAccount updateAccount(int accountNumber, int userChoice,
			String nameORSalary) throws ClassNotFoundException, SQLException;

	List<SavingsAccount> sortAllSavingsAccount(int choice)
			throws ClassNotFoundException, SQLException;
	
	void commit() throws SQLException;

	

}