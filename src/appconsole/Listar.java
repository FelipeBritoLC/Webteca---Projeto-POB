package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.TipoMaterial;
import modelo.PalavraChave;
import modelo.MaterialWeb;

public class Listar {
	private static ObjectContainer manager;

	public static void main(String[] args) {
		manager = Util.conectarBanco();


		System.out.println("\n---listar todos os tipos de material:");
		Query q = manager.query();
		q.constrain(TipoMaterial.class);
		List<TipoMaterial> tipos_material = q.execute();
		tipos_material.stream().forEach(item -> System.out.println(item));

		System.out.println("\n---listar todas as palavras chave:");
		q = manager.query();
		q.constrain(PalavraChave.class);
		List<PalavraChave> palavrasChave = q.execute();
		palavrasChave.stream().forEach(item -> System.out.println(item));

		System.out.println("\n---listar todos os materiais Web:");
		q = manager.query();
		q.constrain(MaterialWeb.class);
		List<MaterialWeb> materiaisWeb = q.execute();
		materiaisWeb.stream().forEach(item -> System.out.println(item));
		
		Util.desconectar();
	}

}
