/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omar
 */
public class PyramidCSVDAO {
    private Pyramid p;
    private List<Pyramid> Pyramids;
    public PyramidCSVDAO() {
      this.Pyramids= new ArrayList<Pyramid>();
        
    }
    public List<Pyramid> readPyramidsFromCsv(String file_path)
    {   
        try {
            
            Scanner sc = new Scanner(new File(file_path)); 
            
            //sc.useDelimiter(",");   //sets the delimiter pattern  
            String line=sc.nextLine();
            while (sc.hasNext())  //returns a boolean value  
            {  
            line=sc.nextLine();    
            this.Pyramids.add(this.createPyramid(line.split(",")));
            }   
            sc.close();  //closes the scanner  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
        return Pyramids;
    }
    
    public Pyramid createPyramid(String [] data)
    {
     double height=Double.parseDouble(data[7].equals("") ? "0" :data[7]);
     String modern_name=data[2];
     String pharaoh = data[0].endsWith(" (?)") ? data[0].replace(" (?)",""):data[0];
     String site=data[4];
      
     this.p=new Pyramid( height,modern_name,pharaoh,site);
     return p;
    
    
    }
    
}
