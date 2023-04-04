package com.driver;

public class F1 extends Car {

    public F1(String name, boolean isManual) {

        super(name,4,0,6,isManual,"F1",1);
        //Use arbitrary values for parameters which are not mentioned
    }

    public void accelerate(int rate){
        int newSpeed = 0; //set the value of new speed by using currentSpeed and rate
        /**
         * speed 0: gear 1
         * speed 1-50: gear 1
         * speed 51-100: gear 2
         * speed 101-150: gear 3
         * speed 151-200: gear 4
         * speed 201-250: gear 5
         * speed more than 250: gear 6
         */
        newSpeed = super.getCurrentSpeed() + rate;

        if(newSpeed <= 0) {
            //Stop the car, set gear as 1
            super.changeGear(1);
            changeSpeed(newSpeed,0);
        }
        //for all other cases, change the gear accordingly
        else{
            int newGear = 1;

            if(newSpeed >=0 && newSpeed <=50) newGear = 1;
            else if(newSpeed >=51 && newSpeed <=100) newGear = 2;
            else if(newSpeed >=101 && newSpeed <=150) newGear = 3;
            else if(newSpeed >=151 && newSpeed <=200) newGear = 4;
            else if(newSpeed >=201 && newSpeed <=250) newGear = 5;
            else newGear = 6;

            super.changeGear(newGear);
            super.changeSpeed(newSpeed, super.getCurrentDirection());
        }
    }

}
