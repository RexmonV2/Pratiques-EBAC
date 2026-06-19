import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {

        Object objRetorno = instanciarClasse(Pessoa.class);
        Pessoa pessoa = (Pessoa) objRetorno;

        Class<?> classeLista = Class.forName("java.util.ArrayList");
        Object listaIntanciada = classeLista.getDeclaredConstructor().newInstance();

        injetarListaInstanciada(pessoa, pessoa.getClass().getDeclaredFields()[0].getName(), listaIntanciada);

        //Primeiro modo de adicionar itens a lista
        pessoa.getClass().getMethod("adicionarNome", String.class).invoke(pessoa, "Paulo");
        pessoa.getClass().getMethod("adicionarNome", String.class).invoke(pessoa, "Patricia");

        //Segundo modo, utilizando uma funcao para isso
        invocarMetodo(pessoa, "adicionarNome", "João");
        invocarMetodo(pessoa, "adicionarNome", "Marcia");
        invocarMetodo(pessoa, "adicionarNome", "Rogerio");
        invocarMetodo(pessoa, "adicionarNome", "Marcio");

        //Terceiro modo executando o add da propria lista via Reflection
        Method metodoAdd = listaIntanciada.getClass().getDeclaredMethod("add", Object.class);
        metodoAdd.invoke(listaIntanciada, "Tadeu");
        metodoAdd.invoke(listaIntanciada, "Roberto");
        metodoAdd.invoke(listaIntanciada, "Carla");
        metodoAdd.invoke(listaIntanciada, "Paula");

        percorrerLista(pessoa, "getNames");

    }

    private static void injetarListaInstanciada(Pessoa pessoa, String name, Object listaIntanciada) throws Exception {
        Field campoNome = pessoa.getClass().getDeclaredField(name);
        campoNome.setAccessible(true);
        campoNome.set(pessoa, listaIntanciada);
    }

    private static void percorrerLista(Pessoa pessoa, String getNames) throws Exception {
        Method methodGetter = pessoa.getClass().getMethod(getNames);

        Object lista = methodGetter.invoke(pessoa);
        Class<?> classeLista = lista.getClass();
        Method metodoSize = classeLista.getDeclaredMethod("size");
        Method metodoGet = classeLista.getDeclaredMethod("get", int.class);

        int tamanho = (int) metodoSize.invoke(lista);
        for (int i = 0; i < tamanho; i++) {
            Object item = metodoGet.invoke(lista, i);
            System.out.println(item);
        }

    }

    private static void invocarMetodo(Object obj, String nomeMetodo, Object... parametros) throws Exception {
        Class<?>[] tipo =  new Class[parametros.length];

        for (int i = 0; i < parametros.length; i++) {
            tipo[i] = parametros[i].getClass();
        }

        Method method = obj.getClass().getDeclaredMethod(nomeMetodo, tipo);
        method.invoke(obj, parametros);
    }

    private static Object instanciarClasse(Class<?> classe) throws Exception {
        Constructor<?> contrutor = classe.getConstructor();

        return contrutor.newInstance();
    }


}
