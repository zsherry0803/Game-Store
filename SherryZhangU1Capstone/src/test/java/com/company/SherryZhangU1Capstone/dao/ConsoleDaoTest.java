package com.company.SherryZhangU1Capstone.dao;

import com.company.SherryZhangU1Capstone.model.Console;
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
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        List<Console> consoles = consoleDao.getAllConsoles();
        for (Console console : consoles) {
            consoleDao.deleteConsole(console.getGameId());
        }
    }

    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setManufacturer("SE");
        console.setMemoryAmount("1024");
        console.setModel("bash");
        console.setPrice(new BigDecimal("3.2").setScale(2));
        console.setQuantity(11);

        console = consoleDao.addConsole(console);
        Console console1 = consoleDao.getConsole(console.getGameId());

        assertEquals(console, console1);

        consoleDao.deleteConsole(console.getGameId());
        console1 = consoleDao.getConsole(console.getGameId());
        assertNull(console1);
    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setManufacturer("SE");
        console.setMemoryAmount("1024");
        console.setModel("bash");
        console.setPrice(new BigDecimal("3.2").setScale(2));
        console.setQuantity(11);
        console.setProcessor("");

        console = consoleDao.addConsole(console);
        console.setModel("OSX");
        console.setMemoryAmount("1GB");
        consoleDao.updateConsole(console);
        Console console1 = consoleDao.getConsole(console.getGameId());

        assertEquals(console, console1);
    }

    @Test
    public void getConsolesByManufacturer() {
        Console console = new Console();
        console.setManufacturer("SE");
        console.setMemoryAmount("1024");
        console.setModel("bash");
        console.setPrice(new BigDecimal("3.2").setScale(2));
        console.setQuantity(11);

        consoleDao.addConsole(console);
        console.setMemoryAmount("2048MB");
        consoleDao.addConsole(console);
        console.setManufacturer("Sony");
        console.setModel("OSX");
        consoleDao.addConsole(console);

        List<Console> list = consoleDao.getConsolesByManufacturer("SE");
        assertEquals(2, list.size());

        list = consoleDao.getConsolesByManufacturer("Sony");
        assertEquals(1, list.size());
    }
}