package controller;

import models.Expense.Expense;
import models.Expense.ExpenseSplitType;
import models.Split.ExpenseSplitStrategy;
import models.Split.Split;
import models.Split.SplitStrategies.EqualSplitStrategy;
import models.Split.SplitStrategies.PercentageSplitStrategy;
import models.Split.SplitStrategies.UnequalSplitStrategy;
import models.User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){

        ExpenseSplitStrategy expenseSplit = switch (splitType) {
            case EQUAL -> new EqualSplitStrategy();
            case UNEQUAL -> new UnequalSplitStrategy();
            case PERCENTAGE -> new PercentageSplitStrategy();
            default -> throw new IllegalArgumentException("Invalid split type");
        };



        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(description,expenseId, paidByUser,expenseAmount, splitType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
    }
}
