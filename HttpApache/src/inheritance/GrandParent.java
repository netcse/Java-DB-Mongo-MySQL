package inheritance;

public  class GrandParent extends  GrandFather {

    public GrandFather gf;
    public GrandMother gm;

    public String grandFatherPrint(){
        return gf.getGrandFather();
    }

    public String grandMotherPrint(){
        return gm.getGrandMother();
    }

}
