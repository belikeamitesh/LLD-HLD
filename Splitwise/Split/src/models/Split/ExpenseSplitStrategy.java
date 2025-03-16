package models.Split;

import java.util.List;

public interface ExpenseSplitStrategy {
    public void validateSplitRequest(List<Split>splits,double expenseAmount);
}
