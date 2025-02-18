package questions.paymentGateway.clients;

import java.util.ArrayList;
import java.util.List;

public class PaymentGatewayClientManager {
  List<PaymentGatewayClient> paymentGatewayClients;

  private static PaymentGatewayClientManager paymentGatewayClientManager;

  private PaymentGatewayClientManager() {
    paymentGatewayClients = new ArrayList<>();
  }

  public static PaymentGatewayClientManager getInstance() {
    if (paymentGatewayClientManager == null)
      paymentGatewayClientManager = new PaymentGatewayClientManager();

    return paymentGatewayClientManager;
  }

  public void addClient(PaymentGatewayClient paymentGatewayClient) {
    paymentGatewayClients.add(paymentGatewayClient);
  }

  public void removeClient(PaymentGatewayClient paymentGatewayClient) {
    paymentGatewayClients.remove(paymentGatewayClient);
  }

  public List<PaymentGatewayClient> getAllClients() {
    return paymentGatewayClients;
  }
}
