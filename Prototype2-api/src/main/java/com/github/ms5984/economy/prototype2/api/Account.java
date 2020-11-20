package com.github.ms5984.economy.prototype2.api;

public interface Account extends Balance {
    /**
     * In normal circumstances, an Account will always be associated with a FinancialInstitution.
     *
     * Note: in the case of institutional accounts, the closest entity should be reported.
     * For instance, an individual's brokerage cash sweep account would return the brokerage,
     * not the program bank(s).
     * @return the FinancialInstitution responsible for the account
     */
    FinancialInstitution getInstitution();
}
