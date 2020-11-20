package com.github.ms5984.economy.prototype2.api;

import java.math.BigDecimal;

/**
 * An entity which is designed to receive funds.
 * <p>Provides {@link #receiveFrom(Payer, BigDecimal)} API for more complex classes,
 * but may also be used to implement receive-only entities.</p>
 * Receive-only uses:
 * * Admin buy shops
 * * Money sinks (for instance, Towny's upkeep)
 */
public interface Payee extends Entity {
    Transaction receiveFrom(Payer payer, BigDecimal amount);
    Currency currency();
}
