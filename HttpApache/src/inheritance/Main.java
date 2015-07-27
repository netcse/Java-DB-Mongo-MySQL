package inheritance;

public class Main extends GrandParent {

    public void grandParentSet(){
        this.gf.grandFatherSet("Dada");
        this.gm.grandMotherSet("Dadi");
    }

    public void grandParentFetch(){
        this.grandFatherPrint();
        this.grandMotherPrint();
    }

    public static void main(String[] args) {
        Main mn = new Main();
        mn.grandParentSet();
        mn.grandParentFetch();
    }
}
