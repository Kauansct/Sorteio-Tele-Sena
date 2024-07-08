public class Pessoa{
    private String nome;
    private TeleSena[] teleSenasPessoa;
    private double premiacao;

    // método construtor da classe pessoa
    public Pessoa(String nome){
        this.nome = nome;
    }
    
    // Método que recebe por parâmetro um número aleatorio(presente no método costrutor de "ControleTeleSena")
    // consiste em comprar(Criar objetos) um número aleatório de Tele Senas com dois conjuntos para essa pessoa
    public void comprarTeleSenas(int numMaxTeleSenas){
        teleSenasPessoa = new TeleSena[numMaxTeleSenas];
        for(int i=0; i<teleSenasPessoa.length; i++){ 
            teleSenasPessoa[i] = new TeleSena(new int[25], new int[25]);
        }
    }  

    // Geters e seters de todos os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TeleSena[] getTeleSenasPessoa() {
        return teleSenasPessoa;
    }

    public void setTeleSenasPessoa(TeleSena[] teleSenasPessoa) {
        this.teleSenasPessoa = teleSenasPessoa;
    }

    public double getPremiacao() {
        return premiacao;
    }

    public void setPremiacao(double premiacao) {
        this.premiacao = premiacao;
    }
}