package com.github.ms5984.economy.prototype2.common.currency;

import com.github.ms5984.economy.prototype2.api.Currency;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class BasicCurrency extends Currency {
    protected static final NumberFormat NUMBER_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);
    protected final MajorUnit majorUnit;
    protected final MinorUnit minorUnit;
    protected final String pairSymbol;
    protected final int decimalPlaces;
    protected final String singularName;
    protected final String pluralName;

    protected BasicCurrency(MajorUnit majorUnit, MinorUnit minorUnit,
                            String pairSymbol, int decimalPlaces,
                            String singularName, String pluralName) {
        this.majorUnit = majorUnit;
        this.minorUnit = minorUnit;
        this.pairSymbol = pairSymbol;
        this.decimalPlaces = decimalPlaces;
        this.singularName = singularName;
        this.pluralName = pluralName;
    }

    @Override
    public String pairSymbol() {
        return pairSymbol;
    }

    @Override
    public int decimalPlaces() {
        return decimalPlaces;
    }

    @Override
    public String format(BigDecimal amount) {
        return NUMBER_FORMAT.format(amount);
    }

    @Override
    public String singularName() {
        return singularName;
    }

    @Override
    public String pluralName() {
        return pluralName;
    }
}
