package com.giannini.methodarg;

/**
 * Created by Fenglin on 2017/6/21.
 */
public class Test1 {

    private Integer totalCnt = 0;

    private Integer totalYcnt = 0;


    private Integer totalNcnt = 0;

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getTotalYcnt() {
        return totalYcnt;
    }

    public void setTotalYcnt(int totalYcnt) {
        this.totalYcnt = totalYcnt;
    }

    public int getTotalNcnt() {
        return totalNcnt;
    }

    public void setTotalNcnt(int totalNcnt) {
        this.totalNcnt = totalNcnt;
    }


    public void addTotalCnt(int cnt) {
        this.totalCnt += cnt;
    }

    public void addYcnt(int ycnt) {
        this.totalYcnt += ycnt;
    }

    public void addNcnt(int ncnt) {
        this.totalNcnt += ncnt;
    }
}
