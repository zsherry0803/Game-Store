package com.company.SherryZhangU1Capstone.model;

import java.math.BigDecimal;
import java.util.Objects;

//state char(2) not null,
//        rate decimal(3,2) not null
public class SalesTaxRate {
    private int ix_state_rate;
    private String state;
    private BigDecimal rate;


    public int getIx_state_rate() {
        return ix_state_rate;
    }

    public void setIx_state_rate(int ix_state_rate) {
        this.ix_state_rate = ix_state_rate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesTaxRate)) return false;
        SalesTaxRate that = (SalesTaxRate) o;
        return ix_state_rate == that.ix_state_rate &&
                state.equals(that.state) &&
                rate.equals(that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ix_state_rate, state, rate);
    }
}
