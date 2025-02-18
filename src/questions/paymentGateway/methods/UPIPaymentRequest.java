package questions.paymentGateway.methods;

public class UPIPaymentRequest extends PaymentRequest {

  private String senderMobileNumber;
  private String receiverMobileNumber;

  public UPIPaymentRequest(String senderMobileNumber, String receiverMobileNumber, float paymentAmount) {
    super(paymentAmount);
    this.senderMobileNumber = senderMobileNumber;
    this.receiverMobileNumber = receiverMobileNumber;
  }

  public String getSenderMobileNumber() {
    return senderMobileNumber;
  }

  public void setSenderMobileNumber(String senderMobileNumber) {
    this.senderMobileNumber = senderMobileNumber;
  }

  public String getReceiverMobileNumber() {
    return receiverMobileNumber;
  }

  public void setReceiverMobileNumber(String receiverMobileNumber) {
    this.receiverMobileNumber = receiverMobileNumber;
  }
}
