package com.github.ms5984.economy.prototype2.api;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Designates an actor capable of maintaining accounts for transacting.
 * Most often players, but also designed to suit persistent NPC use
 * See also {@link Payee} and {@link Payer}.
 */
public interface Individual extends Entity {
    /**
     * Get the Wallet object denominated in {@link Currency} currency for this actor
     * @return the existing Wallet, or a newly-generated one
     */
    @NotNull
    Wallet getWallet(Currency currency);

    /**
     * Gather a list of the accounts this actor possesses and/or has access to. Does not include wallet.
     * @return a new List of the actor's accounts. May be empty.
     */
    @NotNull
    List<Account> getAccounts();
}
