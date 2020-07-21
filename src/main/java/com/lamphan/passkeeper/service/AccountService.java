package com.lamphan.passkeeper.service;

import com.lamphan.passkeeper.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    public Account getAccountByUsernameAndPassword(String username, String password);
    public List<Account> lsAllAccount();
}
