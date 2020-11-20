package com.github.ms5984.economy.prototype2.api;

import java.math.BigDecimal;

public interface Balance extends Payer, Payee {
    /**
     * The current value of this balance.
     * Owed amounts may be reported as negative values
     * (think loans, lines of credit).
     * @return positive BigDecimal for amounts held in favor
     * of the owner, negative for those owed
     */
    BigDecimal getBalance();
    /**
     * Directly add to a balance.
     * @deprecated
     * Where possible, use {@link #receiveFrom(Payer, BigDecimal)}
     */
    @Deprecated
    void addBalance(BigDecimal addend);

    /**
     * Directly take from a balance.
     * @deprecated
     * Where possible, use {@link #payTo(Payee, BigDecimal)}
     */
    @Deprecated
    void removeBalance(BigDecimal subtrahend);
    /**
     * Directly set a balance.
     * @deprecated 
     * Ensure first whether or not {@link #payTo(Payee, BigDecimal)} or {@link #receiveFrom(Payer, BigDecimal)}
     * might better record a transactional update.
     */
    @Deprecated
    void setBalance(BigDecimal newBalance);

    /**
     * The currency this balance is denominated in. Explicitly overridden
     * to ensure uniform payee/payer behavior
     * @return a valid currency object
     */
    @Override
    Currency currency();
}
