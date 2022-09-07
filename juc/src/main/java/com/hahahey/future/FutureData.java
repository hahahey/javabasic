package com.hahahey.future;

/**
 * @author hahahey
 * @date 2022-04-15 0:15
 */
public class FutureData implements Data{

    //包含了realData
    protected RealData realData;
    protected boolean isReady = false;


    public synchronized void  setData(RealData realData){
        if(isReady){
            return;
        }
        isReady = true;
        this.realData = realData;
        notifyAll();
    }

    @Override
    public synchronized  String getData() {
        while (!isReady){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        return realData.result;
    }


}
