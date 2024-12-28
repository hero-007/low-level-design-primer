package questions.uber.wallet;

public class RegularDriverWallet implements DriverWallet {
  private Double balance;

  public RegularDriverWallet() {
    this.balance = 0.0;
  }

  @Override
  public void deposit(Double amount) {
    balance += amount;
  }

  @Override
  public void withdraw(Double amount) {
    if (amount > balance)
      throw new IllegalStateException("Only "+balance+" is available in your wallet.");
    balance -= amount;
  }
}
