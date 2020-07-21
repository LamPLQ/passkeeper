package com.lamphan.passkeeper.repo;

import com.lamphan.passkeeper.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    //Account findAccountByUsernameAndPassword(String username, String password);
    @Query(value = "SELECT * FROM passkeeper.account a WHERE a.username = :username and a.password = :password",
            nativeQuery = true)
    Account findAccountByUsernameAndPassword(
            @Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT account.id, account.username, account.password FROM passkeeper.account", nativeQuery=true)
    List<Account> listAllUser();
  //      List<Account> findAll();

}
