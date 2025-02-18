package questions.paymentGateway.banks;

import java.util.ArrayList;
import java.util.List;

public class BankingPartnerManager {
  private static BankingPartnerManager bankingPartnerManager;

  private List<IBankingPartner> IBankingPartners;

  private BankingPartnerManager() {
    IBankingPartners = new ArrayList<>();
  }

  public static BankingPartnerManager getInstance() {
    if (bankingPartnerManager == null)
      bankingPartnerManager = new BankingPartnerManager();

    return bankingPartnerManager;
  }

  public void addBankingPartner(IBankingPartner IBankingPartner) {
    IBankingPartners.add(IBankingPartner);
  }

  public void removeBankingPartner(IBankingPartner IBankingPartner) {
    IBankingPartners.remove(IBankingPartner);
  }
}
