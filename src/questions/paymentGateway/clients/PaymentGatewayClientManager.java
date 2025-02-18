package questions.paymentGateway.clients;

import java.util.ArrayList;
import java.util.List;

public class PaymentGatewayClientManager {
  List<IPaymentGatewayClient> IPaymentGatewayClients;

  private static PaymentGatewayClientManager paymentGatewayClientManager;

  private PaymentGatewayClientManager() {
    IPaymentGatewayClients = new ArrayList<>();
  }

  public static PaymentGatewayClientManager getInstance() {
    if (paymentGatewayClientManager == null)
      paymentGatewayClientManager = new PaymentGatewayClientManager();

    return paymentGatewayClientManager;
  }

  public void addClient(IPaymentGatewayClient IPaymentGatewayClient) {
    IPaymentGatewayClients.add(IPaymentGatewayClient);
  }

  public void removeClient(IPaymentGatewayClient IPaymentGatewayClient) {
    IPaymentGatewayClients.remove(IPaymentGatewayClient);
  }

  public List<IPaymentGatewayClient> getAllClients() {
    return IPaymentGatewayClients;
  }
}
