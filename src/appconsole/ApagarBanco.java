package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

public class ApagarBanco {

    public static void main(String[] args) {
        ObjectContainer manager = Util.conectarBanco();

        // Consultar todos os objetos do banco
        Query q = manager.query();
        q.constrain(Object.class);
        List<Object> resultado = q.execute();

        // Deletar todos
        resultado.forEach(manager::delete);

        manager.commit();
        Util.desconectar();

        System.out.println("Todos os objetos foram apagados do banco.");
    }
}
