package com.company.SherryZhangU1Capstone.dao;

import com.company.SherryZhangU1Capstone.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {
        List<Invoice> list = invoiceDao.getAllInvoices();
        for(Invoice invoice : list) {
            invoiceDao.deleteInvoice(invoice.getInvoiceId());
        }
    }

    @Test
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setCity("new port");

    }
}