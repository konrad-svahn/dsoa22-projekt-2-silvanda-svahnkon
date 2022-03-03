public class Language {

    private LangLabel label;
    private double analys1; 
    private double analys2; 
    private double analys3;
    
    public Language(LangLabel label) {
        this.label = label;
    }

    public double getFinalDiference() {
        double sum = analys1 + analys2 + analys3;
        return sum / 3; 
    }

    public LangLabel getLabel() {
        return label;
    }

    public double getAnalys1() {
        return analys1;
    }

    public void setAnalys1(double analys1) {
        this.analys1 = analys1;
    }

    public double getAnalys2() {
        return analys2;
    }

    public void setAnalys2(double analys2) {
        this.analys2 = analys2;
    }

    public double getAnalys3() {
        return analys3;
    }

    public void setAnalys3(double analys3) {
        this.analys3 = analys3;
    }
}
