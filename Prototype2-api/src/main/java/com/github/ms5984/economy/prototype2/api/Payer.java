package com.github.ms5984.economy.prototype2.api;

import java.math.BigDecimal;

/**
 * An entity which is designed to dispense funds.
 * <p>Provides {@link #payTo(Payee, BigDecimal)} API for more complex classes,
 * but may also be used to implement pay-only entities.</p>
 * Pay-only uses:
 * * Admin sell shops
 * * Money faucets (think Jobs, vote rewards, mob bounties, etc)
 */
public interface Payer extends Entity {
    Transaction payTo(Payee payee, BigDecimal amount);
    Currency currency();
}
