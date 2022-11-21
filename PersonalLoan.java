
public class PersonalLoan extends Loan {
	
	public PersonalLoan(int loanNumber, String customerName, int loanAmount, int term, double primeRate) {
		setLoanNumber(loanNumber);
		setCustomerName(customerName);
		setLoanAmount(loanAmount);
		setTerm(term);
		interestRate = (double)((primeRate * 0.02) + primeRate);
		setInterestRate(interestRate);
		
	}

	@Override
	public String toString() {
		return "PersonalLoan [loanNumber=" + loanNumber + ", customerName=" + customerName + ", loanAmount=$"
				+ loanAmount + "k, interestRate=" + interestRate + ", term=" + term + "]";
	}

}
