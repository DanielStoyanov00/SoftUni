import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }


    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        if (!transactions.containsKey(transaction.getId())) {
            transactions.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        transactions.entrySet()
                .stream()
                .filter(t -> t.getKey() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getValue()
                .setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (transactions.containsKey(id)) {
            transactions.remove(id);
            return;
        }
        throw new IllegalArgumentException();
    }

    public Transaction getById(int id) {
        return transactions.entrySet()
                .stream()
                .filter(t -> t.getKey() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getValue();
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionsByStatus = transactions.entrySet()
                .stream()
                .filter(t -> t.getValue().getStatus().equals(status))
                .sorted((f, s) -> Double.compare(s.getValue().getAmount(), f.getValue().getAmount()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        if (transactionsByStatus.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return transactionsByStatus;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> sendersWithGivenStatus = transactions.entrySet()
                .stream()
                .filter(t -> t.getValue().getStatus().equals(status))
                .sorted((f, s) -> Double.compare(s.getValue().getAmount(), f.getValue().getAmount()))
                .map(m -> m.getValue().getFrom())
                .collect(Collectors.toList());

        if (sendersWithGivenStatus.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return sendersWithGivenStatus;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> receiversWithGivenStatus = transactions.entrySet()
                .stream()
                .filter(t -> t.getValue().getStatus().equals(status))
                .sorted((f, s) -> Double.compare(s.getValue().getAmount(), f.getValue().getAmount()))
                .map(m -> m.getValue().getTo())
                .collect(Collectors.toList());

        if (receiversWithGivenStatus.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return receiversWithGivenStatus;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactions.values()
                .stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparingInt(Transaction::getId).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> collect = transactions.values()
                .stream()
                .filter(t -> t.getFrom().equals(sender))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return collect;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> result = transactions.values()
                .stream()
                .filter(t -> t.getTo().equals(receiver))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> result = transactions.values()
                .stream()
                .filter(t -> t.getStatus().equals(status) && t.getAmount() <= amount)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (result.isEmpty()){
            return new ArrayList<>();
        }
        return result;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> result = transactions.values()
                .stream()
                .filter(t -> t.getFrom().equals(sender) && t.getAmount() > amount)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (result.isEmpty()){
            throw new IllegalArgumentException();
        }

        return result;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> result = transactions.values()
                .stream()
                .filter(t -> t.getTo().equals(receiver) && t.getAmount() >= lo && t.getAmount() < hi)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparing(Transaction::getId).reversed())
                .collect(Collectors.toList());

        if (result.isEmpty()){
            throw new IllegalArgumentException();
        }

        return result;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
       List<Transaction> result = transactions.values()
               .stream()
               .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
               .collect(Collectors.toList());

       if (result.isEmpty()){
           return new ArrayList<>();
       }
       return result;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
