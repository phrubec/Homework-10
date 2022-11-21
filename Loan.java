
public abstract class Loan implements LoanConstants {
	int loanNumber;
	String customerName;
	int loanAmount;
	double interestRate;
	int term;
	
	public Loan() {
		super();
	}

	public Loan(int loanNumber, String customerName, int loanAmount, int term) {
		super();
		this.loanNumber = loanNumber;
		this.customerName = customerName;
		this.loanAmount = loanAmount;
		this.term = term;
	}
	
	public int getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	// Customize loan amount
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		if (loanAmount > MAX_LOAN) {
			this.loanAmount = MAX_LOAN;
		}
		else {
			this.loanAmount = loanAmount;
		}
	}
	
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		if (term == 1) {
			this.term = SHORT;
		}
		else if (term == 3) {
			this.term = MEDIUM;
		}
		else if (term == 5) {
			this.term = LONG;
		}
		else {
			this.term = SHORT;
		}
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double r) {
		this.interestRate = r;
	}
	
	
}






