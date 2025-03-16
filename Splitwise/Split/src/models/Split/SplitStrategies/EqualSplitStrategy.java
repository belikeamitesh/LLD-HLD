package models.Split.SplitStrategies;

import models.Split.ExpenseSplitStrategy;
import models.Split.Split;

import java.util.List;

public class EqualSplitStrategy implements ExpenseSplitStrategy {
    @Override
    public void validateSplitRequest(List<Split>splits,double amount){
        double amountToSplit = amount/splits.size();
        for(Split split:splits){
            if(split.getAmountOwe()!=amountToSplit){
                throw new IllegalArgumentException("Each person should have an equal split!");
            }
        }
    }
}
