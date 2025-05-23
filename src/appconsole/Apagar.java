package appconsole;

import java.util.List;
import java.util.ArrayList;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.MaterialWeb;

public class Apagar {
    private static ObjectContainer manager;

    public static void main(String[] args) {
        manager = Util.conectarBanco();
        System.out.println("Apagando o material com título: 'Fundamentos da computação'");

        // Localizar o material
        Query q = manager.query();
        q.constrain(MaterialWeb.class);
        q.descend("titulo").constrain("Fundamentos da computação");
        List<MaterialWeb> resultado = q.execute();

        if (!resultado.isEmpty()) {
            MaterialWeb material = resultado.get(0);

            // Evitar ConcurrentModificationException
            new ArrayList<>(material.getListaPalavrasChave()).forEach(palavra -> {
                palavra.removerMaterial(material);
                manager.store(palavra);
            });

            manager.delete(material);
            manager.commit();

            System.out.println("Material e seus relacionamentos foram removidos com sucesso.");
        } else {
            System.out.println("Material não encontrado.");
        }

        Util.desconectar();
        System.out.println("Fim da aplicação.");
    }
}
