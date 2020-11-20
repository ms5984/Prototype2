package com.github.ms5984.economy.prototype2.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Contains information about a given currency
 * (including minor+major units and provides method
 * to format {@link BigDecimal} amounts to string.
 */
public abstract class Currency {
    public interface CurrencyUnit {
        /**
         * What this CurrencyUnit is worth
         * For example:
         * $1 = 1.
         * Dime = .10
         */
        BigDecimal amount();
        /**
         * The singular name for a unit of currency
         * 1 "One Dollar Bill"
         * 1 "Dime"
         */
        String nameSingle();
        /**
         * The plural name for a unit of currency
         * 2 "Five Dollar Bills"
         * 10 "Nickels"
         */
        String namePlural();
    }
    public interface MajorUnit extends CurrencyUnit {
    }
    public interface MinorUnit extends CurrencyUnit {
    }

    /**
     * The major units of this currency.
     * <p>For USD, think of Ones, Fives, Tens--bills.</p>
     * @return an ordered list from smallest to greatest denomination
     */
    public List<MajorUnit> majorUnits() {
        return Collections.emptyList();
    }
    /**
     * The minor units of this currency.
     * <p>For USD, think of Nickels, Dimes, Quarters--coins.</p>
     * @return an ordered list from smallest to greatest denomination
     */
    public List<MinorUnit> minorUnits() {
        return Collections.emptyList();
    }

    /**
     * Returns a Map representing the most concise representation of
     * an amount using counts of CurrencyUnits.
     * @param amount an amount of currency
     * @return the closest representation of the amount using Major+Minor units
     */
    public Map<CurrencyUnit, Integer> unitsFromAmount(BigDecimal amount) {
        final Map<CurrencyUnit, Integer> unitMap = new HashMap<>();
        final List<CurrencyUnit> units = new ArrayList<>();
        units.addAll(majorUnits());
        units.addAll(minorUnits());
        int dividend;
        // set remainder variable to abs(initial amount)
        BigDecimal temp = amount.abs();
        // arrange all CurrencyUnits from largest to smallest amount and iterate
        for (CurrencyUnit unit : units.stream().sorted(Comparator.comparing(CurrencyUnit::amount).reversed()).collect(Collectors.toList())) {
            // if last remainder > 0
            if (temp.compareTo(BigDecimal.ZERO) > 0) {
                try {
                    final BigDecimal[] divideAndRemainder = temp.divideAndRemainder(unit.amount());
                    dividend = divideAndRemainder[0].intValueExact();
                    if (dividend > 0) {
                        unitMap.put(unit, dividend);
                    }
                    temp = divideAndRemainder[1];
                } catch (ArithmeticException e) {
                    // 1. Never count 0-notes. Thrown by #divideAndRemainder(BigDecimal.ZERO)
                    // 2. The call to #intValueExact should never fail on the integral part
                }
            }
        }
        return unitMap;
    }

    /**
     * The (often) three-letter code representing the currency among others.
     * Case-in-point: USD
     */
    public abstract String pairSymbol();
    /**
     * Usually two, but can be customized/overridden in an application scope (for financial calculations, etc)
     */
    public abstract int decimalPlaces();
    /**
     * Returns a formatted String for displaying values formally. May lack precision, see {@link #decimalPlaces()}
     * 23.512 -> $23.51
     */
    public abstract String format(BigDecimal amount);
    /**
     * The singular name of the currency
     * 1 "Dollar"
     */
    public abstract String singularName();
    /**
     * The plural name of the currency
     * 12 "Dollars", or 1.13 "Dollars"
     */
    public abstract String pluralName();

    /**
     * #toString to provide plural name by default
     */
    @Override
    public String toString() {
        return pluralName();
    }
}
