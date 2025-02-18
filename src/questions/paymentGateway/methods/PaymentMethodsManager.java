package questions.paymentGateway.methods;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodsManager {
  private static PaymentMethodsManager paymentMethodsManager;
  private List<IPaymentMethod> IPaymentMethods;

  public PaymentMethodsManager() {
    IPaymentMethods = new ArrayList<>();
  }

  public void addPaymentMethod(IPaymentMethod IPaymentMethod) {
    IPaymentMethods.add(IPaymentMethod);
  }

  public void removePaymentMethod(IPaymentMethod IPaymentMethod) {
    IPaymentMethods.remove(IPaymentMethod);
  }

  public boolean isPaymentMethodSupported(IPaymentMethod IPaymentMethod) {
    return IPaymentMethods.contains(IPaymentMethod);
  }

  public List<IPaymentMethod> getAllSupportedPaymentMethods() {
    return IPaymentMethods;
  }
}
