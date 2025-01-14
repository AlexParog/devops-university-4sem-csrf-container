package ru.abibik.bankapiservice.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.abibik.bankapiservice.entity.Transaction;
import ru.abibik.bankapiservice.entity.Transfer;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    @Getter
    private Long totalAmount = 1000L;
    private final List<Transaction> transactions = new ArrayList<>(List.of(
            new Transaction("Buddy", "100", "Dining out")
    ));

    public List<Transaction> getRecentTransactions() {
        return transactions;
    }

    public void processTransfer(Transfer transfer) {
        int amount = Integer.parseInt(transfer.getAmount().replaceAll("\\D+", ""));
        transactions.add(new Transaction(transfer.getTo(), transfer.getAmount(), transfer.getNote()));
        totalAmount -= amount;
    }
}
