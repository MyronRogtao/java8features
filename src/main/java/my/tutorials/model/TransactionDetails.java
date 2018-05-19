package my.tutorials.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetails {
    String type;
    String formattedAmount;
    String partiesInvolved;
}
