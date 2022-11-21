import java.awt.Component;
import java.util.ArrayList;
import javax.swing.*;
import java.text.DecimalFormat;

public class CreateLoans {

	public static void main(String[] args) {
		
		ArrayList<Object> Loans = new ArrayList<>();
		String windowInput;
		windowInput = JOptionPane.showInputDialog("Enter the prime interest rate");
		double primeRate = Double.parseDouble(windowInput);
			
		// Creating random loans
		for (int i = 0; i < 5; i++) {
			  JTextField loanField = new JTextField(5); 
		      JTextField customerField = new JTextField(10);
		      JTextField amountField = new JTextField(10);
		      JTextField termField = new JTextField(5);
		      JTextField typeField = new JTextField(5);

		      JPanel myPanel = new JPanel();
		      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		      myPanel.add(new JLabel("Loan Number:"));
		      myPanel.add(loanField);
		      myPanel.add(new JLabel(" "));
		      myPanel.add(new JLabel("Customer Name:"));
		      myPanel.add(customerField);
		      myPanel.add(new JLabel(" "));
		      myPanel.add(new JLabel("Loan Amount (under $500k)"));
		      myPanel.add(amountField);
		      myPanel.add(new JLabel(" "));
		      myPanel.add(new JLabel("Term in years (1, 3, 5)"));
		      myPanel.add(termField);
		      myPanel.add(new JLabel(" "));
		      myPanel.add(new JLabel("Loan Type (1=Business, 2=Personal)"));
		      myPanel.add(typeField);
		      
		      myPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		      int result = JOptionPane.showConfirmDialog(null, myPanel, 
		               "Loan Information", JOptionPane.OK_CANCEL_OPTION);
		      
		      if (result == JOptionPane.OK_OPTION) {
		    	  int ln = Integer.parseInt(loanField.getText());
		    	  int amount = Integer.parseInt(amountField.getText());
		    	  int term = Integer.parseInt(termField.getText());
		    	  int type = Integer.parseInt(typeField.getText());
		    	  String name = customerField.getText();
		    	  if (type == 1) {
		    		  Loans.add(new BusinessLoan(ln, name, amount, term, primeRate));  
		    	  }
		    	  else if (type == 2) {
		    		  Loans.add(new PersonalLoan(ln, name, amount, term, primeRate));
		    	  }
		    	  else {
		    		  JOptionPane.showMessageDialog(null, "Incorrect Loan Type");
		    		  i--;
		    	  }
		      } 
		      
		}// for loop
		DecimalFormat pTwo = new DecimalFormat("0.00");
		JTextArea outputArea = new JTextArea(20,40);
		outputArea.append("Loan #\tCustomer\tAmount\tYears\tRate\n");
		for(Object l: Loans) {
			if (l instanceof BusinessLoan) {
				int ln = ((BusinessLoan) l).getLoanNumber();
				String name = ((BusinessLoan) l).getCustomerName();
				int amount = ((BusinessLoan) l).getLoanAmount();
				String strAmount = "$" + amount +"k";
				int term = ((BusinessLoan) l).getTerm();
				double pR = ((BusinessLoan) l).getInterestRate();
				String strPR = pTwo.format(pR);
				
				outputArea.append(ln+"\t"+name+"\t"+strAmount+"\t"+term+"\t"+strPR+"\n");
			}
			else if(l instanceof PersonalLoan) {
				int ln = ((PersonalLoan) l).getLoanNumber();
				String name = ((PersonalLoan) l).getCustomerName();
				int amount = ((PersonalLoan) l).getLoanAmount();
				String strAmount = "$" + amount +"k";
				int term = ((PersonalLoan) l).getTerm();
				double pR = ((PersonalLoan) l).getInterestRate();
				String strPR = pTwo.format(pR);
				
				outputArea.append(ln+"\t"+name+"\t"+strAmount+"\t"+term+"\t"+strPR+"\n");
			}	
		} // for loop
		JOptionPane.showMessageDialog(null,  outputArea, "All Loans", JOptionPane.INFORMATION_MESSAGE);
	}// main

}
