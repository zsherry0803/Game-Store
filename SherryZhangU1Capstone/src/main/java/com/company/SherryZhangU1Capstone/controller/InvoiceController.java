package com.company.SherryZhangU1Capstone.controller;

import com.company.SherryZhangU1Capstone.exception.NotFoundException;
import com.company.SherryZhangU1Capstone.service.PurchaseItemService;
import com.company.SherryZhangU1Capstone.viewmodel.PurchaseViewModel;
import com.company.SherryZhangU1Capstone.viewmodel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    PurchaseItemService purchaseItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseViewModel createInvoice(@RequestBody @Valid PurchaseViewModel purchaseViewModel) {
        return purchaseItemService.saveInvoice(purchaseViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PurchaseViewModel getTshirt(@PathVariable("id") int id) {
        PurchaseViewModel purchaseViewModel = purchaseItemService.findInvoiceById(id);
        if (purchaseViewModel == null)
            throw new NotFoundException("Invoice could not be retrieved for id " + id);
        return purchaseViewModel;
    }
}
