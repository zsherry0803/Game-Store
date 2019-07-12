package com.company.SherryZhangU1Capstone.model;

import java.math.BigDecimal;
import java.util.Objects;

//product_type varchar(20) not null,
//        fee decimal (4,2)
public class ProcessingFee {
    private int ixProductTypeFee;
    private String productType;
    private BigDecimal fee;


    public int getIxProductTypeFee() {
        return ixProductTypeFee;
    }

    public void setIxProductTypeFee(int ixProductTypeFee) {
        this.ixProductTypeFee = ixProductTypeFee;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessingFee)) return false;
        ProcessingFee that = (ProcessingFee) o;
        return Objects.equals(ixProductTypeFee, that.ixProductTypeFee) &&
                Objects.equals(productType, that.productType) &&
                fee.equals(that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ixProductTypeFee, productType, fee);
    }
}
