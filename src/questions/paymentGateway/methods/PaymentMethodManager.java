package questions.paymentGateway.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentMethodManager {
  private static PaymentMethodManager paymentMethodManager;

  private List<IPaymentMethod> paymentMethods;

  private PaymentMethodManager() {
    paymentMethods = new ArrayList<>();
  }

  public static PaymentMethodManager getInstance() {
    if (paymentMethodManager == null)
      paymentMethodManager = new PaymentMethodManager();

    return paymentMethodManager;
  }

  public void addPaymentMethod(IPaymentMethod paymentMethod) {
    paymentMethods.add(paymentMethod);
  }

  public void removePaymentMethod(IPaymentMethod paymentMethod) {
    paymentMethods.remove(paymentMethod);
  }

  public boolean isPaymentMethodSupported(IPaymentMethod paymentMethod) {
    return paymentMethods.contains(paymentMethod);
  }

  public List<IPaymentMethod> getAllSupportedPaymentMethods() {
    return paymentMethods;
  }

  public IPaymentMethod getAppropriatePaymentMethod(PaymentRequest request) {
    if (request instanceof UPIPaymentRequest) {
      Optional<IPaymentMethod> t = paymentMethods.stream().filter(pp -> pp instanceof UPIPaymentMethod).findFirst();

      if (t.isPresent()) return t.get();
    }

    throw new IllegalArgumentException("Payment processor does not exist to process the request of this type");
  }
}
