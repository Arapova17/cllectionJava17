package map;

public class Alma {
    private String alma;
    private String almurut;
    private String alcha;
    private String getAlma;
    private String getAlcha;

    public Alma(String alma, String almurut, String alcha, String getAlma, String getAlcha) {
        this.alma = alma;
        this.almurut = almurut;
        this.alcha = alcha;
        this.getAlma = getAlma;
        this.getAlcha = getAlcha;
    }

    public String alma() {
        return alma;
    }

    public void setAlma(String alma) {
        this.alma = alma;
    }

    public String almurut() {
        return almurut;
    }

    public void setAlmurut(String almurut) {
        this.almurut = almurut;
    }

    public String alcha() {
        return alcha;
    }

    public void setAlcha(String alcha) {
        this.alcha = alcha;
    }

    public String getAlma() {
        return getAlma;
    }

    public void setGetAlma(String getAlma) {
        this.getAlma = getAlma;
    }

    public String getAlcha() {
        return getAlcha;
    }

    public void setGetAlcha(String getAlcha) {
        this.getAlcha = getAlcha;
    }
}
