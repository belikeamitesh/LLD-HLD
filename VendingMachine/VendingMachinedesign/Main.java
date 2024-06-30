package VendingMachinedesign;

import VendingMachinedesign.Vendingstates.impl.State;

public  class  Main {
    public static void main(String args[]) {
        VendingMachine vendingmachine = new VendingMachine();
        try {
            System.out.println("|");
            System.out.println("Filling up the inventory");
            System.out.println("|");
            fillUpInventory(vendingmachine);
            displayInventory(vendingmachine);


            System.out.println("|");
            System.out.println("Clicking on InsertCoin button");
            System.out.println("|");
            State vendingMachineState = vendingmachine.getVendingMachineState();
            vendingMachineState.clickOnInsertCoinButton(vendingmachine);
            vendingMachineState = vendingmachine.getVendingMachineState();
            vendingMachineState.insertCoin(vendingmachine,Coin.TENRUPEE);
            vendingMachineState.insertCoin(vendingmachine,Coin.TWENTYRUPEE);


            System.out.println("|");
            System.out.println("Clicking on Product selection button");
            System.out.println("|");
            vendingMachineState.clickOnStartProductSelectionButton(vendingmachine);
            vendingMachineState = vendingmachine.getVendingMachineState();
            vendingMachineState.chooseProduct(vendingmachine,102);
            displayInventory(vendingmachine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if (i >= 0 && i <= 3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            } else if (i > 3 && i <= 5) {
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(7);
            } else if (i > 5 && i <= 7) {
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(11);
            } else {
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    public static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            System.out.println("Code Number: "+slots[i].code+" Item : "+slots[i].item.type+" Price: "+slots[i].item.getPrice()+" isAvailable: "+!(slots[i].soldOut));
        }
    }
}
