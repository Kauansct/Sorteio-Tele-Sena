public class Principal{
    public static void main(String[] args){
    
        TeleSena teleSena = new TeleSena();
        ControleTeleSena controle = new ControleTeleSena(); 
        Pessoa pessoa = new Pessoa("Pessoa");
        
        
        controle.realizarSorteioTeleSena();
        controle.haVencedor();
        controle.imprimeInfo();
        
        
        
    }

}