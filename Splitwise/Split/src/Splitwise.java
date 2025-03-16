import controller.BalanceSheetController;
import controller.GroupController;
import controller.UserController;
import models.Expense.ExpenseSplitType;
import models.Group.Group;
import models.Split.Split;
import models.User.User;

import java.util.List;

public class Splitwise {
    public static  Splitwise instance;
    private final GroupController groupController;
    private final UserController userController;
    private final BalanceSheetController balanceSheetController;
    private  Splitwise(){
        userController= new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }
    public static Splitwise getInstance(){
        if(instance == null){
            synchronized (Splitwise.class){
                if(instance == null){
                    instance = new Splitwise();
                }
            }
        }
        return instance;
    }
    public void runSplitWise(){
        setUpUsersAndGroups();
        Group group = groupController.getGroup("G1001");
        group.addMember(userController.getUserById("U2001"));
        group.addMember(userController.getUserById("U3001"));
        group.createExpense(
                "Ex1001","Breakfast",900,
                List.of(
                        new Split(userController.getUserById("U1001"),300),
                        new Split(userController.getUserById("U2001"),300),
                        new Split(userController.getUserById("U3001"),300)
                ),
                ExpenseSplitType.EQUAL,
                userController.getUserById("U1001")
        );
        group.createExpense(
                "Exp1002", "Lunch", 500,
                List.of(
                        new Split(userController.getUserById("U1001"), 400), // Alice
                        new Split(userController.getUserById("U2001"), 100)  // Bob
                ),
                ExpenseSplitType.UNEQUAL,
                userController.getUserById("U2001") // Bob created the expense
        );
        //display balance sheet
        for(User user: userController.getAllUsers()){
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }
    private void setUpUsersAndGroups(){
        registerUsers();
        groupController.createNewGroup("G1001","Home",userController.getUserById("U1001"));
    }
    private void registerUsers(){
        userController.addUser(new User("Amitesh","U1001"));
        userController.addUser(new User("Aniket","U2001"));
        userController.addUser(new User("Siddharth","U3001"));
    }
}
