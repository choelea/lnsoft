package com.whjbsoft.www.po;

import java.util.HashSet;
import java.util.Set;


public class Gwxx  implements java.io.Serializable {


    // Fields    

     private Integer gwzj;
     private String gwmc;
     private Set xsgwxxes = new HashSet(0);


    // Constructors

    /** default constructor */
    public Gwxx() {
    }

    
    /** full constructor */
    public Gwxx(String gwmc, Set xsgwxxes) {
        this.gwmc = gwmc;
        this.xsgwxxes = xsgwxxes;
    }

   
    // Property accessors

    public Integer getGwzj() {
        return this.gwzj;
    }
    
    public void setGwzj(Integer gwzj) {
        this.gwzj = gwzj;
    }

    public String getGwmc() {
        return this.gwmc;
    }
    
    public void setGwmc(String gwmc) {
        this.gwmc = gwmc;
    }

    public Set getXsgwxxes() {
        return this.xsgwxxes;
    }
    
    public void setXsgwxxes(Set xsgwxxes) {
        this.xsgwxxes = xsgwxxes;
    }
   








}