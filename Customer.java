import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Customer {
    Map<String,Account> accountList = new HashMap<>();
    String name,dob,cust_add;
    Customer(String n,String d,String add){
        this.name=n;
        this.dob=d;
        this.cust_add=add;


    }
    public void create_new_account(){
        System.out.println("creating  account");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the account No : ");
        String s = scan.nextLine();
        Account a = new Account("savings",s,this.name);
        System.out.println("Account created");
        accountList.put(a.ac_no,a);
    }
    public void show_account_list(){
        for(Account i:accountList.values()){
            System.out.print(this.name+" : ");
            System.out.println(i.ac_no);
        }
    }
    public void deposit(String a_no,double amount){
        try{
            Account a = accountList.get(a_no);
            a.credit_transaction(amount);
            System.out.println("amount added");
            System.out.println("your current balance : "+a.amount);
        }
        catch(Exception e){
            System.out.println("Invalid account number");
        }
    }
    public void withdraw(String a_no,double amount){
        try{
            Account a =accountList.get(a_no);
            a.debit_transaction(amount);
            System.out.println("amount withdraw");
            System.out.println("your current balance : "+a.amount);
        }
        catch(Exception e){
            System.out.println("invalid account number");
        }
    }
    public double acc_bal(String a_no){
        try{
            Account a = accountList.get(a_no);
            return a.balance();

        }
        catch(Exception e){
            System.out.println("invalid account number");
        }
        return 0;
    }
    @Override
    public String toString(){
        return "Name : "+this.name;
    }
    public double total_bal(){
        return accountList.values().stream().reduce(0.0,(a,e)->a+e.amount,(b,c)->b+c);
    }
}
