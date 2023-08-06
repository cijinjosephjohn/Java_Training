
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bank {
    Map<String, Customer> cust_id = new HashMap<>();

    public Bank() {

    }

    public void create_customer_account(String name, String date) {
        if (cust_id.containsKey(name + date)) {
            System.out.println("creating a new account for existing customer");
            Customer c = cust_id.get(name + date);
            c.create_new_account();
            System.out.println("old customer");
        } else {
            System.out.println("creating a new account for new customer ");
            Customer c = new Customer(name, date, "abc");
            c.create_new_account();
            System.out.println("new customer");
            cust_id.put(name + date, c);
        }

    }

    public void customer_details() {
        for (String key : cust_id.keySet()) {
            cust_id.get(key).show_account_list();
        }
    }

    public void transaction_credit(String name, String dob, String acno) {
        try {
            Customer c = cust_id.get(name + dob);
            c.deposit(acno, 1000);
        } catch (Exception e) {
            System.out.println("there is no account");
        }
    }

    public void transaction_debit(String name, String dob, String acno) {
        try {
            Customer c = cust_id.get(name + dob);
            c.withdraw(acno, 100);
        } catch (Exception e) {
            System.out.println("there is no account ");
        }
    }

    public void cust_balance(String name, String dob, String acno) {
        try {
            Customer c = cust_id.get(name + dob);
            double ans = c.acc_bal(acno);
            System.out.println("Balance : " + ans);
        } catch (Exception e) {
            System.out.println("there is no customer like this");
        }
    }

    public void update_cust_add(String name, String dob, String new_add) {
        try {
            Customer c = cust_id.get(name + dob);
            c.cust_add = new_add;
            System.out.println("address updated");
            System.out.println("updated address " + c.cust_add);
        } catch (Exception e) {
            System.out.println("no account");
        }
    }

    public void customer_with_more_than_one_account() {
        Predicate<Customer> more_than_one_ac = (e) -> e.accountList.size() >= 2;

        List<Customer> ans1 = cust_id.values().stream().filter(more_than_one_ac).collect(Collectors.toList());
        ans1.forEach(System.out::println);

    }

    public void customer_more_than_1500() {
        Predicate<Account> more_than_1500 = (e) -> e.amount >= 1500;
        List<Collection<Account>> ans = cust_id.values().stream().map((e) -> e.accountList.values())
                .collect(Collectors.toList());
        List<Account> an2 = ans.stream().flatMap(Collection::stream).filter(more_than_1500)
                .collect(Collectors.toList());
        an2.forEach(System.out::println);
    }

    public void customer_more_than_1500_in_both() {
        Predicate<Customer> customer_more_than_1500_total = (e) -> e.total_bal() > 1500;
        List<Customer> ans2 = cust_id.values().stream().filter(customer_more_than_1500_total)
                .collect(Collectors.toList());
        ans2.forEach(System.out::println);
    }

}
