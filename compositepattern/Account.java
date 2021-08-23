package compositepattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

     public float accountBalance;
     List<Account> allAccounts = new ArrayList<Account>();

     public abstract float getBalance ();

     public void addAccount (Account account) {
         allAccounts.add(account);
     }
}
