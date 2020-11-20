package com.github.ms5984.economy.prototype2.common.individual;

import com.github.ms5984.economy.prototype2.api.Currency;
import com.github.ms5984.economy.prototype2.api.Individual;
import com.github.ms5984.economy.prototype2.api.Wallet;
import com.github.ms5984.economy.prototype2.common.balance.AbstractBalance;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class IndividualWallet extends AbstractBalance implements Wallet {
    protected String friendlyName;
    protected UUID uuid;
    private final transient Individual individual;

    /**
     * Do not use this constructor unless deserializing
     */
    protected IndividualWallet() {
        this.individual = null;
    }
    public IndividualWallet(Individual individual, Currency currency) {
        super(currency);
        this.individual = individual;
        refreshValues();
    }

    protected void refreshValues() {
        if (individual == null) return;
        this.friendlyName = individual.friendlyName().concat(" (Wallet)");
        this.uuid = individual.getUid();
    }

    @Override
    public String friendlyName() {
        return friendlyName == null ? "Unnamed Wallet" : friendlyName;
    }

    @Override
    public @NotNull UUID getUid() {
        return uuid;
    }
}
