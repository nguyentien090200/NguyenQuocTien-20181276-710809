package entity.payment;

/**
 * 
 * @author Tran The Lam
 *
 */
public class DomesticCreditCard extends PaymentCard{	
	protected String owner;
	protected String dateExpired;
	private String bank;
	private String cardNumber;
	
	public DomesticCreditCard(String bank, String owner, String cardNumber, String dateExpired) {
		this.owner = owner;
		this.dateExpired = dateExpired;
		this.bank = bank;
		this.cardNumber = cardNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
