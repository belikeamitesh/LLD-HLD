package models.Group;

import controller.ExpenseController;
import models.Expense.Expense;
import models.Expense.ExpenseSplitType;
import models.Split.Split;
import models.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupId;
    public String groupName;
    List<User> groupMembers;
    List<Expense>expenses;
    ExpenseController expenseController;

    public Group(){
        groupMembers = new ArrayList<>();
        expenses = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public void addMember(User user){
        if(groupMembers.contains(user)){
            System.out.println("User already present in the group!");
        }else{
            groupMembers.add(user);
            System.out.println("User added to the group!");
        }
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<User> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split>splits, ExpenseSplitType expenseSplitType,User paidBy){
        Expense expense = expenseController.createExpense(expenseId,description,expenseAmount,splits,expenseSplitType,paidBy);
        expenses.add(expense);
        return  expense;
    }
}
