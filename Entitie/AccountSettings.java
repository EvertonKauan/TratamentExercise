package Entitie;

import model.exceptions.DomainException;

public class AccountSettings {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	private Double amount;
	
	public AccountSettings() {
		
	}
	
	public AccountSettings(Integer number, String holder, Double balance, Double withdrawLimit, Double amount) {
		if (withdrawLimit < amount) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if (amount > balance) {
			throw new DomainException("Not enough balance");
		}
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
		this.amount = amount;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public double Withdraw(Double amount) {
		return balance - amount;
	}
	
	public void Deposit(Double amount) {
		if (withdrawLimit < amount) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if (amount > Withdraw(amount)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.amount = amount;
	}
	

}
