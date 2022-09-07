package com.hahahey.future;

/**
 * @author hahahey
 * @date 2022-04-15 0:13
 */
public class RealData implements Data{

    protected String result;

    public RealData(String dataStr){
        this.result = dataStr;
    }

    @Override
    public String getData() {
        return result;
    }
}
