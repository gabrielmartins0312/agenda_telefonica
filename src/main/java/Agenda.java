import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;
    private static final String FILE_NAME = "contatos.dat";

    public Agenda() {
        contatos = new ArrayList<>();
        carregarContatos();
    }

    public void adicionarContato(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone);
        contatos.add(contato);
        salvarContatos();
    }

    public void exibirContatos() {
    	System.out.println("-------------------------------------------");
        System.out.println("             Lista de Contatos             ");
        System.out.println("-------------------------------------------");
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
        System.out.println("-------------------------------------------");
    }

    @SuppressWarnings("unchecked")
    private void carregarContatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            contatos = (List<Contato>) ois.readObject();
        } catch (FileNotFoundException e) {
            contatos = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void salvarContatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(contatos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
