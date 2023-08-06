
public class Account{
    String type,ac_no,acc_det,acc_holder;
    double amount;


    Account(String t,String ano,String name){
        this.type=t;
        this.ac_no=ano;
        this.acc_holder = name;
    }
    public void credit_transaction(double amt){
        this.amount +=amt;
    }
    public void debit_transaction(double amt){
        this.amount -=amt;
    }
    public double balance(){
        return this.amount;
    }
    @Override
    public String toString(){
        return this.ac_no +" "+this.acc_holder;
    }



}
