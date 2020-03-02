package com.example.mvvm_architechture.utils;

import org.jetbrains.annotations.NotNull;

import java.text.NumberFormat;
import java.util.Locale;

public class ConcurrencyTools {

    @NotNull
    public static String priceAnnotator(
            String amount
    ) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        return numberFormat.format(Double.valueOf(amount).longValue());
    }

    @NotNull
    public static String priceAnnotator(
            Long amount
    ) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        return numberFormat.format(Double.valueOf(amount));
    }
}
