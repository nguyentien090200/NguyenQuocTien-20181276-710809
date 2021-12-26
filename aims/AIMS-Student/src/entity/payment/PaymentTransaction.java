package entity.payment;

public class PaymentTransaction {
	private String errorCode;
	private CreditCard card;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;
	
	public PaymentTransaction(String errorCode, CreditCard card, String transactionId, String transactionContent,
			int amount, String createdAt) {
		super();
		this.errorCode = errorCode;
		this.card = card;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	/**
	 * @author Tran The Lam
	 */
	
	@Override
	public String toString() {
		return "PaymentTransaction [errorCode=" + errorCode + ", card=" + card.toString() + ", transactionId="
				+ transactionId + ", transactionContent=" + transactionContent + ", amount=" + amount + ", createdAt="
				+ createdAt + "]";
	}
	
	/**
	 * Phuong thuc Getter va Setter
	 */

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}
