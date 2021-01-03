package com.github.ms5984.economy.prototype2.api;

import java.util.Collections;
import java.util.List;

public interface Prototype2 {
    /**
     * Every economy actor is indexed.
     * @return List of all recorded entities
     */
    default List<Entity> getEntities() {
        return Collections.emptyList();
    }

    /**
     * Fundamentally, transactions which have persistent effects occur between
     * a {@link Balance} and a {@link Payer}/{@link Payee}. Note the former is both.
     *
     * <p>This list naturally will represent a number of different arrangements but
     * only those whose balance persists: {@link Account} and {@link Wallet}</p>
     */
    default List<Balance> getBalances() {
        return Collections.emptyList();
    }

    /**
     * Prototype2 has support for multiple currencies. See the common module for
     * instructions on implementing your own.
     */
    default List<Currency> getCurrencies() {
        return Collections.emptyList();
    }

    default boolean isEnabled() {
        return false;
    }
}
