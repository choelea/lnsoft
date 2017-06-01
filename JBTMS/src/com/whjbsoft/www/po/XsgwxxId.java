package com.whjbsoft.www.po;



/**
 * XsgwxxId generated by MyEclipse - Hibernate Tools
 */

public class XsgwxxId  implements java.io.Serializable {

     private Gwxx gwxx;
     private Xsxx xsxx;


    public XsgwxxId() {
    }

    public XsgwxxId(Gwxx gwxx, Xsxx xsxx) {
        this.gwxx = gwxx;
        this.xsxx = xsxx;
    }


    public Gwxx getGwxx() {
        return this.gwxx;
    }
    
    public void setGwxx(Gwxx gwxx) {
        this.gwxx = gwxx;
    }

    public Xsxx getXsxx() {
        return this.xsxx;
    }
    
    public void setXsxx(Xsxx xsxx) {
        this.xsxx = xsxx;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof XsgwxxId) ) return false;
		 XsgwxxId castOther = ( XsgwxxId ) other; 
         
		 return ( (this.getGwxx()==castOther.getGwxx()) || ( this.getGwxx()!=null && castOther.getGwxx()!=null && this.getGwxx().equals(castOther.getGwxx()) ) )
 && ( (this.getXsxx()==castOther.getXsxx()) || ( this.getXsxx()!=null && castOther.getXsxx()!=null && this.getXsxx().equals(castOther.getXsxx()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getGwxx() == null ? 0 : this.getGwxx().hashCode() );
         result = 37 * result + ( getXsxx() == null ? 0 : this.getXsxx().hashCode() );
         return result;
   }   





}