public class CharPrevalance {
    private String character;
    private int stringLength;
    private int amount;

    public CharPrevalance(String character, int amount, int stringLength) {
        this.character = character;
        this.amount = amount;
        this.setStringLength(stringLength); 
    }

    public double getProcentOfTotalString() {
        Double lengthToDouble = (double) (this.stringLength);
        Double amountToDouble = (double) (this.amount);
        Double mod = 100 / lengthToDouble;
        return amountToDouble * mod;
    }

    public int getStringLength() {
        return stringLength;
    } 

    public void setStringLength(int stringLength) {
        this.stringLength = stringLength;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
