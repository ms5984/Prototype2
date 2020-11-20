package com.github.ms5984.economy.prototype2.common.balance;

import com.github.ms5984.economy.prototype2.api.*;
import com.github.ms5984.economy.prototype2.common.transaction.LiveTransaction;

import java.math.BigDecimal;

public abstract class AbstractBalance implements Balance {
    protected BigDecimal balance;
    protected final transient Currency currency;

    /**
     * For deserialization only
     */
    protected AbstractBalance() {
        this.currency = null;
    }
    protected AbstractBalance(Currency currency) {
        this.currency = currency;
    }

    @Override
    public void addBalance(BigDecimal addend) {
        this.balance = addend.add(balance);
    }

    @Override
    public void removeBalance(BigDecimal subtrahend) {
        this.balance = balance.subtract(subtrahend);
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void setBalance(BigDecimal newBalance) {
        this.balance = newBalance; // TODO log this
    }

    @Override
    public Transaction receiveFrom(Payer payer, BigDecimal amount) {
        return new LiveTransaction(amount, payer, this);
    }

    @Override
    public Transaction payTo(Payee payee, BigDecimal amount) {
        return new LiveTransaction(amount, this, payee);
    }

    @Override
    public Currency currency() {
        return currency;
    }
}
