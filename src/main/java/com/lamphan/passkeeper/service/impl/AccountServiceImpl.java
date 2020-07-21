package com.lamphan.passkeeper.service.impl;

import com.lamphan.passkeeper.entity.Account;
import com.lamphan.passkeeper.repo.AccountRepository;
import com.lamphan.passkeeper.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccountByUsernameAndPassword(String username, String password) {
        Account findingAccount = new Account();
        try {
            findingAccount = accountRepository.findAccountByUsernameAndPassword(username,password);
        }catch (Exception ex){
            logger.trace(String.valueOf(ex.getStackTrace()));
        }
        return findingAccount;
    }

    @Override
    public List<Account> lsAllAccount() {
        List<Account> lsAccount = new ArrayList<>();
        try{
            lsAccount = accountRepository.listAllUser();
            System.out.println("test");
        }catch (Exception e){
            logger.error(String.valueOf(e.getStackTrace()));
        }
        System.out.println(lsAccount.get(0).getUsername());
        return lsAccount;
    }
}
