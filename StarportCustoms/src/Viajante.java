public class Viajante {
    private String nome;
    private String planetaOrigem;
    private boolean isProcurado;

    public Viajante(String nome, String planetaOrigem) {
        this.nome = nome;
        this.planetaOrigem = planetaOrigem;
        this.isProcurado = false;
    }

    public void setProcurado(boolean status) {
        this.isProcurado = status;
    }

    public String getNome() {
        return nome;

    }

    public void setNome(String newName) {
        this.nome = newName;
    }

    public String getPlanetaOrigem() {
        return planetaOrigem;

    }

    public void setPlanetaOrigem(String newPlanet) {
        this.planetaOrigem = newPlanet;
    }

    public boolean isProcurado() {
        return isProcurado;
    }

}
