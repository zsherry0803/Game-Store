package com.company.SherryZhangU1Capstone.service;

import com.company.SherryZhangU1Capstone.dao.*;
import com.company.SherryZhangU1Capstone.model.*;
import com.company.SherryZhangU1Capstone.viewmodel.ConsoleViewModel;
import com.company.SherryZhangU1Capstone.viewmodel.GameViewModel;
import com.company.SherryZhangU1Capstone.viewmodel.PurchaseViewModel;
import com.company.SherryZhangU1Capstone.viewmodel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseItemService {
    ConsoleDao consoleDao;
    GameDao gameDao;
    TshirtDao tshirtDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;

    @Autowired
    public PurchaseItemService(ConsoleDao consoleDao, GameDao gameDao, TshirtDao tshirtDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.tshirtDao = tshirtDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
    }

    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setModel(consoleViewModel.getModel());
        console.setQuantity(consoleViewModel.getQuantity());
        console = consoleDao.addConsole(console);
        consoleViewModel.setGameId(console.getGameId());
        return consoleViewModel;
    }

    public void removeConsole(int id) {
        consoleDao.deleteConsole(id);
    }

    public void updateConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setModel(consoleViewModel.getModel());
        console.setQuantity(consoleViewModel.getQuantity());
        consoleDao.updateConsole(console);
    }

    public ConsoleViewModel findConsoleById(int id) {
        Console console = new Console();
        console = consoleDao.getConsole(id);
        if(console == null)
            return null;
        else
            return buildConsoleVM(console);
    }

    public List<ConsoleViewModel> findConsoleByManu(String manu) {
        List<Console> list = consoleDao.getConsolesByManufacturer(manu);
        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();
        for (Console console : list) {
            consoleViewModelList.add(buildConsoleVM(console));
        }
        return consoleViewModelList;
    }

    public GameViewModel saveGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setDescription(gameViewModel.getDescription());
        game.setTitle(gameViewModel.getTitle());
        game.setStudio(gameViewModel.getStudio());
        game.setErsbRating(gameViewModel.getErsbRating());
        game.setQuantity(gameViewModel.getQuantity());
        game.setPrice(gameViewModel.getPrice());
        game = gameDao.addGame(game);
        gameViewModel.setGameId(game.getGameId());
        return gameViewModel;
    }

    public GameViewModel findGameById(int id) {
        Game game = gameDao.getGame(id);
        if (game == null) {
            return null;
        }else {
            return buildGameVM(game);
        }
    }

    public void updateGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setDescription(gameViewModel.getDescription());
        game.setTitle(gameViewModel.getTitle());
        game.setStudio(gameViewModel.getStudio());
        game.setErsbRating(gameViewModel.getErsbRating());
        game.setQuantity(gameViewModel.getQuantity());
        game.setPrice(gameViewModel.getPrice());
        game.setGameId(gameViewModel.getGameId());
        gameDao.updateGame(game);
    }

    public void removeGame(int id) {
        gameDao.deleteGame(id);

    }

    public List<GameViewModel> findGameByStudio(String studio){
        List<Game> list = gameDao.getGameByStudio(studio);
        List<GameViewModel> gameViewModelList = new ArrayList<>();
        for (Game game : list) {
            gameViewModelList.add(buildGameVM(game));
        }
        return gameViewModelList;
    }

    public List<GameViewModel> findGameByRating(String rating){
        List<Game> list = gameDao.getGameByRating(rating);
        List<GameViewModel> gameViewModelList = new ArrayList<>();
        for (Game game : list) {
            gameViewModelList.add(buildGameVM(game));
        }
        return gameViewModelList;
    }

    public List<GameViewModel> findGameByTitle(String title){
        List<Game> list = gameDao.getGameByTitle(title);
        List<GameViewModel> gameViewModelList = new ArrayList<>();
        for (Game game : list) {
            gameViewModelList.add(buildGameVM(game));
        }
        return gameViewModelList;
    }

    public TshirtViewModel saveTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt = new Tshirt();
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setQuantity(tshirtViewModel.getQuantity());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt = tshirtDao.addTshirt(tshirt);
        tshirtViewModel.setTshirtId(tshirt.getTshirtId());
        return tshirtViewModel;
    }

    public TshirtViewModel findTshirtById(int id) {
        Tshirt tshirt = tshirtDao.getTshirt(id);
        if (tshirt == null) {
            return null;
        }else {
            return buildTshirtVM(tshirt);
        }
    }

    public void updateTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt = new Tshirt();
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setQuantity(tshirtViewModel.getQuantity());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt.setTshirtId(tshirtViewModel.getTshirtId());
        tshirtDao.updateTshirt(tshirt);
    }

    public void removeTshirt(int id) {
        tshirtDao.deleteTshirt(id);
    }

    public List<TshirtViewModel> findTshirtByColor(String color) {
        List<Tshirt> list = tshirtDao.getTshirtsByColor(color);
        List<TshirtViewModel> tshirtViewModelList = new ArrayList<>();
        for (Tshirt tshirt : list) {
            tshirtViewModelList.add(buildTshirtVM(tshirt));
        }
        return tshirtViewModelList;
    }

    public List<TshirtViewModel> findTshirtBySize(String size) {
        List<Tshirt> list = tshirtDao.getTshirtsBySize(size);
        List<TshirtViewModel> tshirtViewModelList = new ArrayList<>();
        for (Tshirt tshirt : list) {
            tshirtViewModelList.add(buildTshirtVM(tshirt));
        }
        return tshirtViewModelList;
    }

    @Transactional
    public PurchaseViewModel saveInvoice(PurchaseViewModel purchaseViewModel) {
        switch (purchaseViewModel.getItemType()) {
            case "Games":
                Game game = gameDao.getGame(purchaseViewModel.getItemId());
                purchaseViewModel.setUnitPrice(game.getPrice().setScale(2));
                if (purchaseViewModel.getQuantity() > game.getQuantity()) {
                    throw new IllegalArgumentException("the storage of " + purchaseViewModel.getItemType() + " is not enough, purchase failed.");
                }
                game.setQuantity(game.getQuantity() - purchaseViewModel.getQuantity());
                gameDao.updateGame(game);
                break;
            case "T-Shirts":
                Tshirt tshirt = tshirtDao.getTshirt(purchaseViewModel.getItemId());
                purchaseViewModel.setUnitPrice(tshirt.getPrice().setScale(2));

                if (purchaseViewModel.getQuantity() > tshirt.getQuantity()) {
                    throw new IllegalArgumentException("the storage of " + purchaseViewModel.getItemType() + " is not enough, purchase failed.");
                }
                tshirt.setQuantity(tshirt.getQuantity() - purchaseViewModel.getQuantity());
                tshirtDao.updateTshirt(tshirt);
                break;
            case "Consoles":
                Console console = consoleDao.getConsole(purchaseViewModel.getItemId());
                purchaseViewModel.setUnitPrice(console.getPrice().setScale(2));
                if (purchaseViewModel.getQuantity() > console.getQuantity()) {
                    throw new IllegalArgumentException("the storage of " + purchaseViewModel.getItemType() + " is not enough, purchase failed.");
                }
                console.setQuantity(console.getQuantity() - purchaseViewModel.getQuantity());
                consoleDao.updateConsole(console);
                break;
                default:
                    throw new IllegalArgumentException("the item type can only be Games, T-Shirts or Consoles");
        }
        purchaseViewModel.setSubtotal(purchaseViewModel.getUnitPrice().multiply(BigDecimal.valueOf(purchaseViewModel.getQuantity())).setScale(2));
        purchaseViewModel.setTax((salesTaxRateDao.getSalesTaxRate(purchaseViewModel.getState()).getRate()).multiply(purchaseViewModel.getSubtotal()).setScale(2));
        purchaseViewModel.setProcessingFee(processingFeeDao.getProcessingFee(purchaseViewModel.getItemType()).getFee());
        if (purchaseViewModel.getQuantity() > 10) {
            purchaseViewModel.setProcessingFee(purchaseViewModel.getProcessingFee().add(BigDecimal.valueOf(15.49)));
        }
        purchaseViewModel.setTotal(purchaseViewModel.getSubtotal().add(purchaseViewModel.getProcessingFee()).add(purchaseViewModel.getTax()));

        Invoice invoice = new Invoice();
        invoice.setState(purchaseViewModel.getState());
        invoice.setZipcode(purchaseViewModel.getZipcode());
        invoice.setQuantity(purchaseViewModel.getQuantity());
        invoice.setItemType(purchaseViewModel.getItemType());
        invoice.setStreet(purchaseViewModel.getStreet());
        invoice.setCity(purchaseViewModel.getCity());
        invoice.setName(purchaseViewModel.getName());

        invoice.setTotal(purchaseViewModel.getTotal());
        invoice.setTax(purchaseViewModel.getTax());
        invoice.setSubtotal(purchaseViewModel.getSubtotal());
        invoice.setProcessingFee(purchaseViewModel.getProcessingFee());
        invoice.setUnitPrice(purchaseViewModel.getUnitPrice());
        invoice.setItemId(purchaseViewModel.getItemId());
        invoice = invoiceDao.addInvoice(invoice);

        return buildPurchaseVM(invoice);
    }

    public PurchaseViewModel findInvoiceById(int id){
        Invoice invoice = invoiceDao.getInvoice(id);
        if (invoice == null) {
            return null;
        }else {
            return buildPurchaseVM(invoice);
        }
    }

    private ConsoleViewModel buildConsoleVM(Console console) {
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setGameId(console.getGameId());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());
        consoleViewModel.setProcessor(console.getProcessor());
        return consoleViewModel;
    }

    private TshirtViewModel buildTshirtVM(Tshirt tshirt) {
        TshirtViewModel tshirtViewModel = new TshirtViewModel();
        tshirtViewModel.setTshirtId(tshirt.getTshirtId());
        tshirtViewModel.setSize(tshirt.getSize());
        tshirtViewModel.setColor(tshirt.getColor());
        tshirtViewModel.setDescription(tshirt.getDescription());
        tshirtViewModel.setPrice(tshirt.getPrice());
        tshirtViewModel.setQuantity(tshirt.getQuantity());

        return tshirtViewModel;
    }

    private GameViewModel buildGameVM(Game game) {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setGameId(game.getGameId());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setErsbRating(game.getErsbRating());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setQuantity(game.getQuantity());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setTitle(game.getTitle());
        return gameViewModel;
    }

    private PurchaseViewModel buildPurchaseVM(Invoice invoice) {
//        ProcessingFee processingFee = processingFeeDao.getProcessingFee(invoice.getItemType());
//        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRate(invoice.getState());
        PurchaseViewModel purchaseViewModel = new PurchaseViewModel();

        purchaseViewModel.setTax(invoice.getTax());
        purchaseViewModel.setProcessingFee(invoice.getProcessingFee());

        purchaseViewModel.setCity(invoice.getCity());
        purchaseViewModel.setItemId(invoice.getItemId());
        purchaseViewModel.setItemType(invoice.getItemType());
        purchaseViewModel.setName(invoice.getName());
        purchaseViewModel.setQuantity(invoice.getQuantity());
        purchaseViewModel.setState(invoice.getState());
        purchaseViewModel.setStreet(invoice.getStreet());
        purchaseViewModel.setSubtotal(invoice.getSubtotal());
        purchaseViewModel.setZipcode(invoice.getZipcode());
        purchaseViewModel.setTotal(invoice.getTotal());
        purchaseViewModel.setUnitPrice(invoice.getUnitPrice());
        purchaseViewModel.setInvoiceId(invoice.getInvoiceId());

//        switch (invoice.getItemType()) {
//            case "Games":
//                Game game = gameDao.getGame(invoice.getItemId());
//                purchaseViewModel.setUnitPrice(game.getPrice());
//                if (invoice.getQuantity() > game.getQuantity()) {
//                    throw new IllegalArgumentException("the storage of " + invoice.getItemType() + " is not enough, purchase failed.");
//                }
//                break;
//            case "Tshirt":
//                Tshirt tshirt = tshirtDao.getTshirt(invoice.getItemId());
//                purchaseViewModel.setUnitPrice(tshirt.getPrice());
//
//                if (invoice.getQuantity() > tshirt.getQuantity()) {
//                    throw new IllegalArgumentException("the storage of " + invoice.getItemType() + " is not enough, purchase failed.");
//                }
//                break;
//            case "Console":
//                Console console = consoleDao.getConsole(invoice.getItemId());
//                purchaseViewModel.setUnitPrice(console.getPrice());
//                if (invoice.getQuantity() > console.getQuantity()) {
//                    throw new IllegalArgumentException("the storage of " + invoice.getItemType() + " is not enough, purchase failed.");
//                }
//                break;
//        }
        //purchaseViewModel.setSalesTaxRate(salesTaxRateDao.getSalesTaxRate(invoice.getState()));



        return purchaseViewModel;
    }

}
