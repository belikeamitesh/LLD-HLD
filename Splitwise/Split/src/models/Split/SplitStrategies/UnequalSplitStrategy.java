package models.Split.SplitStrategies;

import models.Split.ExpenseSplitStrategy;
import models.Split.Split;

import java.util.List;

public class UnequalSplitStrategy implements ExpenseSplitStrategy {
    @Override
    public void validateSplitRequest(List<Split> splits, double amount){
        int sumAmount=0;
        for(Split split:splits){
            sumAmount+=split.getAmountOwe();
        }
        if(sumAmount!=amount){
            throw new IllegalArgumentException("Total amount does not match with splitted amount!");
        }
    }
}
