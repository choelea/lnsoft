package com.whjbsoft.www.po;



/**
 * Ysddd generated by MyEclipse - Hibernate Tools
 */

public class Ysddd  implements java.io.Serializable {


    // Fields    

     private YsdddId id;
     private Ysddxx ysddxx;
     private Yspsd yspsd;


    // Constructors

    /** default constructor */
    public Ysddd() {
    }

    
    /** full constructor */
    public Ysddd(Ysddxx ysddxx, Yspsd yspsd) {
        this.ysddxx = ysddxx;
        this.yspsd = yspsd;
    }

   
    // Property accessors

    public YsdddId getId() {
        return this.id;
    }
    
    public void setId(YsdddId id) {
        this.id = id;
    }

    public Ysddxx getYsddxx() {
        return this.ysddxx;
    }
    
    public void setYsddxx(Ysddxx ysddxx) {
        this.ysddxx = ysddxx;
    }

    public Yspsd getYspsd() {
        return this.yspsd;
    }
    
    public void setYspsd(Yspsd yspsd) {
        this.yspsd = yspsd;
    }
   








}