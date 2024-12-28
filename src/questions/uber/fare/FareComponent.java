package questions.uber.fare;

public class FareComponent {
  private FareComponentType type;
  private String description;
  private Double amountInRs;

  public FareComponent(FareComponentType type, Double amountInRs) {
    this.type = type;
    this.description = FareComponentDescription.get(type);
    this.amountInRs = amountInRs;
  }

  public FareComponentType getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public Double getAmountInRs() {
    return amountInRs;
  }
}
