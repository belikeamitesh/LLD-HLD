package VendingMachinedesign;
public class Item {
    ItemType type;
    int price;
    public void setItemType(ItemType type){
        this.type = type;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public ItemType getType(){
        return type;
    }
    public int getPrice(){
        return price;
    }
}
