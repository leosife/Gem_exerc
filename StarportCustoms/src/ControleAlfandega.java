import java.util.HashMap;
import java.util.Map;

public class ControleAlfandega {
    Map<String, Viajante> bancoDeDados = new HashMap<>();


    public void registrarViajante(String passaporte, Viajante v){
        bancoDeDados.put(passaporte, v);
        System.out.println("Viajante "+ v.getNome() + " -- Passporte "+ passaporte +" registrado com sucesso");
    }


    public void verificarPassaporte(String passaporte){
        Viajante v1 = bancoDeDados.get(passaporte);
        if (v1 == null) {
            throw new PassporteFalsoException("Atenção: Passaporte não encontrado no sistema!");
        } else if (v1.isProcurado()){
            throw new AlertaPrisaoException("ALERTA: Viajante procurado detectado!");
        } else {
            System.out.println("Acesso liberado para "+ v1.getNome() + " do planeta " + v1.getPlanetaOrigem());
        }

    }










}
