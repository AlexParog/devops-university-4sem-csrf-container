package ru.abibik.bankapiservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.abibik.bankapiservice.entity.Transaction;
import ru.abibik.bankapiservice.entity.Transfer;
import ru.abibik.bankapiservice.service.BankService;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BankController {

    private final BankService bankService;

    @GetMapping(path = {"/", "/home", "/transfer"})
    public String home(Model model) {
        model.addAttribute("totalAmount", bankService.getTotalAmount());
        model.addAttribute("recentTransactions", bankService.getRecentTransactions());
        return "home.html";
    }

    @PostMapping("/transfer")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> transfer(@RequestBody Transfer transferModel) {
        log.info("Transferring {} to {}. Note: {}", transferModel.getAmount(), transferModel.getTo(), transferModel.getNote());
        bankService.processTransfer(transferModel);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "balance", bankService.getTotalAmount(),
                "transactions", bankService.getRecentTransactions()
        ));
    }

    @GetMapping("/balance")
    @ResponseBody
    public ResponseEntity<Map<String, Long>> getBalance() {
        return ResponseEntity.ok(Map.of("totalAmount", bankService.getTotalAmount()));
    }

    @GetMapping("/transactions")
    @ResponseBody
    public ResponseEntity<List<Transaction>> getTransactions() {
        return ResponseEntity.ok(bankService.getRecentTransactions());
    }
}