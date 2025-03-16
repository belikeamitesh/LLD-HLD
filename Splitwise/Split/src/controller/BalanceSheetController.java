package controller;

import models.Balance.Balance;
import models.Balance.UserBalanceSheet;
import models.Split.Split;
import models.User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User payer, List<Split>splits,double totalExpense){
        UserBalanceSheet payersBalanceSheet = payer.getUserBalanceSheet();
        //update overall expense of payer- total spend by him
        payersBalanceSheet.setTotalPayment(payersBalanceSheet.getTotalPayment() + totalExpense);
        for(Split split:splits){
            User personWhoOwes = split.getUser();
            UserBalanceSheet owesSheet = personWhoOwes.getUserBalanceSheet();
            double amountToPay = split.getAmountOwe();
            if(payer.getUserId().equalsIgnoreCase(personWhoOwes.getUserId())){
                //if payer is involved - update his expense also
                payersBalanceSheet.setTotalYourExpense(payersBalanceSheet.getTotalYourExpense() + amountToPay);
            }else{
                payersBalanceSheet.setTotalYouGetBack(payersBalanceSheet.getTotalYouGetBack()+amountToPay);
                //store how much this person has to return to payer
                Balance payerBalance = payersBalanceSheet.getUserVsBalance().computeIfAbsent(personWhoOwes.getUserId(),k-> new Balance());
                payerBalance.setAmountGetBack(payerBalance.getAmountGetBack()+amountToPay);

                //update balance of person who owes the money
                owesSheet.setTotalYouOwe(owesSheet.getTotalYouOwe() + amountToPay);
                owesSheet.setTotalYourExpense(owesSheet.getTotalYourExpense() + amountToPay);

                Balance owesBalance = owesSheet.getUserVsBalance().computeIfAbsent(payer.getUserId(),k->new Balance());
                owesBalance.setAmountOwe(owesBalance.getAmountOwe()+amountToPay);
            }
        }
    }
    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserBalanceSheet userExpenseBalanceSheet =  user.getUserBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPayment());
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }
}
