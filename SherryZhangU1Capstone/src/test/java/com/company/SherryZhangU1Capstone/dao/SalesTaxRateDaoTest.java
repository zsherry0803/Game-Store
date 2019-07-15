package com.company.SherryZhangU1Capstone.dao;

import com.company.SherryZhangU1Capstone.model.SalesTaxRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoTest {

    @Autowired
    SalesTaxRateDao salesTaxRateDao;

    @Test
    public void getSalesTaxRate() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setRate(BigDecimal.valueOf(0.05).setScale(2));
        salesTaxRate.setState("NJ");

        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());
        assertEquals(salesTaxRate.getRate(),salesTaxRate1.getRate());
    }
}