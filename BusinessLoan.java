
public class BusinessLoan extends Loan {

	public BusinessLoan(int loanNumber, String customerName, int loanAmount, int term, double primeRate) {
		setLoanNumber(loanNumber);
		setCustomerName(customerName);
		setLoanAmount(loanAmount);
		setTerm(term);
		interestRate = (double)((primeRate * 0.01) + primeRate);
		setInterestRate(interestRate);
	}

	@Override
	public String toString() {
		return "BusinessLoan [loanNumber=" + loanNumber + ", customerName=" + customerName + ", loanAmount=$"
				+ loanAmount + "k, interestRate=" + interestRate + ", term=" + term + "]";
	}
	
}
