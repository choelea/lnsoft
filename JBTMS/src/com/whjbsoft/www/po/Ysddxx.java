package com.whjbsoft.www.po;

import java.util.HashSet;
import java.util.Set;


/**
 * Ysddxx generated by MyEclipse - Hibernate Tools
 */

public class Ysddxx  implements java.io.Serializable {


    // Fields    

     private Integer ysddzj;
     private String ysddbh;
     private String ysddlx;
     private String ysfs;
     private Integer ysddzt;
     private Integer sfpg;
     private Integer sfpc;
     private Integer ssxs;
     private Integer sssysz;
     private Set ysrydds = new HashSet(0);
     private Set xlyhs = new HashSet(0);
     private Set ysddds = new HashSet(0);
     private Set yscldds = new HashSet(0);


    // Constructors

    /** default constructor */
    public Ysddxx() {
    }

    
    /** full constructor */
    public Ysddxx(String ysddbh, String ysddlx, String ysfs, Integer ysddzt, Integer ssxs, Integer sssysz, Set ysrydds, Set xlyhs, Set ysddds, Set yscldds) {
        this.ysddbh = ysddbh;
        this.ysddlx = ysddlx;
        this.ysfs = ysfs;
        this.ysddzt = ysddzt;
        this.ssxs = ssxs;
        this.sssysz = sssysz;
        this.ysrydds = ysrydds;
        this.xlyhs = xlyhs;
        this.ysddds = ysddds;
        this.yscldds = yscldds;
    }

   
    // Property accessors

    public Integer getYsddzj() {
        return this.ysddzj;
    }
    
    public void setYsddzj(Integer ysddzj) {
        this.ysddzj = ysddzj;
    }

    public String getYsddbh() {
        return this.ysddbh;
    }
    
    public void setYsddbh(String ysddbh) {
        this.ysddbh = ysddbh;
    }

    public String getYsddlx() {
        return this.ysddlx;
    }
    
    public void setYsddlx(String ysddlx) {
        this.ysddlx = ysddlx;
    }

    public String getYsfs() {
        return this.ysfs;
    }
    
    public void setYsfs(String ysfs) {
        this.ysfs = ysfs;
    }

    public Integer getYsddzt() {
        return this.ysddzt;
    }
    
    public void setYsddzt(Integer ysddzt) {
        this.ysddzt = ysddzt;
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

    public Set getYsrydds() {
        return this.ysrydds;
    }
    
    public void setYsrydds(Set ysrydds) {
        this.ysrydds = ysrydds;
    }

    public Set getXlyhs() {
        return this.xlyhs;
    }
    
    public void setXlyhs(Set xlyhs) {
        this.xlyhs = xlyhs;
    }

    public Set getYsddds() {
        return this.ysddds;
    }
    
    public void setYsddds(Set ysddds) {
        this.ysddds = ysddds;
    }

    public Set getYscldds() {
        return this.yscldds;
    }
    
    public void setYscldds(Set yscldds) {
        this.yscldds = yscldds;
    }

	public Integer getSfpc() {
		return sfpc;
	}
	
	public void setSfpc(Integer sfpc) {
		this.sfpc = sfpc;
	}
	
	public Integer getSfpg() {
		return sfpg;
	}

	public void setSfpg(Integer sfpg) {
		this.sfpg = sfpg;
	}
}