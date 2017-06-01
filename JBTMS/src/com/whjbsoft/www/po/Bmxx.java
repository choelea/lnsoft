package com.whjbsoft.www.po;



public class Bmxx  implements java.io.Serializable {


    // Fields    

     private Integer bmzj;
     private String bmbh;
     private String bmmc;
     private String bmdh;
     private String bzxx;
     private String ssjg;
     private Integer ssxs;
     private Integer sssysz;


    // Constructors

    /** default constructor */
    public Bmxx() {
    }

    
    /** full constructor */
    public Bmxx(String bmbh, String bmmc, String bmdh, String bzxx, String ssjg, Integer ssxs, Integer sssysz) {
        this.bmbh = bmbh;
        this.bmmc = bmmc;
        this.bmdh = bmdh;
        this.bzxx = bzxx;
        this.ssjg = ssjg;
        this.ssxs = ssxs;
        this.sssysz = sssysz;
    }

   
    // Property accessors

    public Integer getBmzj() {
        return this.bmzj;
    }
    
    public void setBmzj(Integer bmzj) {
        this.bmzj = bmzj;
    }

    public String getBmbh() {
        return this.bmbh;
    }
    
    public void setBmbh(String bmbh) {
        this.bmbh = bmbh;
    }

    public String getBmmc() {
        return this.bmmc;
    }
    
    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public String getBmdh() {
        return this.bmdh;
    }
    
    public void setBmdh(String bmdh) {
        this.bmdh = bmdh;
    }

    public String getBzxx() {
        return this.bzxx;
    }
    
    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

    public String getSsjg() {
        return this.ssjg;
    }
    
    public void setSsjg(String ssjg) {
        this.ssjg = ssjg;
    }

    public Integer getSsxs() {
        return this.ssxs;
    }
    
    public void setSsxs(Integer ssxs) {
        this.ssxs = ssxs;
    }

    public Integer getSssysz() {
        return this.sssysz;
    }
    
    public void setSssysz(Integer sssysz) {
        this.sssysz = sssysz;
    }
   








}