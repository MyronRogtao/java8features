package my.tutorials.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    private TxnType type;
    private String source;
    private String destination;
    private Double amount;

    @Override
    public String toString() {
        return "\nTransaction(type = "+ type.name() +", source = "+ source +", destination = "+ destination +", amount = "+ amount +")";
    }
}