/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

import java.util.List;

/**
 *
 * @author Omar
 */
public class MainClass {
    public static void main(String[] args){
    PyramidCSVDAO p = new PyramidCSVDAO();
    List<Pyramid> Pyramids= p.readPyramidsFromCsv("E:\\fcih\\COURSES\\iti\\java\\day2\\Session03_Assignments\\pyramids.csv");

    for (Pyramid x:Pyramids)
    {
        System.out.println(x.toString());
    }
    }
}
