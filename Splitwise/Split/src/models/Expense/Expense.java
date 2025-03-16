package models.Expense;

import models.Split.Split;
import models.User.User;

import java.util.List;

public class Expense {
    String description;
    private String expenseId;
    public User paidByuser;
    private double expenseAmount;
    ExpenseSplitType expenseSplitType;
    public List<Split> splits;

    public Expense(String description, String id, User paidByuser, double expenseAmount, ExpenseSplitType expenseSplitType, List<Split> splits) {
        this.description = description;
        this.expenseId = id;
        this.paidByuser = paidByuser;
        this.expenseAmount = expenseAmount;
        this.expenseSplitType = expenseSplitType;
        this.splits = splits;
    }
}
