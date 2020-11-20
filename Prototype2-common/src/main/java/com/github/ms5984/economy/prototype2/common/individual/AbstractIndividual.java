package com.github.ms5984.economy.prototype2.common.individual;

import com.github.ms5984.economy.prototype2.api.Currency;
import com.github.ms5984.economy.prototype2.api.Individual;
import com.github.ms5984.economy.prototype2.api.Wallet;
import com.github.ms5984.economy.prototype2.common.entity.AbstractEntity;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class AbstractIndividual extends AbstractEntity implements Individual {

    protected AbstractIndividual() {
        // for deserialization
    }
    protected AbstractIndividual(String friendlyName, UUID uuid) {
        super(friendlyName, uuid);
    }

    @Override
    public @NotNull Wallet getWallet(Currency currency) {
        return new IndividualWallet(this, currency);
    }
}
