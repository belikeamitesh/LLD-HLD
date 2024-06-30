package VendingMachinedesign;
public class Inventory {
    ItemShelf[] inventory = null;

    Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initializeEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initializeEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(false);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                if (itemShelf.soldOut) {
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("already item is present, You cannot add new item here.");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        Item gotItem = null;
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                if (!(itemShelf.soldOut)) {
                    gotItem = itemShelf.item;
                } else {
                    throw new Exception("item is sold out.");
                }
            }
        }
        return gotItem;
    }

    public void updateInventory(int codeNumber) throws Exception{
        System.out.println("update inventory successfully");
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                itemShelf.soldOut=true;
            }
        }
    }
}
