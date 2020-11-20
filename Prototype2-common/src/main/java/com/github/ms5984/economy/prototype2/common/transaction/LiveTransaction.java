package com.github.ms5984.economy.prototype2.common.transaction;

import com.github.ms5984.economy.prototype2.api.Payee;
import com.github.ms5984.economy.prototype2.api.Payer;

import java.math.BigDecimal;

public class LiveTransaction extends AbstractTransaction {
    protected final transient Payer payer;
    protected final transient Payee payee;

    public LiveTransaction(BigDecimal amount, Payer payer, Payee payee) {
        super(amount, payer, payee);
        this.payer = payer;
        this.payee = payee;
    }

    @Override
    public Payer getPayer() {
        return payer;
    }

    @Override
    public Payee getPayee() {
        return payee;
    }
}
