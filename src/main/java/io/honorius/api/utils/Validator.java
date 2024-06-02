package io.honorius.api.utils;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class Validator {
    public boolean isValidCc(BigInteger CC) {
        if (CC == null) {
            return false;
        }

        if (CC.compareTo(BigInteger.ZERO) < 0) {
            return false;
        }

        String ccString = CC.toString();
        if (ccString.length() <= 6) {
            return false;
        }

        if (!ccString.matches("-?\\d+")) {
            return false;
        }
        return true;
    }

    public Boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        if (!(name instanceof String)) {
            return false;
        }

        if (name.trim().length() == 0) {
            return false;
        }

        return true;
    }


    //*********************Product*********************
    public boolean isValidStockOrPrice(Integer stock, Double price) {
        if (stock == null || price == null) {
            return false;
        }

        if (stock < 0 || price <= 0) {
            return false;
        }
        return true;
    }

}
