package com.company.SherryZhangU1Capstone.dao;

import com.company.SherryZhangU1Capstone.model.Console;

import java.util.List;

//a. Perform standard CRUD operations for Consoles
//        b. Search for Consoles by Manufacturer
//        c. You must create a separate DAO for Consoles
public interface ConsoleDao {
    Console addConsole(Console console);
    Console getConsole(int id);
    void updateConsole(Console console);
    void deleteConsole(int id);
    List<Console> getAllConsoles();
    List<Console> getConsolesByManufacturer(String manufacturer);

}
