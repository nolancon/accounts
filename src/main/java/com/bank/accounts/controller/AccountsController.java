package com.bank.accounts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accounts.details.Account;
import com.bank.accounts.exceptions.ResourceNotFoundException;
import com.bank.accounts.repositories.AccountsRepository;


@RestController
public class AccountsController {
	
	@Value("${config.version}")
	//private String version;
	
	@Autowired
	Version version;
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	
	@GetMapping("/version")
    public Version getVersion() {
		//return version;
		//System.out.println(version);
		return new Version(version.getVersion());
    }
	
	@GetMapping("/accounts")
    public List<Account> getUsers() {
        return accountsRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity< Account > getAccountById(@PathVariable(value = "id") Long accountId) throws ResourceNotFoundException {
        Optional<Account> account = accountsRepository.findById(accountId);
        if(account.isPresent())
            return ResponseEntity.ok().body(account.get());
        else
            throw new ResourceNotFoundException("Account not found :: " + accountId);
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
        return accountsRepository.save(account);
    }
    
    

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable(value = "id") Long accountId){
        accountsRepository.deleteById(accountId);
    }
}
