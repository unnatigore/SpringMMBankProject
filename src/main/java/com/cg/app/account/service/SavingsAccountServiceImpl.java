package com.cg.app.account.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.cg.app.account.SavingsAccount;
import com.cg.app.account.dao.SavingsAccountDAO;
import com.cg.app.account.dao.SavingsAccountDAOImpl;
import com.cg.app.account.factory.AccountFactory;
import com.cg.app.account.util.DBUtil;
import com.cg.app.exception.AccountNotFoundException;
import com.cg.app.exception.InsufficientFundsException;
import com.cg.app.exception.InvalidInputException;

public class SavingsAccountServiceImpl implements SavingsAccountService {

	private AccountFactory factory;
	private SavingsAccountDAO savingsAccountDAO;

	public SavingsAccountServiceImpl() {
		factory = AccountFactory.getInstance();
		savingsAccountDAO = new SavingsAccountDAOImpl();
	}

	@Override
	public SavingsAccount createNewAccount(String accountHolderName,
			double accountBalance, boolean salary)
			throws ClassNotFoundException, SQLException {
		SavingsAccount account = factory.createNewSavingsAccount(
				accountHolderName, accountBalance, salary);
		savingsAccountDAO.createNewAccount(account);
		return null;
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccount()
			throws ClassNotFoundException, SQLException {
		return savingsAccountDAO.getAllSavingsAccount();
	}

	@Override
	public void deposit(SavingsAccount account, double amount)
			throws ClassNotFoundException, SQLException {
		if (amount > 0) {
			double currentBalance = account.getBankAccount()
					.getAccountBalance();
			currentBalance += amount;
			savingsAccountDAO.updateBalance(account.getBankAccount()
					.getAccountNumber(), currentBalance);
			// savingsAccountDAO.commit();
		} else {
			throw new InvalidInputException("Invalid Input Amount!");
		}
	}

	@Override
	public void withdraw(SavingsAccount account, double amount)
			throws ClassNotFoundException, SQLException {
		double currentBalance = account.getBankAccount().getAccountBalance();
		if (amount > 0 && currentBalance >= amount) {
			currentBalance -= amount;
			savingsAccountDAO.updateBalance(account.getBankAccount()
					.getAccountNumber(), currentBalance);
			// savingsAccountDAO.commit();
		} else {
			throw new InsufficientFundsException(
					"Invalid Input or Insufficient Funds!");
		}
	}

	@Override
	public void fundTransfer(SavingsAccount sender, SavingsAccount receiver,
			double amount) throws ClassNotFoundException, SQLException {
		try {
			withdraw(sender, amount);
			deposit(receiver, amount);
			DBUtil.commit();
		} catch (InvalidInputException | InsufficientFundsException e) {
			e.printStackTrace();
			DBUtil.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollback();
		}
	}

	
	@Override
	public SavingsAccount getAccountById(int accountNumber)
			throws ClassNotFoundException, SQLException{
		return savingsAccountDAO.getAccountById(accountNumber);
	}

	@Override
	public SavingsAccount getAccountByName(String accountHolderName)
			throws ClassNotFoundException, SQLException {

		return savingsAccountDAO.getAccountByName(accountHolderName);
	}

	@Override
	public int deleteAccount(int accountNumber)
			throws ClassNotFoundException, SQLException {

		return savingsAccountDAO.deleteAccount(accountNumber);
	}

	@Override
	public double checkAccountBalance(int accountNumber)
			throws ClassNotFoundException,
			SQLException {
		return savingsAccountDAO.checkAccountBalance(accountNumber);
	}

	@Override
	public List<SavingsAccount> getAccountByBalance(double minmumBalance,
			double maximumBalance) throws ClassNotFoundException, SQLException {

		return savingsAccountDAO.getAccountByBalance(minmumBalance,
				maximumBalance);
	}

	

	@Override
	public SavingsAccount updateAccount(int accountNumber, int userChoice,
			String nameORSalary) throws ClassNotFoundException, SQLException {
		return savingsAccountDAO.updateAccount(accountNumber, userChoice,
				nameORSalary);
	}

	@Override
	public List<SavingsAccount> sortAllSavingsAccount(int choice)
			throws ClassNotFoundException, SQLException {
		return savingsAccountDAO.sortAllSavingsAccount(choice);
	}

	

	

}