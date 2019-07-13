package com.company.SherryZhangU1Capstone.dao;

import com.company.SherryZhangU1Capstone.model.Invoice;

import java.util.List;

public interface InvoiceDao {
    Invoice addInvoice(Invoice invoice);
    List<Invoice> getAllInvoices();
    void deleteInvoice(int id);
}
