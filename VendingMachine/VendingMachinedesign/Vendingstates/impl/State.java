package VendingMachinedesign.Vendingstates.impl;
import VendingMachinedesign.Coin;
import VendingMachinedesign.Item;
import VendingMachinedesign.VendingMachine;

import java.util.List;

public interface State {
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception;
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine)throws  Exception;
    public void chooseProduct(VendingMachine vendingMachine,int codeNumber)throws Exception;
    public void insertCoin(VendingMachine vendingMachine, Coin coin)throws Exception;
    public int getChange(int returnChangeMoney)throws  Exception;
    public Item dispenseProduct(VendingMachine vendingMachine,int codeNumber)throws Exception;
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception;
}
