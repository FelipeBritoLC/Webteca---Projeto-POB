import java.util.ArrayList;

public class PalavraChave {
    private String palavra;
    private ArrayList<TipoMaterial> listaMateriais = new ArrayList<>();

    public PalavraChave (String palavra, ArrayList<TipoMaterial> listaMateriais) {
        this.palavra = palavra;
        this.listaMateriais = listaMateriais;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;

    }

    public ArrayList<TipoMaterial> getListaMateriais() {
        return listaMateriais;
    }


    public String toString() {
        return "PalavraChave [palavra=" + palavra + "]";
    }
   
}
