package modelo;

public class TipoMaterial {
    private String nome; //video, site, apostila, livro, slides, etc

    public TipoMaterial (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "nome = " + nome;
    }
      
}

