package com.company.SherryZhangU1Capstone.model;

import java.math.BigDecimal;
import java.util.Objects;

//invoice_id int(11) not null auto_increment primary
//        key,
//        name varchar(80) not null,
//        street varchar(30) not null,
//        city varchar(30) not null,
//        state varchar(30) not null,
//        zipcode varchar(5) not null,
//        item_type varchar(20) not null,
//        item_id int(11) not null,
//        unit_price decimal(5,2) not null,
//        quantity int(11) not null,
//        subtotal decimal(5,2) not null,
//        tax decimal(5,2) not null,
//        processing_fee decimal (5,2) not null,
//        total decimal(5,2) not null
public class Invoice {
    private int invoiceId;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String itemType;
    private Integer itemId;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
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
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId == invoice.invoiceId &&
                name.equals(invoice.name) &&
                street.equals(invoice.street) &&
                city.equals(invoice.city) &&
                state.equals(invoice.state) &&
                zipcode.equals(invoice.zipcode) &&
                itemType.equals(invoice.itemType) &&
                itemId.equals(invoice.itemId) &&
                unitPrice.equals(invoice.unitPrice) &&
                quantity.equals(invoice.quantity) &&
                subtotal.equals(invoice.subtotal) &&
                tax.equals(invoice.tax) &&
                processingFee.equals(invoice.processingFee) &&
                total.equals(invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, name, street, city, state, zipcode, itemType, itemId, unitPrice, quantity, subtotal, tax, processingFee, total);
    }
}
