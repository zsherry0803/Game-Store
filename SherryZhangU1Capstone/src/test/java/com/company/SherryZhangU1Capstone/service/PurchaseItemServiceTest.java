package com.company.SherryZhangU1Capstone.service;

import com.company.SherryZhangU1Capstone.dao.*;
import com.company.SherryZhangU1Capstone.model.*;
import com.company.SherryZhangU1Capstone.viewmodel.ConsoleViewModel;
import com.company.SherryZhangU1Capstone.viewmodel.GameViewModel;
import com.company.SherryZhangU1Capstone.viewmodel.PurchaseViewModel;
import com.company.SherryZhangU1Capstone.viewmodel.TshirtViewModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class PurchaseItemServiceTest {

    ConsoleDao consoleDao;
    GameDao gameDao;
    TshirtDao tshirtDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    PurchaseItemService purchaseItemService;

    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpProcessingFeeMock();
        setUpSalesTaxRateDaoMock();
        setUpTshirtDaoMock();

        purchaseItemService = new PurchaseItemService(consoleDao, gameDao, tshirtDao, invoiceDao, processingFeeDao, salesTaxRateDao);
    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        Console console = new Console();
        console.setManufacturer("SE");
        console.setMemoryAmount("1024");
        console.setModel("bash");
        console.setPrice(new BigDecimal("3.2").setScale(2));
        console.setQuantity(11);

        Console console1 = new Console();
        console1.setManufacturer("SE");
        console1.setMemoryAmount("1024");
        console1.setModel("bash");
        console1.setPrice(new BigDecimal("3.2").setScale(2));
        console1.setQuantity(11);
        console1.setGameId(3);

        Console console2 = new Console();
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("1024");
        console2.setModel("bash");
        console2.setPrice(new BigDecimal("3.2").setScale(2));
        console2.setQuantity(11);

        Console console3 = new Console();
        console3.setManufacturer("Sony");
        console3.setMemoryAmount("1024");
        console3.setModel("bash");
        console3.setPrice(new BigDecimal("3.2").setScale(2));
        console3.setQuantity(11);
        console3.setGameId(40);

        List<Console> list = new ArrayList<>();
        list.add(console3);

        doReturn(console1).when(consoleDao).addConsole(console);
        doReturn(console1).when(consoleDao).getConsole(3);
        doReturn(console3).when(consoleDao).addConsole(console2);
        doReturn(console3).when(consoleDao).getConsole(40);
        doReturn(list).when(consoleDao).getConsolesByManufacturer("Sony");
        //doReturn(list).when(consoleDao).getAllConsoles();
    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoTemplateImpl.class);

        Game game = new Game();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);

        Game game1 = new Game();
        game1.setDescription("good game");
        game1.setErsbRating("M18+");
        game1.setPrice(new BigDecimal("12.00").setScale(2));
        game1.setStudio("SE");
        game1.setTitle("FF 14");
        game1.setQuantity(50);
        game1.setGameId(34);

        List<Game> list = new ArrayList<>();

        Game game5 = new Game();
        game5.setDescription("good game");
        game5.setErsbRating("M16+");
        game5.setPrice(new BigDecimal("12.00").setScale(2));
        game5.setStudio("SE");
        game5.setTitle("FF 14");
        game5.setQuantity(50);

        Game game2 = new Game();
        game2.setDescription("good game");
        game2.setErsbRating("M16+");
        game2.setPrice(new BigDecimal("12.00").setScale(2));
        game2.setStudio("SE");
        game2.setTitle("FF 14");
        game2.setQuantity(50);
        game2.setGameId(33);
        list.add(game2);

        Game game3 = new Game();
        game3.setDescription("good game");
        game3.setErsbRating("M18+");
        game3.setPrice(new BigDecimal("12.00").setScale(2));
        game3.setStudio("SE");
        game3.setTitle("FF 14");
        game3.setQuantity(50);
        game3.setGameId(44);
        List<Game> listByStudio = new ArrayList<>();
        listByStudio.add(game1);
        listByStudio.add(game3);

        Game game6 = new Game();
        game6.setDescription("good game");
        game6.setErsbRating("M18+");
        game6.setPrice(new BigDecimal("12.00").setScale(2));
        game6.setStudio("SE");
        game6.setTitle("FF 15");
        game6.setQuantity(50);

        Game game4 = new Game();
        game4.setDescription("good game");
        game4.setErsbRating("M18+");
        game4.setPrice(new BigDecimal("12.00").setScale(2));
        game4.setStudio("SE");
        game4.setTitle("FF 15");
        game4.setQuantity(50);
        game4.setGameId(50);
        List<Game> listByTitle = new ArrayList<>();
        listByTitle.add(game4);

        doReturn(game1).when(gameDao).addGame(game);
        doReturn(game1).when(gameDao).getGame(34);
        doReturn(game2).when(gameDao).addGame(game5);
        doReturn(game4).when(gameDao).addGame(game6);
        doReturn(list).when(gameDao).getGameByRating("M16+");
        doReturn(listByStudio).when(gameDao).getGameByStudio("SE");
        doReturn(listByTitle).when(gameDao).getGameByTitle("FF 15");
    }

    private void setUpTshirtDaoMock() {
        tshirtDao = mock(TshirtDaoJdbcTemplateImpl.class);

        Tshirt tshirt = new Tshirt();
        tshirt.setColor("red");
        tshirt.setDescription("this is a red tshirt");
        tshirt.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt.setQuantity(30);
        tshirt.setSize("S");

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setColor("red");
        tshirt1.setDescription("this is a red tshirt");
        tshirt1.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt1.setQuantity(30);
        tshirt1.setSize("S");
        tshirt1.setTshirtId(45);

        List<Tshirt> list = new ArrayList<>();

        Tshirt tshirt3 = new Tshirt();
        tshirt3.setColor("red");
        tshirt3.setDescription("this is a red tshirt");
        tshirt3.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt3.setQuantity(30);
        tshirt3.setSize("L");

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setColor("red");
        tshirt2.setDescription("this is a red tshirt");
        tshirt2.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt2.setQuantity(30);
        tshirt2.setSize("L");
        tshirt2.setTshirtId(44);
        list.add(tshirt1);
        list.add(tshirt2);

        List<Tshirt> list1 = new ArrayList<>();
        list1.add(tshirt2);

        doReturn(tshirt1).when(tshirtDao).addTshirt(tshirt);
        doReturn(tshirt1).when(tshirtDao).getTshirt(45);
        doReturn(tshirt2).when(tshirtDao).addTshirt(tshirt3);
        doReturn(list).when(tshirtDao).getTshirtsByColor("red");
        doReturn(list1).when(tshirtDao).getTshirtsBySize("L");


    }

    private void setUpProcessingFeeMock() {
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.49).setScale(2));
        processingFee.setProductType("Games");

        doReturn(processingFee).when(processingFeeDao).getProcessingFee("Games");

    }

    private void setUpSalesTaxRateDaoMock() {
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setRate(BigDecimal.valueOf(0.05).setScale(2));
        salesTaxRate.setState("NJ");

        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("NJ");
    }

    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setCity("new port");
        invoice.setName("sherry");
        invoice.setStreet("Washington st");
        invoice.setZipcode("07302");
        invoice.setItemId(34);
        invoice.setItemType("Games");
        invoice.setProcessingFee(BigDecimal.valueOf(1.49).setScale(2));
        invoice.setState("NJ");
        invoice.setQuantity(1);
        invoice.setUnitPrice(BigDecimal.valueOf(12).setScale(2));
        invoice.setSubtotal(BigDecimal.valueOf(12).setScale(2));
        invoice.setTax(BigDecimal.valueOf(0.06).setScale(2));
        invoice.setTotal(BigDecimal.valueOf(14.09).setScale(2));

        Invoice invoice1 = new Invoice();
        invoice1.setCity("new port");
        invoice1.setName("sherry");
        invoice1.setStreet("Washington st");
        invoice1.setZipcode("07302");
        invoice1.setItemId(34);
        invoice1.setItemType("Games");
        invoice1.setProcessingFee(BigDecimal.valueOf(1.49).setScale(2));
        invoice1.setState("NJ");
        invoice1.setTax(BigDecimal.valueOf(0.05).setScale(2));
        invoice1.setQuantity(1);
        invoice1.setUnitPrice(BigDecimal.valueOf(12.00).setScale(2));
        //invoice.setSubtotal(invoice.getUnitPrice().multiply(BigDecimal.valueOf(invoice.getQuantity())));
        invoice1.setSubtotal(BigDecimal.valueOf(12).setScale(2));
        invoice1.setTax(BigDecimal.valueOf(0.06).setScale(2));
        invoice1.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessingFee()));
        invoice1.setInvoiceId(4);
        doReturn(invoice1).when(invoiceDao).addInvoice(invoice);
        doReturn(invoice1).when(invoiceDao).getInvoice(4);
    }


    @Test
    public void saveFindConsole() {
        ConsoleViewModel console = new ConsoleViewModel();
        console.setManufacturer("SE");
        console.setMemoryAmount("1024");
        console.setModel("bash");
        console.setPrice(new BigDecimal("3.2").setScale(2));
        console.setQuantity(11);

        console = purchaseItemService.saveConsole(console);
        ConsoleViewModel fromService = purchaseItemService.findConsoleById(console.getGameId());
        assertEquals(console, fromService);
        List<ConsoleViewModel> list = purchaseItemService.findConsoleByManu("Sony");
        assertEquals(1, list.size());
    }

    @Test
    public void findConsoleByManu() {
        ConsoleViewModel console = new ConsoleViewModel();
        console.setManufacturer("Sony");
        console.setMemoryAmount("1024");
        console.setModel("bash");
        console.setPrice(new BigDecimal("3.2").setScale(2));
        console.setQuantity(11);

        console = purchaseItemService.saveConsole(console);
        List<ConsoleViewModel> list = purchaseItemService.findConsoleByManu(console.getManufacturer());
        assertEquals(1, list.size());
    }

    @Test
    public void saveFindGame() {
        GameViewModel game = new GameViewModel();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);
        game = purchaseItemService.saveGame(game);
        GameViewModel fromService = purchaseItemService.findGameById(game.getGameId());
        assertEquals(game, fromService);
    }

    @Test
    public void findGameByStudio() {
        GameViewModel game = new GameViewModel();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);
        purchaseItemService.saveGame(game);

        GameViewModel game2 = new GameViewModel();
        game2.setDescription("good game");
        game2.setErsbRating("M18+");
        game2.setPrice(new BigDecimal("12.00").setScale(2));
        game2.setStudio("SE");
        game2.setTitle("FF 14");
        game2.setQuantity(50);
        purchaseItemService.saveGame(game2);

        List<GameViewModel> list = purchaseItemService.findGameByStudio("SE");
        assertEquals(2, list.size());
    }

    @Test
    public void findGameByRating() {
        GameViewModel game = new GameViewModel();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);
        game = purchaseItemService.saveGame(game);

        GameViewModel game2 = new GameViewModel();
        game2.setDescription("good game");
        game2.setErsbRating("M16+");
        game2.setPrice(new BigDecimal("12.00").setScale(2));
        game2.setStudio("SE");
        game2.setTitle("FF 14");
        game2.setQuantity(50);
        game2 = purchaseItemService.saveGame(game2);

        List<GameViewModel> list = purchaseItemService.findGameByRating(game2.getErsbRating());
        assertEquals(1, list.size());
        assertEquals(game2, list.get(0));
    }

    @Test
    public void findGameByTitle() {
        GameViewModel game = new GameViewModel();
        game.setDescription("good game");
        game.setErsbRating("M18+");
        game.setPrice(new BigDecimal("12.00").setScale(2));
        game.setStudio("SE");
        game.setTitle("FF 14");
        game.setQuantity(50);
        game = purchaseItemService.saveGame(game);

        GameViewModel game2 = new GameViewModel();
        game2.setDescription("good game");
        game2.setErsbRating("M18+");
        game2.setPrice(new BigDecimal("12.00").setScale(2));
        game2.setStudio("SE");
        game2.setTitle("FF 15");
        game2.setQuantity(50);
        game2 = purchaseItemService.saveGame(game2);

        List<GameViewModel> list = purchaseItemService.findGameByTitle(game2.getTitle());
        assertEquals(1, list.size());
        assertEquals(game2, list.get(0));
    }

    @Test
    public void saveFindTshirt() {
        TshirtViewModel tshirt = new TshirtViewModel();
        tshirt.setColor("red");
        tshirt.setDescription("this is a red tshirt");
        tshirt.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt.setQuantity(30);
        tshirt.setSize("S");

        tshirt = purchaseItemService.saveTshirt(tshirt);
        TshirtViewModel fromService = purchaseItemService.findTshirtById(tshirt.getTshirtId());
        assertEquals(tshirt, fromService);
    }


    @Test
    public void findTshirtByColor() {
        TshirtViewModel tshirt = new TshirtViewModel();
        tshirt.setColor("red");
        tshirt.setDescription("this is a red tshirt");
        tshirt.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt.setQuantity(30);
        tshirt.setSize("S");
        tshirt = purchaseItemService.saveTshirt(tshirt);
        tshirt.setSize("L");
        tshirt = purchaseItemService.saveTshirt(tshirt);
        List<TshirtViewModel> list = purchaseItemService.findTshirtByColor("red");
        assertEquals(2, list.size());
    }

    @Test
    public void findTshirtBySize() {
        TshirtViewModel tshirt = new TshirtViewModel();
        tshirt.setColor("red");
        tshirt.setDescription("this is a red tshirt");
        tshirt.setPrice(BigDecimal.valueOf(13.23).setScale(2));
        tshirt.setQuantity(30);
        tshirt.setSize("S");
        tshirt = purchaseItemService.saveTshirt(tshirt);
        tshirt.setSize("L");
        tshirt = purchaseItemService.saveTshirt(tshirt);
        List<TshirtViewModel> list = purchaseItemService.findTshirtBySize("L");
        assertEquals(1, list.size());
        assertEquals(tshirt, list.get(0));
    }

    @Test
    public void saveFindInvoice() {//the test failed because invoiceDao.addInvoice return a null and I don't know why.
        PurchaseViewModel invoice = new PurchaseViewModel();
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.49).setScale(2));
        processingFee.setProductType("Games");
        processingFee = processingFeeDao.getProcessingFee(processingFee.getProductType());

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setRate(BigDecimal.valueOf(0.05).setScale(2));
        salesTaxRate.setState("NJ");
        salesTaxRate = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());

        Game game1 = new Game();
        game1.setDescription("good game");
        game1.setErsbRating("M18+");
        game1.setPrice(new BigDecimal("12.00").setScale(2));
        game1.setStudio("SE");
        game1.setTitle("FF 14");
        game1.setQuantity(50);
        game1 = gameDao.addGame(game1);

//        invoice.setCity("new port");
//        invoice.setName("sherry");
//        invoice.setStreet("Washington st");
//        invoice.setZipcode("07302");
//        invoice.setItemId(game1.getGameId());
//        invoice.setItemType("Games");
//        invoice.setQuantity(1);
//        invoice.setState("NJ");

        invoice.setCity("new port");
        invoice.setName("sherry");
        invoice.setStreet("Washington st");
        invoice.setZipcode("07302");
        invoice.setItemId(34);
        invoice.setItemType("Games");
        invoice.setProcessingFee(BigDecimal.valueOf(1.49).setScale(2));
        invoice.setState("NJ");
        invoice.setQuantity(1);
        invoice.setUnitPrice(BigDecimal.valueOf(12).setScale(2));
        invoice.setSubtotal(BigDecimal.valueOf(12).setScale(2));
        invoice.setTax(BigDecimal.valueOf(0.06).setScale(2));
        invoice.setTotal(BigDecimal.valueOf(14.09).setScale(2));
        invoice = purchaseItemService.saveInvoice(invoice);
        //invoice.setProcessingFee(BigDecimal.valueOf(1.49));
//        invoice.setState("NJ");
//
//        invoice.setUnitPrice(BigDecimal.valueOf(12.00).setScale(2));
//        invoice.setSubtotal(invoice.getUnitPrice().multiply(BigDecimal.valueOf(invoice.getQuantity())));
//        invoice.setTax(invoice.getSubtotal().multiply(BigDecimal.valueOf(1.05)));
//        invoice.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessingFee()));


        PurchaseViewModel fromService = purchaseItemService.findInvoiceById(invoice.getInvoiceId());
        assertEquals(invoice, fromService);

    }

}