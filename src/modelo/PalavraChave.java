package modelo;

import java.util.ArrayList;

public class PalavraChave {
    private String palavra;
    private ArrayList<MaterialWeb> listaMateriais = new ArrayList<>();

    public PalavraChave (String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;

    }

    public ArrayList<MaterialWeb> getListaMateriais() {
        return listaMateriais;
    }

    public void adicionarMaterial(MaterialWeb m) {
	    if (!listaMateriais.contains(m)) {
	        listaMateriais.add(m);
	        m.adicionar(this);  
	    }
	}

    public void removerMaterial(MaterialWeb m) {
        if (listaMateriais.contains(m)) {
            listaMateriais.remove(m);
            m.remover(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("palavra = ").append(palavra).append(" | materiais associados = [");

        for (MaterialWeb m : listaMateriais) {
            sb.append(m.getTitulo()).append(", ");
        }

        if (!listaMateriais.isEmpty()) {
            sb.setLength(sb.length() - 2); // remove a última vírgula
        }

        sb.append("]");
        return sb.toString();
    }

}

