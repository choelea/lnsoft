package com.whjbsoft.www.exam.po;


public class Dtxxs  implements java.io.Serializable {

     private DtxxsId id;
     private String stda;
     private Integer dtdf;



    /** default constructor */
    public Dtxxs() {
    }
    
    public Dtxxs(DtxxsId id) {
		this.id = id;
	}


	/** full constructor */
    public Dtxxs(String stda, Integer dtdf) {
        this.stda = stda;
        this.dtdf = dtdf;
    }

   
    // Property accessors

    public DtxxsId getId() {
        return this.id;
    }
    
    public void setId(DtxxsId id) {
        this.id = id;
    }

    public String getStda() {
        return this.stda;
    }
    
    public void setStda(String stda) {
        this.stda = stda;
    }

    public Integer getDtdf() {
        return this.dtdf;
    }
    
    public void setDtdf(Integer dtdf) {
        this.dtdf = dtdf;
    }
   

}