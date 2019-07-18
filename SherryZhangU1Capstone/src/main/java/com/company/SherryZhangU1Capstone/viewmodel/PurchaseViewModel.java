package com.company.SherryZhangU1Capstone.viewmodel;



import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class PurchaseViewModel {
    private int invoiceId;
    @NotEmpty(message="Please supply an name")
    private String name;
    @NotEmpty(message="Please supply an street")
    private String street;
    @NotEmpty(message="Please supply an city")
    private String city;
    @NotEmpty(message="Please supply an state")
    @Size(max = 2, min = 2, message = "State must be two uppercase letters")
    private String state;
    @NotEmpty(message="Please supply an zipcode")
    private String zipcode;
    @NotEmpty(message="Please supply an itemType")
    private String itemType;
    @NotNull(message="Please supply an itemId")
    @Min(1)
    private Integer itemId;


    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal unitPrice;
    @NotNull(message="Please supply an quantity")
    @Min(1)
    private Integer quantity;
//    @NotEmpty(message="Please supply an subtotal")
    private BigDecimal subtotal;
//    @NotEmpty(message="Please supply an salesTaxRate")
//    private SalesTaxRate salesTaxRate;
    private BigDecimal tax;
//    @NotEmpty(message="Please supply an processingFee")
    //private ProcessingFee processingFee;
    private BigDecimal processingFee;
//    @NotEmpty(message="Please supply an total")
    private BigDecimal total;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseViewModel)) return false;
        PurchaseViewModel that = (PurchaseViewModel) o;
        return invoiceId == that.invoiceId &&
                name.equals(that.name) &&
                street.equals(that.street) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                zipcode.equals(that.zipcode) &&
                itemType.equals(that.itemType) &&
                itemId.equals(that.itemId) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                quantity.equals(that.quantity) &&
                Objects.equals(subtotal, that.subtotal) &&
                Objects.equals(tax, that.tax) &&
                Objects.equals(processingFee, that.processingFee) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, name, street, city, state, zipcode, itemType, itemId, unitPrice, quantity, subtotal, tax, processingFee, total);
    }
}
