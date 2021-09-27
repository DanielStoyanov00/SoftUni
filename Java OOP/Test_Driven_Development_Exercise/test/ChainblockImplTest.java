import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private static final int VALID_ID_FOR_TEST = 4;
    private static final int INVALID_ID_FOR_TEST = 100;
    private static final String SENDER_FOR_TESTS = "Mitko";
    private static final String RECEIVER_FOR_TESTS = "Maria";
    private static final double MAX_AMOUNT_FOR_TEST = 12.00;
    private static final double MIN_AMOUNT_FOR_TEST = 10.00;
    private static final double INVALID_MIN_AMOUNT = 100;
    private static final double INVALID_MAX_AMOUNT = 200;

    private Chainblock chainblock;
    private List<Transaction> transactionList;
    private Transaction defaultTransaction;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.setTransactionList();
        this.defaultTransaction = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Dog", "Cat", 9.99);
    }

    private void setTransactionList() {
        this.transactionList = List.of(
                new TransactionImpl(2, TransactionStatus.FAILED, "Kate", "Sof", 10.00),
                new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Mitko", "Maria", 11.00),
                new TransactionImpl(7, TransactionStatus.SUCCESSFUL, "Mitko", "Maria", 11.00),
                new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Olq", "Dani", 12.00),
                new TransactionImpl(5, TransactionStatus.ABORTED, "Georgi", "Stoqn", 13.00),
                new TransactionImpl(6, TransactionStatus.UNAUTHORIZED, "Gosho", "Pesho", 14.00)
        );
    }

    // contains methods
    @Test
    public void testContainMethodsShouldReturnTrueOrFalseIfTransactionIsPresentOrNot() {
        assertFalse(chainblock.contains(defaultTransaction));
        chainblock.add(defaultTransaction);
        assertTrue(chainblock.contains(defaultTransaction));
    }

    // add
    @Test
    public void testAddShouldAddTransactionIfItsMissingFromTheCollection() {
        chainblock.add(defaultTransaction);
        assertTrue(chainblock.contains(defaultTransaction));
    }

    @Test
    public void testAddShouldNotAddTransactionIfItsPresentInTheCollection() {
        chainblock.add(defaultTransaction);
        chainblock.add(defaultTransaction);
        assertEquals(1, chainblock.getCount());
    }

    // changeTransactionStatusById
    @Test
    public void testChangeTransactionStatusByIdShouldChangeStatusByGivenStatusIfIdIsPresent() {
        Transaction transaction = defaultTransaction;
        chainblock.add(transaction);

        chainblock.changeTransactionStatus(VALID_ID_FOR_TEST, TransactionStatus.FAILED);

        assertEquals(TransactionStatus.FAILED, transaction.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusByIdShouldThrowExceptionIfIdIsNotPresent() {
        chainblock.changeTransactionStatus(INVALID_ID_FOR_TEST, TransactionStatus.ABORTED);
    }

    // removeTransactionById
    @Test
    public void testRemoveTransactionByIdShouldRemoveTransactionWithTheGivenIdIfItsPresent() {
        Transaction transaction = defaultTransaction;

        chainblock.add(transaction);
        assertEquals(1, chainblock.getCount());

        chainblock.removeTransactionById(VALID_ID_FOR_TEST);
        assertEquals(0, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdShouldThrowExceptionIfIdIsInvalid() {
        chainblock.removeTransactionById(INVALID_ID_FOR_TEST);
    }

    // getById
    @Test
    public void testGetByIdShouldReturnTheTransactionWithGivenId() {
        chainblock.add(defaultTransaction);

        Transaction byId = chainblock.getById(VALID_ID_FOR_TEST);

        assertEquals(byId, defaultTransaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdShouldThrowExceptionIfTheGivenIdIsInvalid() {
        chainblock.getById(INVALID_ID_FOR_TEST);
    }

    // getByTransactionStatus
    @Test
    public void testGetByTransactionStatusShouldReturnTransactionsWithTheGivenStatus() {
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<Transaction> expected = transactionList
                .stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> byStatus = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(byStatus);

        List<Transaction> filteredByStatus = new ArrayList<>();
        byStatus.forEach(filteredByStatus::add);

        assertEquals(expected.size(), filteredByStatus.size());
        filteredByStatus.forEach(tr -> assertEquals(TransactionStatus.SUCCESSFUL, tr.getStatus()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusShouldThrowExceptionIfSuchNoTransactionWithGivenStatus() {
        chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    // getAllSendersWithTransactionStatus
    @Test
    public void testGetAllSendersWithTransactionStatusShouldReturnSendersWithGivenStatus() {
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<String> expected = transactionList
                .stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        Iterable<String> allSendersWithTransactionStatus = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(allSendersWithTransactionStatus);

        List<String> result = new ArrayList<>();
        allSendersWithTransactionStatus.forEach(result::add);

        assertEquals(expected.size(), result.size());

        int index = 0;
        for (String sender : expected) {
            assertEquals(sender, result.get(index++));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusShouldThrowExceptionIfStatusDoesntExist() {
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    // getAllReceiversWithTransactionStatus
    @Test
    public void testGetAllReceiversWithTransactionStatusShouldReturnReceiversWithGivenStatus() {
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<String> expected = transactionList
                .stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        Iterable<String> allReceiversWithTransactionStatus = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(allReceiversWithTransactionStatus);

        List<String> result = new ArrayList<>();
        allReceiversWithTransactionStatus.forEach(result::add);

        assertEquals(expected.size(), result.size());

        int index = 0;
        for (String receiver : expected) {
            assertEquals(receiver, result.get(index++));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusShouldThrowExceptionIfStatusDoesntExist() {
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    // getAllOrderedByAmountDescendingThenById
    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdShouldReturnAllTransactionsByAmountInDescendingOrder() {
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<Transaction> expected = transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getAllOrderedByAmountDescendingThenById();
        assertNotNull(iterable);
        List<Transaction> result = new ArrayList<>();
        iterable.forEach(result::add);

        assertEquals(expected.size(), result.size());

        int index = 0;
        for (Transaction transaction : expected) {
            assertEquals(transaction, result.get(index++));
        }
    }

    // getBySenderOrderedByAmountDescending
    @Test
    public void testGetBySenderOrderedByAmountDescendingShouldReturnAllTransactionsByGivenSenderOrderedByAmountInDescendingOrder() {
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<Transaction> expected = transactionList.stream()
                .filter(t -> t.getFrom().equals(SENDER_FOR_TESTS))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getBySenderOrderedByAmountDescending(SENDER_FOR_TESTS);
        assertNotNull(iterable);
        List<Transaction> result = new ArrayList<>();
        iterable.forEach(result::add);

        assertEquals(expected.size(), result.size());

        int index = 0;
        for (Transaction transaction : expected) {
            assertEquals(transaction, result.get(index++));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingShouldThrowExceptionIfSuchNoSender(){
        chainblock.getBySenderOrderedByAmountDescending(SENDER_FOR_TESTS);
    }

    // getByReceiverOrderedByAmountThenById
    @Test
    public void getByReceiverOrderedByAmountThenByIdShouldReturnAllTransactionsWithGiverReceiver(){
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<Transaction> expected = transactionList.stream()
                .filter(t -> t.getTo().equals(RECEIVER_FOR_TESTS))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> byReceiver = chainblock.getByReceiverOrderedByAmountThenById(RECEIVER_FOR_TESTS);
        assertNotNull(byReceiver);

        List<Transaction> result = new ArrayList<>();
        byReceiver.forEach(result::add);

        assertEquals(expected.size(),result.size());

        int index = 0;
        for (Transaction transaction : expected) {
            assertEquals(transaction,result.get(index++));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByIdShouldThrowExceptionIfGivenReceiverNotMatch(){
        chainblock.getByReceiverOrderedByAmountThenById(RECEIVER_FOR_TESTS);
    }

    // getByTransactionStatusAndMaximumAmount
    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnAllTransactionsWithGivenStatusAndAmountBelowTheGivenOne(){
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<Transaction> expected = transactionList.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL) && t.getAmount() <= MAX_AMOUNT_FOR_TEST)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, MAX_AMOUNT_FOR_TEST);
        assertNotNull(iterable);

        List<Transaction> result = new ArrayList<>();
        iterable.forEach(result::add);

        assertEquals(expected.size(),result.size());

        int index = 0;
        for (Transaction transaction : expected) {
            assertEquals(transaction, result.get(index++));
        }
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionIfNoMatches(){
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<Transaction> expected = transactionList.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.UNAUTHORIZED) && t.getAmount() <= MAX_AMOUNT_FOR_TEST)
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, MAX_AMOUNT_FOR_TEST);
        assertNotNull(result);

        assertEquals(result, expected);
    }

    // getBySenderAndMinimumAmountDescending
    @Test
    public void testGetBySenderAndMinimumAmountDescendingShouldReturnAllTransactionsByGivenSenderAndMinimumAmountInDescendingOrder(){
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<Transaction> expected = transactionList
                .stream()
                .filter(t -> t.getFrom().equals(SENDER_FOR_TESTS) && t.getAmount() > MIN_AMOUNT_FOR_TEST)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getBySenderAndMinimumAmountDescending(SENDER_FOR_TESTS, MIN_AMOUNT_FOR_TEST);
        assertNotNull(iterable);
        List<Transaction> result = new ArrayList<>();
        iterable.forEach(result::add);

        assertEquals(expected.size(),result.size());

        int index = 0;
        for (Transaction transaction : expected) {
            assertEquals(transaction, result.get(index++));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingShouldThrowExceptionIfThereAreNoMatches(){
        chainblock.getBySenderAndMinimumAmountDescending(SENDER_FOR_TESTS,MIN_AMOUNT_FOR_TEST);
    }

    // getByReceiverAndAmountRange
    @Test
    public void testGetByReceiverAndAmountRangeShouldReturnTransactionsWhichPassesGivenConditions(){
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<Transaction> expected = transactionList
                .stream()
                .filter(t -> t.getTo().equals(RECEIVER_FOR_TESTS) && t.getAmount() >= MIN_AMOUNT_FOR_TEST && t.getAmount() < MAX_AMOUNT_FOR_TEST)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparing(Transaction::getId).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getByReceiverAndAmountRange(RECEIVER_FOR_TESTS, MIN_AMOUNT_FOR_TEST, MAX_AMOUNT_FOR_TEST);
        assertNotNull(iterable);
        List<Transaction> result = new ArrayList<>();
        iterable.forEach(result::add);

        assertEquals(expected.size(),result.size());

        int index = 0;
        for (Transaction transaction : expected) {
            assertEquals(transaction, result.get(index++));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowExceptionIfTransactionsNotPassesGivenConditions(){
        chainblock.getByReceiverAndAmountRange(RECEIVER_FOR_TESTS,MIN_AMOUNT_FOR_TEST,MAX_AMOUNT_FOR_TEST);
    }

    // getAllInAmountRange
    @Test
    public void testGetAllInAmountRangeShouldReturnTransactionsBetweenGivenRange(){
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<Transaction> expected = transactionList
                .stream()
                .filter(t -> t.getAmount() >= MIN_AMOUNT_FOR_TEST && t.getAmount() <= MAX_AMOUNT_FOR_TEST)
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getAllInAmountRange(MIN_AMOUNT_FOR_TEST, MAX_AMOUNT_FOR_TEST);
        assertNotNull(iterable);
        List<Transaction> result = new ArrayList<>();
        iterable.forEach(result::add);

        assertEquals(expected,result);
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnEmptyCollectionIfNoMatches(){
        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        List<Transaction> expected = transactionList
                .stream()
                .filter(t -> t.getAmount() >= INVALID_MIN_AMOUNT && t.getAmount() <= INVALID_MAX_AMOUNT)
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getAllInAmountRange(INVALID_MIN_AMOUNT, INVALID_MAX_AMOUNT);
        assertNotNull(result);

        assertEquals(expected,result);
    }
}


