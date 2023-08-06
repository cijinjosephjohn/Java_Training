// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Bank b1 = new Bank();
        b1.create_customer_account("john","13-13-13");
        b1.create_customer_account("john1","13-13-13");
        b1.create_customer_account("john2","13-13-13");
        b1.create_customer_account("john2","13-13-13");
        b1.customer_details();
        System.out.println("Credit");
        Scanner scan = new Scanner(System.in);
        System.out.print("john's Account No : ");
        String s=scan.nextLine();
        System.out.println();
        b1.transaction_credit("john","13-13-13",s);
        System.out.print("john1's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.transaction_credit("john1","13-13-13",s);
        System.out.print("john2's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.transaction_credit("john2","13-13-13",s);
        System.out.print("john's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.transaction_credit("john","13-13-13",s);
        System.out.print("john1's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.transaction_credit("john1","13-13-13",s);
        System.out.print("john2's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.transaction_credit("john2","13-13-13",s);

        System.out.println("Debit");
        System.out.print("john's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.transaction_debit("john","13-13-13",s);
        System.out.print("john1's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.transaction_debit("john1","13-13-13",s);
        System.out.print("john2's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.transaction_debit("john2","13-13-13",s);

        System.out.println("balance");
        System.out.print("john's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.cust_balance("john","13-13-13",s);
        System.out.print("john1's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.cust_balance("john1","13-13-13",s);
        System.out.print("john2's Account No : ");
        s=scan.nextLine();
        System.out.println();
        b1.cust_balance("john2","13-13-13",s);

        System.out.println("update cust address");
        b1.update_cust_add("john","13-13-13","New Orleans");
        System.out.println("customers with more than one account");
        b1.customer_with_more_than_one_account();
        System.out.println("customer with more than 1500 in one account");
        b1.customer_more_than_1500();
        System.out.println("customer with more than 1500 in total ");
        b1.customer_more_than_1500_in_both();
    }
}