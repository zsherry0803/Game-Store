package com.company.SherryZhangU1Capstone.dao;


import com.company.SherryZhangU1Capstone.model.Tshirt;

import java.util.List;

//a. Perform standard CRUD operations for T-Shirts
//        b. Search for T-Shirts by Color
//        c. Search for T-Shirts by Size
//        d. You must create a separate DAO for T-Shirts
public interface TshirtDao {
    Tshirt addTshirt(Tshirt tshirt);
    Tshirt getTshirt(int id);
    void updateTshirt(Tshirt tshirt);
    void deleteTshirt(int id);
    List<Tshirt> getAllTshirts();
    List<Tshirt> getTshirtsByColor(String color);
    List<Tshirt> getTshirtsBySize(String size);

}
