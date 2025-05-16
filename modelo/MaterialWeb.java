import java.util.ArrayList;

public class MaterialWeb {
    private String link;
    private String titulo;
    private TipoMaterial tipomaterial;
    private int nota;
    private ArrayList<PalavraChave> listaPalavrasChave = new ArrayList<>(); 

    public MaterialWeb (String link, String titulo, TipoMaterial tipomaterial, int nota, ArrayList<PalavraChave> listaPalavrasChave) {
        this.link = link;
        this.titulo = titulo;
        this.tipomaterial = tipomaterial;
        setNota(nota);
        this.listaPalavrasChave = listaPalavrasChave;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoMaterial getTipomaterial() {
        return tipomaterial;
    }

    public void setTipomaterial(TipoMaterial tipomaterial) {
        this.tipomaterial = tipomaterial;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("Nota deve estar entre 1 e 5."); //restrição pra a nota ser obrigatoriamente de 1 a 5
        }
        this.nota = nota;
    }

    public ArrayList<PalavraChave> getListaPalavrasChave() {
        return listaPalavrasChave;
    }


    public String toString() {
        return "MaterialWeb [link=" + link + ", titulo=" + titulo + ", tipomaterial=" + tipomaterial + ", nota=" + nota + "]";
    }

}
