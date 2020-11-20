package com.github.ms5984.economy.prototype2.common.transaction;

import com.github.ms5984.economy.prototype2.api.Entity;
import com.github.ms5984.economy.prototype2.api.Payee;
import com.github.ms5984.economy.prototype2.api.Payer;
import com.github.ms5984.economy.prototype2.api.Transaction;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class AbstractTransaction implements Transaction {
    protected final UUID uuid;
    protected String id = null;
    protected LocalDateTime created;
    protected BigDecimal amount;
    protected Entity payer;
    protected Entity payee;

    protected AbstractTransaction() {
        this.uuid = null;
    }
    protected AbstractTransaction(BigDecimal amount, Payer payer, Payee payee) {
        this.uuid = UUID.randomUUID();
        this.created = LocalDateTime.now();
        this.amount = amount;
        this.payer = payer;
        this.payee = payee;
    }

    @Override
    public UUID uid() {
        return uuid;
    }

    @Override
    public @Nullable String getId() {
        return id;
    }

    @Override
    public LocalDateTime creationTime() {
        return created;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean isComplete() {
        return false;
    }
}
