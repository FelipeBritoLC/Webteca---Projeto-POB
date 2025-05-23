package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.MaterialWeb;
import modelo.PalavraChave;

public class Alterar {
	private static ObjectContainer manager;

	public static void main(String[] args) {
		manager = Util.conectarBanco();

		// ----------- REMOVENDO RELACIONAMENTO -----------

		String tituloMaterial = "Introdução a programação";
		String nomePalavraChave = "computacao";

		Query q1 = manager.query();
		q1.constrain(MaterialWeb.class);
		q1.descend("titulo").constrain(tituloMaterial);
		List<MaterialWeb> materiais = q1.execute();

		if (materiais.isEmpty()) {
			System.out.println("Material não encontrado para remoção.");
		} else {
			MaterialWeb material = materiais.get(0);

			Query q2 = manager.query();
			q2.constrain(PalavraChave.class);
			q2.descend("palavra").constrain(nomePalavraChave);
			List<PalavraChave> palavras = q2.execute();

			if (palavras.isEmpty()) {
				System.out.println("Palavra-chave não encontrada para remoção.");
			} else {
				PalavraChave palavra = palavras.get(0);

				if (material.getListaPalavrasChave().contains(palavra)) {
					material.remover(palavra);
					manager.store(material);
					manager.store(palavra);
					manager.commit();
					System.out.println("Relacionamento removido com sucesso.");
				} else {
					System.out.println("Essa palavra-chave já não estava associada a esse material.");
				}
			}
		}

		// ----------- ADICIONANDO RELACIONAMENTO -----------

		String tituloMat = "Introdução a programação";
		String nomePalavra = "fundamentos";

		Query q3 = manager.query();
		q3.constrain(MaterialWeb.class);
		q3.descend("titulo").constrain(tituloMat);
		List<MaterialWeb> materiais1 = q3.execute();

		if (materiais1.isEmpty()) {
			System.out.println("Material não encontrado.");
		} else {
			MaterialWeb material1 = materiais1.get(0);

			Query q4 = manager.query();
			q4.constrain(PalavraChave.class);
			q4.descend("palavra").constrain(nomePalavra);
			List<PalavraChave> palavras1 = q4.execute();

			if (palavras1.isEmpty()) {
				System.out.println("Palavra-chave não encontrada.");
			} else {
				PalavraChave palavra1 = palavras1.get(0);

				if (!material1.getListaPalavrasChave().contains(palavra1)) {
					material1.adicionar(palavra1);
					manager.store(material1);
					manager.store(palavra1);
					manager.commit();
					System.out.println("Relacionamento adicionado com sucesso.");
				} else {
					System.out.println("Essa palavra-chave já está associada a esse material.");
				}
			}
		}

		Util.desconectar();
		System.out.println("Fim da aplicação.");
	}
}
