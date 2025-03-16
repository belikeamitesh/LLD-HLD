package models.Split.SplitStrategies;

import models.Split.ExpenseSplitStrategy;
import models.Split.Split;

import java.util.List;

public class PercentageSplitStrategy implements ExpenseSplitStrategy {
    @Override
    public void validateSplitRequest(List<Split> splits, double amount){
        int totalPercent=0;
        for(Split split:splits){
            totalPercent+=(int)split.getAmountOwe();
        }
        if(totalPercent!=amount){
            throw new IllegalArgumentException("Total percent should sum up to 100%!");
        }
    }
}
