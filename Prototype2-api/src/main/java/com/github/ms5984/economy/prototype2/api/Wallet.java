package com.github.ms5984.economy.prototype2.api;

/**
 * Wallets are the simplest real-world forms of Balances.
 * Unlike {@link Account}, Wallet is not associated with a
 * {@link FinancialInstitution}, and acts primarily as an
 * extension of {@link Individual}. As a {@link Balance}, they
 * are always denominated in a particular {@link Currency}.
 */
public interface Wallet extends Balance {
    /**
     * You might want to customize the behavior of wallets,
     * deciding perhaps that a full wallet no longer can accept monies.
     * This method allows for that logic to implemented within
     * Prototype2 config irrespective of the platform implementation.
     *
     * @return false unless Wallet is of limited capacity and is full
     */
    default boolean isFull() {
        return false;
    }
}
