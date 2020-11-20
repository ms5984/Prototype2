package com.github.ms5984.economy.prototype2.api;

import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Provides API to access data pertinent to pending and complete transactions
 */
public interface Transaction {
    enum State {
        DENIED, APPROVED, PENDING
    }
    UUID uid();

    /**
     * If applicable, returns a transaction's id as defined by the vendor; thus, the value is not guaranteed to be unique.
     * This is akin to how retail companies use varying receipt number schema
     *
     * @return non-unique transaction id string, null if not applicable
     */
    @Nullable
    default String getId() {
        return null;
    }

    /**
     * This method should return the LocalDataTime at which the transaction took place
     *
     * @return the time of the transaction
     */
    LocalDateTime creationTime();

    BigDecimal getAmount();

    /**
     * Adjust the amount of the transaction
     *
     * @param amount a new amount for the transaction
     */
    default void setAmount(BigDecimal amount) {
//
    }

    default Payer getPayer() {
        return null;
    }
    default Payee getPayee() {
        return null;
    }

    /**
     * Has the transaction been entered into the system?
     * @return false, true once processed
     */
    boolean isComplete();

    /**
     * Was the transaction successful?
     *
     * @return Success
     */
    default boolean success() {
        return true;
    }

    /**
     * Returns the present status of this transaction.
     * Defaults to APPROVED unless additional interaction required.
     * @return a {@link State} indicating transaction progress
     */
    default State state() {
        return State.APPROVED;
    }
}
