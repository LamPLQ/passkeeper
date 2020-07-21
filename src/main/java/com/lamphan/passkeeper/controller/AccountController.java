package com.lamphan.passkeeper.controller;

import com.lamphan.passkeeper.entity.Account;
import com.lamphan.passkeeper.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import util.ResponseAPI;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;
    //AccountRepository accountRepository;

    @PostMapping(value = "/login")
    public ResponseEntity<?> getAccountByUsernameAndPassword(@RequestBody Account account) {
        try {
            if (account.getUsername().isEmpty() || account.getUsername().equals("") ||
                    account.getPassword().isEmpty() || account.getPassword().equals("")) {
                return new ResponseEntity<>(new ResponseAPI("You need to fill username and password",HttpStatus.BAD_REQUEST.toString()), HttpStatus.BAD_REQUEST);
            }
        } catch (NullPointerException nullPointerException) {
            logger.error("You need to fill username and password");
            return new ResponseEntity<>(new ResponseAPI("You need to fill username and password",HttpStatus.BAD_REQUEST.toString()),HttpStatus.BAD_REQUEST);
        }
        Optional<Account> accountProcess = Optional.ofNullable(accountService.getAccountByUsernameAndPassword(account.getUsername(), account.getPassword()));
        if (!accountProcess.isPresent()) {
            return new ResponseEntity<>(new ResponseAPI("Not match username/password", HttpStatus.OK.toString()), HttpStatus.OK);
        }
        return new ResponseEntity<>(accountProcess, HttpStatus.OK);
    }

    @GetMapping(value = "/list-all-account")
    public ResponseEntity<?> getAllAccount() {
        List<Account> lsAccount = new ArrayList<>();
        //try {
        lsAccount = accountService.lsAllAccount();
//        }catch (Exception e){
//            logger.error("There is no record for this function");
//        }
        return new ResponseEntity<>(lsAccount, HttpStatus.OK);
    }
}
