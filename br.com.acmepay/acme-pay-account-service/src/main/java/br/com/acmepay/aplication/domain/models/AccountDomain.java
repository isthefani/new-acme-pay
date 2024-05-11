package br.com.acmepay.aplication.domain.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDomain {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;
    private Customer customer;
    private List<Card> cards;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private List<Account> accountsCreated = new ArrayList<>();


    public void create(Account account) {
        this.setId(account.id);
        this.setCreated_at(LocalDateTime.now());
        this.setUpdated_at(null);
        this.setCustomer(createCustomer());
        this.setCards(new ArrayList<>());
        this.setBalance(BigDecimal.ZERO);
        this.setNumber(account.number);
        this.setAgency(account.agency);
        this.setClose(account.close);
        this.accountsCreated.add(this);
    }

    public void deposit(BigDecimal amount){
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) >= 0){
            this.balance.subtract(amount);
        }else {
            throw new BalanceToWithdrawException("error withdraw");
        }

    }

    private Customer createCustomer(){
        var customer = new Customer();
        customer.setId(1L);
        customer.setName("Carlos Barbosa");
        customer.setEmail("carlos@gmail.com");
        customer.setDocument("03100721403");
        customer.setPhone("83991267778");
        customer.setCreated_at(LocalDateTime.now());
        customer.setUpdated_at(null);
        customer.setAccounts(new ArrayList<>());
        return customer;
    }
}
