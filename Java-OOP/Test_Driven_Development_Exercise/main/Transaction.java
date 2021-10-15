public interface Transaction {

    int getId();
    void setId(int id);

    TransactionStatus getStatus();
    void setStatus(TransactionStatus transactionStatus);

    String getFrom();
    void setFrom(String from);

    String getTo();
    void setTo(String to);

    double getAmount();
    void setAmount(double amount);

}
