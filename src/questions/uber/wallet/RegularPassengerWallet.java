package questions.uber.wallet;

public class RegularPassengerWallet implements PassengerWallet {
  private Double balance;

  public RegularPassengerWallet() {
    balance = 0.0;
  }

  @Override
  public void recharge(Double amount) {
    balance += amount;
  }

  @Override
  public void pay(Double amount) {
    if (amount > balance)
      throw new IllegalStateException("Only "+amount+" is available in your wallet.");

    balance -= amount;
  }

}
