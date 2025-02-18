package questions.paymentGateway.banks;

import questions.paymentGateway.methods.IPaymentMethod;
import questions.paymentGateway.methods.PaymentMethodManager;
import questions.paymentGateway.methods.PaymentRequest;
import questions.paymentGateway.payment.IPaymentOrder;
import questions.paymentGateway.payment.PaymentOrder;
import questions.paymentGateway.payment.PaymentOrderStatus;

import java.util.*;

public class BankingPartner implements IBankingPartner {
  private UUID bankingPartnerUUID;
  private String bankingPartnerName;
  private PaymentMethodManager paymentMethodManager;
  private List<IPaymentOrder> paymentOrders;
  private Long successfulPaymentCount;
  private Long totalPaymentCount;

  private static List<PaymentOrderStatus> possiblePaymentStatuses = Arrays.asList(PaymentOrderStatus.SUCCESS, PaymentOrderStatus.FAILURE, PaymentOrderStatus.PENDING);

  public BankingPartner(String bankingPartnerName) {
    bankingPartnerUUID = UUID.randomUUID();

    this.bankingPartnerName = bankingPartnerName;
    this.paymentMethodManager = PaymentMethodManager.getInstance();
    this.paymentOrders = new ArrayList<>();
    successfulPaymentCount = 0L;
    totalPaymentCount = 0L;
  }

  @Override
  public IPaymentOrder initiatePayment(PaymentRequest request) {
    IPaymentOrder order = new PaymentOrder(request);
    paymentOrders.add(order);
    totalPaymentCount += 1;

    return order;
  }

  @Override
  public PaymentOrderStatus processPayment(IPaymentOrder paymentOrder) {
    Random random = new Random();
    IPaymentMethod paymentProcessor = paymentMethodManager.getAppropriatePaymentMethod(paymentOrder.getPaymentRequest());
    paymentProcessor.processPayment(paymentOrder.getPaymentRequest());
    int index = random.nextInt(possiblePaymentStatuses.size());

    PaymentOrderStatus status = paymentOrder.updatePaymentOrderStatus(possiblePaymentStatuses.get(index));

    if (status == PaymentOrderStatus.SUCCESS) {
      successfulPaymentCount += 1;
    }

    return status;
  }

  @Override
  public boolean cancelPayment(UUID paymentOrderId) {
    Optional<IPaymentOrder> paymentOrder = paymentOrders.stream().filter(po -> po.getPaymentOrderIdentifier() == paymentOrderId).findFirst();
    if (paymentOrder.isPresent()) {
      paymentOrder.get().updatePaymentOrderStatus(PaymentOrderStatus.CANCELLED);
      return true;
    }

    return false; // Invalid paymentOrderId
  }

  @Override
  public void addPaymentMethod(IPaymentMethod IPaymentMethod) {
    paymentMethodManager.addPaymentMethod(IPaymentMethod);
  }

  @Override
  public void removePaymentMethod(IPaymentMethod IPaymentMethod) {
    paymentMethodManager.removePaymentMethod(IPaymentMethod);
  }

  @Override
  public List<IPaymentMethod> getAllSupportedPaymentMethods() {
    return paymentMethodManager.getAllSupportedPaymentMethods();
  }

  @Override
  public double getSuccessRate() {
    return (successfulPaymentCount/totalPaymentCount)*100.0;
  }
}
