package com.company.SherryZhangU1Capstone.dao;

import com.company.SherryZhangU1Capstone.model.Tshirt;
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
public class TshirtDaoTest {

    @Autowired
    TshirtDao tshirtDao;

    @Before
    public void setUp() throws Exception {
        List<Tshirt> list = tshirtDao.getAllTshirts();
        for (Tshirt tshirt : list) {
            tshirtDao.deleteTshirt(tshirt.getTshirtId());
        }
    }

    @Test
    public void addGetDeleteTshirt() {
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("red");
        tshirt.setDescription("this is a red tshirt");
        tshirt.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt.setQuantity(30);
        tshirt.setSize("S");

        tshirt = tshirtDao.addTshirt(tshirt);
        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.getTshirtId());
        assertEquals(tshirt, tshirt1);
        tshirtDao.deleteTshirt(tshirt.getTshirtId());
        tshirt1 = tshirtDao.getTshirt(tshirt.getTshirtId());
        assertNull(tshirt1);
    }

    @Test
    public void updateTshirt() {

        Tshirt tshirt = new Tshirt();
        tshirt.setColor("red");
        tshirt.setDescription("this is a red tshirt");
        tshirt.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt.setQuantity(30);
        tshirt.setSize("S");

        tshirt = tshirtDao.addTshirt(tshirt);
        tshirt.setSize("L");
        tshirt.setQuantity(100);
        tshirtDao.updateTshirt(tshirt);

        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.getTshirtId());
        assertEquals(tshirt, tshirt1);

    }

    @Test
    public void getAllTshirts() {
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("red");
        tshirt.setDescription("this is a red tshirt");
        tshirt.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt.setQuantity(30);
        tshirt.setSize("S");

        tshirtDao.addTshirt(tshirt);
        tshirtDao.addTshirt(tshirt);
        tshirt.setQuantity(1000);
        tshirtDao.addTshirt(tshirt);
        List<Tshirt> list = tshirtDao.getAllTshirts();
        assertEquals(3, list.size());
    }

    @Test
    public void getTshirtsByColor() {
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("red");
        tshirt.setDescription("this is a red tshirt");
        tshirt.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt.setQuantity(30);
        tshirt.setSize("S");

        tshirtDao.addTshirt(tshirt);
        tshirtDao.addTshirt(tshirt);
        tshirt.setColor("blue");
        tshirtDao.addTshirt(tshirt);
        List<Tshirt> list = tshirtDao.getTshirtsByColor("red");
        assertEquals(2, list.size());
        list = tshirtDao.getTshirtsByColor("blue");
        assertEquals(1, list.size());
    }

    @Test
    public void getTshirtsBySize() {
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("red");
        tshirt.setDescription("this is a red tshirt");
        tshirt.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt.setQuantity(30);
        tshirt.setSize("S");

        tshirtDao.addTshirt(tshirt);
        tshirtDao.addTshirt(tshirt);
        tshirt.setSize("L");
        tshirtDao.addTshirt(tshirt);
        List<Tshirt> list = tshirtDao.getTshirtsBySize("S");
        assertEquals(2, list.size());
        list = tshirtDao.getTshirtsBySize("L");
        assertEquals(1, list.size());
    }
}