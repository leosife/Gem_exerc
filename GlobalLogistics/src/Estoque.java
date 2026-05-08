import java.util.ArrayList;

public class Estoque {
    ArrayList<Produto> produtos = new ArrayList<>();


    public Estoque(){

    }

    public void addProduto(Produto x){
        produtos.add(x);
    }

    public void removeProduto(Produto x){
        produtos.remove(x);
    }
}
