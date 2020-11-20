package com.github.ms5984.economy.prototype2.api;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A FinancialInstitution is designed to hold accounts.
 * Name is generic to allow bank, credit union or
 * brokerage-type entities--so on and so forth--that
 * manage customer accounts to share similar API.
 */
public interface FinancialInstitution extends Entity {
    /**
     * This method may be overridden by institutions that
     * transact outside of the scope of the local datasource.
     * Case-in-point: cross-server markets.
     * @return each Account from the datasource whose Institution
     * reference matches this object.
     */
    default List<Account> getAccounts() {
        return Prototype2Provider.getInstance().getBalances().stream()
                .filter(balance -> balance instanceof Account)
                .map(balance -> (Account)balance)
                .filter(account -> account.getInstitution() == this)
                .collect(Collectors.toList());
    }
}
