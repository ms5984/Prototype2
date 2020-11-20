package com.github.ms5984.economy.prototype2.api;

import org.jetbrains.annotations.Contract;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public interface Prototype2 {
    /**
     * Every economy actor is indexed.
     * @return List of all recorded entities
     */
    default List<Entity> getEntities() {
        return Collections.emptyList();
    }

    /**
     * Used to deserialize stored Entity references.
     * @param entityUid from data store
     * @return the associated Entity object
     */
    @Contract("null -> null")
    default Entity getEntityByUid(UUID entityUid) {
        return null;
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

    /**
     * Used to deserialize stored Currency references.
     *
     * @param currencyId from data store
     * @return the associated currency object (returns null if not found)
     */
    @Contract("null -> null")
    default Currency getCurrencyByUid(UUID currencyId) {
        return null;
    }

    default boolean isEnabled() {
        return false;
    }
}
