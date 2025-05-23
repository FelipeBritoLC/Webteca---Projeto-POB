package modelo;

import java.util.ArrayList;

public class MaterialWeb {
    private String link;
    private String titulo;
    private TipoMaterial tipomaterial;
    private int nota;
    private ArrayList<PalavraChave> listaPalavrasChave = new ArrayList<>(); 

    public MaterialWeb (String link, String titulo, TipoMaterial tipomaterial, int nota) {
        this.link = link;
        this.titulo = titulo;
        this.tipomaterial = tipomaterial;
        setNota(nota);
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

    public void adicionar(PalavraChave p) {
        if (!listaPalavrasChave.contains(p)) {
            listaPalavrasChave.add(p);
            p.adicionarMaterial(this);  
        }
    }

    public void remover(PalavraChave p) {
        if (listaPalavrasChave.contains(p)) {
            listaPalavrasChave.remove(p);
            p.removerMaterial(this);  
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("link = ").append(link)
          .append(", titulo = ").append(titulo)
          .append(", tipomaterial = ").append(tipomaterial.getNome())
          .append(", nota = ").append(nota)
          .append(", palavras-chave = [");

        for (PalavraChave p : listaPalavrasChave) {
            sb.append(p.getPalavra()).append(", ");
        }

        if (!listaPalavrasChave.isEmpty()) {
            sb.setLength(sb.length() - 2); // remove a última vírgula
        }

        sb.append("]");
        return sb.toString();
    }

}
