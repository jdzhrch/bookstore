package model;


public class Statistic {
	private String criteria;
	private int number;
	private int amount;
	
	public Statistic(){}
	
	public Statistic(String criteria, int number, int amount) {
		super();
		this.criteria = criteria;
		this.number = number;
		this.amount = amount;
	}
	
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
