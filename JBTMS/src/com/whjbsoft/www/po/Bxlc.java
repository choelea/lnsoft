package com.whjbsoft.www.po;



/**
 * Bxlc generated by MyEclipse - Hibernate Tools
 */

public class Bxlc  implements java.io.Serializable {


    // Fields    

     private Integer bxlczj;
     private Bxxx bxxx;
     private String bxzd;
     private Integer tksx;


    // Constructors

    /** default constructor */
    public Bxlc() {
    }

    
    /** full constructor */
    public Bxlc(Bxxx bxxx, String bxzd, Integer tksx) {
        this.bxxx = bxxx;
        this.bxzd = bxzd;
        this.tksx = tksx;
    }

   
    // Property accessors

    public Integer getBxlczj() {
        return this.bxlczj;
    }
    
    public void setBxlczj(Integer bxlczj) {
        this.bxlczj = bxlczj;
    }

    public Bxxx getBxxx() {
        return this.bxxx;
    }
    
    public void setBxxx(Bxxx bxxx) {
        this.bxxx = bxxx;
    }

    public String getBxzd() {
        return this.bxzd;
    }
    
    public void setBxzd(String bxzd) {
        this.bxzd = bxzd;
    }

    public Integer getTksx() {
        return this.tksx;
    }
    
    public void setTksx(Integer tksx) {
        this.tksx = tksx;
    }
   








}