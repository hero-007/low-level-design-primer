package questions.paymentGateway.methods;

public class UPIPaymentMethod implements IPaymentMethod {

  @Override
  public void processPayment(PaymentRequest request) {
    if (request instanceof UPIPaymentRequest) {
      double amount = request.getAmount();
      String senderNumber = ((UPIPaymentRequest) request).getSenderMobileNumber();
      String receiverNumber = ((UPIPaymentRequest) request).getReceiverMobileNumber();

      System.out.println("Processed payment request initiated by "+senderNumber+" for "+receiverNumber+". For Rs. "+amount);
    }
  }
}
