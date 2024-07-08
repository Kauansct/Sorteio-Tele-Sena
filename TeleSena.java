public class TeleSena{
    private double valorTele = 10.00;
    private int[] conjuntoSorteioTele1;
    private int[] conjuntoSorteioTele2;
    private int[] conjuntoSorteioPessoa1;
    private int[] conjuntoSorteioPessoa2;

 

    // Quando criar um objeto sem parâmetros no "main", irá gerar dois conjuntos de números aleatórios.
    public TeleSena(){
        this.conjuntoSorteioTele1 = gerarNumAleatoriosTele();
        this.conjuntoSorteioTele2 = gerarNumAleatoriosTele();
        
    }

    // Este método tem como objetivo criar dois conjuntos de números aleatórios para a pessoa(utiliza-se no método da classe "Pessoa")
    public TeleSena(int[] conjuntoSorteioPessoa1, int[] conjuntoSorteioPessoa2){
        this.conjuntoSorteioPessoa1 = gerarNumAleatoriosPessoa();
        this.conjuntoSorteioPessoa2 = gerarNumAleatoriosPessoa();
    }

    // Parte desse método esta mais explicado no método "háVencedor" da classe "controleTeleSena".
    // Consiste em gerar 25 números aleatórios sem repetição e 0 para os outros 35 números restantes.
    public int[] gerarNumAleatoriosTele(){
        int[] numero = new int[60];
        boolean[] numUtilizados = new boolean[61];

        // Já que o sorteio desses números vão de 1 até 60, considerei o valor zero como nulo(ELe terá utilidade no método "háVencedor()").
        for (int i=0; i<numero.length; i++){
            if (i > 24){
                numero[i] = 0;
                return numero;
            }
            else{
                int num = (int)(Math.random()*60 + 1);
                while(numUtilizados[num]){
                    num = (int)(Math.random()*60 + 1);
                }
                numero[i] = num;
                numUtilizados[num] = true;
            }
        }
        return numero;
    }

    // Tem a mesma funcionalidade do método acima, mas gera apenas 25 números aleatórios
    public int[] gerarNumAleatoriosPessoa(){
        int[] numero = new int[25];
        boolean[] numUtilizados = new boolean[61];

        for (int i=0; i<numero.length; i++){
            int num = (int)(Math.random()*60 + 1);
            while(numUtilizados[num]){
                num = (int)(Math.random()*60 + 1);
            }
            numero[i] = num;
            numUtilizados[num] = true;
        }
        return numero;
    }

    // Geters e seters de todos os atributos
    public double getValorTele(){
        return valorTele;
    }

    public void setValorTele(double valorTele) {
        this.valorTele = valorTele;
    }

    public int[] getConjuntoSorteioTele1() {
        return conjuntoSorteioTele1;
    }

    public void setConjuntoSorteioTele1(int[] conjuntoSorteioTele1) {
        this.conjuntoSorteioTele1 = conjuntoSorteioTele1;
    }

    public int[] getConjuntoSorteioTele2() {
        return conjuntoSorteioTele2;
    }

    public void setConjuntoSorteioTele2(int[] conjuntoSorteioTele2) {
        this.conjuntoSorteioTele2 = conjuntoSorteioTele2;
    }

    public int[] getConjuntoSorteioPessoa1() {
        return conjuntoSorteioPessoa1;
    }

    public void setConjuntoSorteioPessoa1(int[] conjuntoSorteioPessoa1) {
        this.conjuntoSorteioPessoa1 = conjuntoSorteioPessoa1;
    }

    public int[] getConjuntoSorteioPessoa2() {
        return conjuntoSorteioPessoa2;
    }

    public void setConjuntoSorteioPessoa2(int[] conjuntoSorteioPessoa2) {
        this.conjuntoSorteioPessoa2 = conjuntoSorteioPessoa2;
    }

    
    

}  