package com.company.SherryZhangU1Capstone.dao;

import com.company.SherryZhangU1Capstone.model.Game;
import com.company.SherryZhangU1Capstone.model.Invoice;
import com.company.SherryZhangU1Capstone.model.ProcessingFee;
import com.company.SherryZhangU1Capstone.model.SalesTaxRate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ProcessingFeeDao processingFeeDao;
    @Autowired
    SalesTaxRateDao salesTaxRateDao;
    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        List<Game> glist = gameDao.getAllGames();
        for(Game game : glist){
            gameDao.deleteGame(game.getGameId());
        }

        List<Invoice> list = invoiceDao.getAllInvoices();
        for(Invoice invoice : list) {
            invoiceDao.deleteInvoice(invoice.getInvoiceId());
        }
    }

    @Test
    public void addGetDeleteInvoice() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.49).setScale(2));
        processingFee.setProductType("Games");
        processingFee = processingFeeDao.getProcessingFee(processingFee.getProductType());

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setRate(BigDecimal.valueOf(0.05).setScale(2));
        salesTaxRate.setState("NJ");
        salesTaxRate = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());

        Game game = new Game();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);

        game = gameDao.addGame(game);

        Invoice invoice = new Invoice();
        invoice.setCity("new port");
        invoice.setName("sherry");
        invoice.setStreet("Washington st");
        invoice.setZipcode("07302");
        invoice.setItemId(game.getGameId());
        invoice.setItemType(processingFee.getProductType());
        invoice.setProcessingFee(processingFee.getFee());
        invoice.setState(salesTaxRate.getState());
        invoice.setTax(salesTaxRate.getRate());

        invoice.setQuantity(30);
        invoice.setUnitPrice(game.getPrice());
        invoice.setSubtotal(invoice.getUnitPrice().multiply(BigDecimal.valueOf(invoice.getQuantity())));
        invoice.setTotal(invoice.getSubtotal().add(invoice.getTax().add(invoice.getProcessingFee())));

        invoice = invoiceDao.addInvoice(invoice);
        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice, invoice1);

    }
}