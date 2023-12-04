package main.java.ru.gb.examples.Example_4.Seminar.card;

public class PaymentForm {
    private CreditCard creditCard;

    public PaymentForm(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void pay(double amount) {
        creditCard.charge(amount);
    }
}
