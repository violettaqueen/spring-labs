package com.cydeo;

import com.cydeo.loosely.Balance;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;

@Getter
@Setter
public class GiftCardBalance extends Balance {
    public GiftCardBalance(UUID userId, BigDecimal amount) {
        super(userId, amount);
    }

    public BigDecimal addBalance(BigDecimal amount) {
        BigDecimal bonusAmount =
                amount.multiply(BigDecimal.TEN)
                        .divide(new BigDecimal(100)
                                , MathContext.DECIMAL64);

        setAmount(this.getAmount().add(amount).add(bonusAmount));
        return this.getAmount();
    }
}
