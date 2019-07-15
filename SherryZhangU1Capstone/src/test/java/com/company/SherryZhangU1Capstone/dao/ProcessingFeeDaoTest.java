package com.company.SherryZhangU1Capstone.dao;

import com.company.SherryZhangU1Capstone.model.ProcessingFee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {

    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Test
    public void getProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.49).setScale(2));
       // processingFee.setIxProductTypeFee(3);
        processingFee.setProductType("Games");

        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());
        assertEquals(processingFee.getFee(), processingFee1.getFee());
    }
}