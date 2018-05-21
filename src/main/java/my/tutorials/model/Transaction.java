package my.tutorials.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private TxnType type;
    private String source;
    private String destination;
    private Double amount;

    public Transaction(String source, Double amount) {
        this.type = TxnType.CREDIT;
        this.source = source;
        this.destination = "anonymous";
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction(type = "+ type.name() +", source = "+ source +", destination = "+ destination +", amount = "+ amount +")";
    }
}