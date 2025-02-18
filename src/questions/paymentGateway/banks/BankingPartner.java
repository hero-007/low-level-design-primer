package questions.paymentGateway.banks;

import questions.paymentGateway.methods.IPaymentMethod;
import questions.paymentGateway.methods.PaymentMethodsManager;
import questions.paymentGateway.payment.IPaymentOrder;
import questions.paymentGateway.payment.PaymentOrder;
import questions.paymentGateway.payment.PaymentOrderStatus;

import java.util.*;

public class BankingPartner implements IBankingPartner {
  private UUID bankingPartnerUUID;
  private String bankingPartnerName;
  private PaymentMethodsManager paymentMethodsManager;
  private List<IPaymentOrder> paymentOrders;
  private Long successfulPaymentCount;
  private Long totalPaymentCount;

  private static List<PaymentOrderStatus> possiblePaymentStatuses = Arrays.asList(PaymentOrderStatus.SUCCESS, PaymentOrderStatus.FAILURE, PaymentOrderStatus.PENDING);

  public BankingPartner(String bankingPartnerName) {
    bankingPartnerUUID = UUID.randomUUID();

    this.bankingPartnerName = bankingPartnerName;
    this.paymentMethodsManager = new PaymentMethodsManager();
    successfulPaymentCount = 0L;
    totalPaymentCount = 0L;
  }

  @Override
  public IPaymentOrder initiatePayment() {
    IPaymentOrder order = new PaymentOrder();
    paymentOrders.add(order);
    totalPaymentCount += 1;

    return order;
  }

  @Override
  public PaymentOrderStatus processPayment(IPaymentOrder paymentOrder) {
    Random random = new Random();
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
    paymentMethodsManager.addPaymentMethod(IPaymentMethod);
  }

  @Override
  public void removePaymentMethod(IPaymentMethod IPaymentMethod) {
    paymentMethodsManager.removePaymentMethod(IPaymentMethod);
  }

  @Override
  public List<IPaymentMethod> getAllSupportedPaymentMethods() {
    return paymentMethodsManager.getAllSupportedPaymentMethods();
  }

  @Override
  public double getSuccessRate() {
    return (successfulPaymentCount/totalPaymentCount)*100.0;
  }
}
