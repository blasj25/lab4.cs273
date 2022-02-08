package cs301.birthdaycake;

public class CakeModel {
    public boolean isLit = true;
    public int numCandles = 2;
    public boolean isFrosting = true;
    public boolean hasCandles = true;

    public boolean getLit(){
        return isLit;
    }
    public void isLit(boolean flame){
        isLit = flame;
    }

    public void setHasCandles(boolean does){
        hasCandles = does;
    }
    public boolean isHasCandles(){
        return hasCandles;
    }

    public int whatNumCandles(){
        return numCandles;
    }
    public void setNumCandles(int newNumCandles){
        numCandles = newNumCandles;
    }

    public boolean isFrosted(){return isFrosting;}
    public void setFrosting(boolean newFrosted){
        isFrosting = newFrosted;
    }
}
