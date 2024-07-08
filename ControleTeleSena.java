public class ControleTeleSena{
    private Pessoa[] pessoas = new Pessoa[20];
    private int quantTeleVendidas;
    private double premioTotal;
    private double lucroTotal;
    private TeleSena numSorteado;
    private int numPessoasGanhadoras1;
    private int numPessoasGanhadoras2;
    private int numPessoasGanhadorasTotal;
    private int acertos;
    private double premioIndividual;
    

    // Ao criar um objeto da classe controleTeleSena...
    public ControleTeleSena(){
        // Gera 20 pessoas automaticamente(1 até 20), compra aleatóriamente um número máximo de tele Senas para essas pessoas...
        for(int i=0; i<pessoas.length; i++){
            pessoas[i] = new Pessoa("Pessoa"+(i+1));
            int numMaxTeleSenas = (int)(Math.random()*15+1); 
            pessoas[i].comprarTeleSenas(numMaxTeleSenas);
            System.out.println(pessoas[i].getNome()+" comprou "+numMaxTeleSenas+" Tele Senas"); 
            // e adiciona esse número máximo de Tele Senas em uma variavel chamada "quantTeleVendidas", o qual fará parte do prêmio do(s) sortudo(s).
            quantTeleVendidas += numMaxTeleSenas;

            try{
                Thread.sleep(1000);
            }catch(Exception e){}
        }
    }

    // Criei este método para imprimir os arrays das Tele Senas sorteadas com finalidade de facilitar o método "imprimeInfo()"
    public void imprimeArray(int[] conjuntoSorteioTele){
        boolean primeiroValor = true;

        System.out.print("[");
        for (int i=0; i<conjuntoSorteioTele.length; i++){
            // Irá imprimir até chegar ao número nulo(Melhor explicado na "Classe TeleSena" do método "gerarNumAleatoriosTele()")
            if (conjuntoSorteioTele[i] != 0){
                if (!primeiroValor){
                    System.out.print(", ");
                }

                System.out.print(conjuntoSorteioTele[i]);
                primeiroValor = false;
            }
            else{
                break;
            }   
        }
        System.out.println("]");  
    }

    // Da mesma forma que "imprimeArray()", este tem o mesmo propósito.
    public void imprimeVencedores(){
        boolean primeiroNome = true;

        for (int i=0; i<pessoas.length; i++){
            if (pessoas[i].getPremiacao() > 0){
                if (!primeiroNome){
                    System.out.print(", ");
                }

                System.out.print(pessoas[i].getNome());
                primeiroNome = false;
            }  
        }
        System.out.println();
    }

    // Ao chamar este método, irá imprimir todas as informações da Tele Sena.
    // OBS: Os println vazios são para imprimir na tela de forma mais organizada.
    public void imprimeInfo(){
        System.out.println();
        System.out.println("Informações do sorteio Tele Sena:");
        System.out.println();
        System.out.println("Números sorteados:");
        // Irá imprimir até o ultimo número sorteado diferente de 0
        System.out.println("1º conjunto Tele Sena: ");
        imprimeArray(numSorteado.getConjuntoSorteioTele1());
        System.out.println();

        // Irá imprimir até o ultimo número sorteado diferente de 0
        System.out.println("2º conjunto Tele Sena: ");
        imprimeArray(numSorteado.getConjuntoSorteioTele2());
        System.out.println();
        
        System.out.println("Quantidade de Tele Senas vendidas: "+quantTeleVendidas);
        System.out.println();

        System.out.println("Número de ganhadores: "+(numPessoasGanhadoras1 + numPessoasGanhadoras2)); 
        System.out.println("Nome(s) do(s) ganhadore(s): ");
        imprimeVencedores();
        System.out.println();
    
        // Pesquisei "String.format" para que o valor fique duas casas depois da vírgula 
        System.out.println(String.format("Valor do premioIndividual: R$ %.2f",premioIndividual));
        System.out.println(String.format("Valor total das Tele Senas vendidas: R$ %.2f",(quantTeleVendidas * numSorteado.getValorTele())));
        lucroTotal = (quantTeleVendidas * numSorteado.getValorTele() * 0.2);
        System.out.println(String.format("Lucro obtido com a Tele Sena: R$ %.2f",lucroTotal));
    }


    // Ao chamar este método, criará os números sorteados da Tele Sena.
    public void realizarSorteioTeleSena(){
        System.out.println();
        System.out.println("Olá, caros espectadores!! Vamos sortear os 25 números da Tele Sena");
        System.out.println();
        numSorteado = new TeleSena();

        try{
            Thread.sleep(3000);
        }catch(Exception e){}

        System.out.println("Aqui está os números sorteados do 1ª conjunto da Tele Sena");
        imprimeArray(numSorteado.getConjuntoSorteioTele1());

        try{
            Thread.sleep(5000);
        }catch(Exception e){}


        System.out.println();
        System.out.println("Este são os números sorteados do 2ª conjunto da Tele Sena");
        imprimeArray(numSorteado.getConjuntoSorteioTele2());

        try{
            Thread.sleep(5000);
        }catch(Exception e){}

    }

    // Como diz o próprio método, calcula-se o prêmio do vencedor e adicionado o valor na variável "premiacao".
    public void calculaPremio(Pessoa[] vencedores){ 
        premioTotal = (quantTeleVendidas * numSorteado.getValorTele() * 0.8);
        premioIndividual = premioTotal / vencedores.length;

        for (int i=0; i<vencedores.length; i++){
            vencedores[i].setPremiacao(premioIndividual);
        }
    }

    // Ao chamar este método...
    public void haVencedor(){
        boolean[] numUtilizados1 = new boolean[61];
        Pessoa[] vencedores = new Pessoa[pessoas.length];
        numPessoasGanhadoras1 = 0;
        numPessoasGanhadorasTotal = 0;
        
        // Apresentações iniciais ao chamar este método
        System.out.println();
        System.out.println("Agora, analisaremos se há um ganhador na Tele Sena do 1º conjunto");

        try{
            Thread.sleep(1000);
        }catch(Exception e){}

        System.out.println();
        System.out.println("Analisando...");

        for (int i=0; i<3; i++){
            System.out.println("...");

            try{
                Thread.sleep(1000);
            }catch(Exception e){}

        }

        // Irá procurar nas 20 pessoas...
        for (int i=0; i<pessoas.length; i++){
            Pessoa pessoa = pessoas[i]; 

            // E nas Tele Senas compradas por cada pessoa...
            for (int j=0; j<pessoa.getTeleSenasPessoa().length; j++){
                TeleSena teleSenaPessoa = pessoa.getTeleSenasPessoa()[j]; 
                    acertos = 0;

                // se há um número semelhante entre a Tele Sena dessa pessoa e a Tele Sena sorteada...
                for (int k=0; k<teleSenaPessoa.getConjuntoSorteioPessoa1().length; k++){
                    for (int l=0; l<numSorteado.getConjuntoSorteioTele1().length; l++){
                        if (teleSenaPessoa.getConjuntoSorteioPessoa1()[k] == numSorteado.getConjuntoSorteioTele1()[l]){
                            acertos++;
                        }
                        // só até os 25 números o loop "for" deve procura.
                        if (l > 24){
                            break;
                        }
                    }
                }
        

                // Se alguma pessoa tiver os mesmos 25 números da Tele Sena sorteada...
                if (acertos == 25){
                    // Será adicionado em um array "vencedores", o qual pode armazenar 20 pessoas, os ganhadores da Tele Sena.
                    vencedores[numPessoasGanhadorasTotal] = pessoa;
                    numPessoasGanhadoras1 ++;
                    numPessoasGanhadorasTotal ++;
                }
            }            
        }
        
        if (numPessoasGanhadoras1 != 0){
            // imprime na tela quantos jogadores ganharam na Tele Sena
            if (numPessoasGanhadoras1 == 1){
                System.out.println();
                System.out.println("Parece que temos "+numPessoasGanhadoras1+" ganhador do 1º conjunto da Tele Sena");

                try{
                    Thread.sleep(5000);
                }catch(Exception e){}
            }
            else if(numPessoasGanhadoras1 > 1){
                System.out.println();
                System.out.println("Parece que temos "+numPessoasGanhadoras1+" ganhadores do 1º conjunto da Tele Sena");
                
                try{
                    Thread.sleep(5000);
                }catch(Exception e){}
            }
            
        }
        else{
            // Explica que não houve ganhadores e começará a sortear um número de cada
            try{
                Thread.sleep(5000);
            }catch(Exception e){}
            
            System.out.println();
            System.out.println("Infelizmente, ninguém conseguiu acertar os 25 números da Tele Sena");
            System.out.println();

            try{
                Thread.sleep(5000);
            }catch(Exception e){}

            System.out.println("Então vamos sortear um número de cada vez até que alguém consiga os 25 acertos");

            try{
                Thread.sleep(5000);
            }catch(Exception e){}

            // Se não houve nenhum ganhador, este ira varrer e salvar todos os números sorteados em um array de boolean;
            // OBS: - "true" são para números já utilizados e "false" não
            //      - Este Array de boolean armazena o valor do número sorteado em uma posição(Ex: (numSorteado = 35) = numUtilizados[35] = true)
            for (int n=0; n<25; n++){
                if (numSorteado.getConjuntoSorteioTele1()[n] != 0){
                    numUtilizados1[numSorteado.getConjuntoSorteioTele1()[n]] = true;
                }
            }
            
            // A partir dos 25 números, se repetirá até um dos participantes tiver 25 números semelhantes(Mais abaixo há o comando "if(acertos == 25)" que ira fazer a ação mencionada)
            for (int m=25; m<numSorteado.getConjuntoSorteioTele1().length; m++){

                // Após os 25 números sorteados, aqui será gerado e adcionado no conjunto da Tele Sena um número aleatório sem repetição com o comando while
                int num = (int)(Math.random()*60 + 1);
                while(numUtilizados1[num]){
                    num = (int)(Math.random()*60 + 1);
                }
                numSorteado.getConjuntoSorteioTele1()[m] = num;
                numUtilizados1[num] = true;
            
            
                // Ira procura 20 nas pessoas
                for (int i=0; i<pessoas.length; i++){
                    Pessoa pessoa = pessoas[i]; 
        
                    // E nas Tele Senas compradas por cada pessoa...
                    for (int j=0; j<pessoa.getTeleSenasPessoa().length; j++){
                        TeleSena teleSenaPessoa = pessoa.getTeleSenasPessoa()[j]; 
                            acertos = 0;
        
                        // se há um número semelhante entre a Tele Sena dessa pessoa e a Tele Sena sorteada(numSorteado)...
                        for (int k=0; k<teleSenaPessoa.getConjuntoSorteioPessoa1().length; k++){
                            // até que alguma pessoa consiga os 25 números da Tele Sena.
                            if (acertos == 25){
                                break;
                            }
                            for (int l=0; l<numSorteado.getConjuntoSorteioTele1().length; l++){   
                                // O loop for só irá parar de varrer se encontrar o valor zero(Explicado na classe TeleSena no método "gerarNumAleatorioTele()") ou se alguma pessoa consiga os 25 números da Tele Sena
                                if (numSorteado.getConjuntoSorteioTele1()[l] == 0){
                                    break;
                                }
                                // iguala os valores da Tele Sena da pessoa com os números sorteados.
                                if (teleSenaPessoa.getConjuntoSorteioPessoa1()[k] == numSorteado.getConjuntoSorteioTele1()[l]){
                                    acertos++;
                                }
                                if (acertos == 25){
                                    break;
                                }
                                
                            }
                        }
                    
                        // Se alguma pessoa tiver os mesmos 25 números da Tele Sena sorteada...
                        if (acertos == 25){
                            // Será adicionado em outro array os ganhadores da Tele Sena.
                            vencedores[numPessoasGanhadorasTotal] = pessoa;
                            numPessoasGanhadoras1 ++;
                            numPessoasGanhadorasTotal ++;
                        }
                    }            
                }

                
                if (numPessoasGanhadoras1 != 0){
                    // imprime na tela quantos jogadores ganharam na Tele Sena
                    if (numPessoasGanhadoras1 == 1){
                        System.out.println();
                        System.out.println("Parece que temos "+numPessoasGanhadoras1+" ganhador do 1º conjunto da Tele Sena");

                        try{
                            Thread.sleep(5000);
                        }catch(Exception e){}
                    }
                    else if(numPessoasGanhadoras1 > 1){
                        System.out.println();
                        System.out.println("Parece que temos "+numPessoasGanhadoras1+" ganhadores do 1º conjunto da Tele Sena");
                        
                        try{
                            Thread.sleep(5000);
                        }catch(Exception e){}
                    }
                    break;
                }
            }
        }

        // Aqui inicia o 2º conjunto de números sorteados, ou seja, irá repetir o mesmo processo do método "háVencedor()" utilizando o array "conjuntoSorteioTele2"
        // OBS: No final do código é calculado o prêmio dos participantes
        boolean[] numUtilizados2 = new boolean[61];
        numPessoasGanhadoras2 = 0;

        System.out.println();
        System.out.println("Agora, analisaremos se há um ganhador na Tele Sena do 2º conjunto");

        try{
            Thread.sleep(1000);
        }catch(Exception e){}

        System.out.println();
        System.out.println("Analisando...");

        for (int i=0; i<3; i++){
            System.out.println("...");

            try{
                Thread.sleep(1000);
            }catch(Exception e){}

        }

        for (int i=0; i<pessoas.length; i++){
            Pessoa pessoa = pessoas[i]; 

            for (int j=0; j<pessoa.getTeleSenasPessoa().length; j++){
                TeleSena teleSenaPessoa = pessoa.getTeleSenasPessoa()[j]; 
                    acertos = 0;

                for (int k=0; k<teleSenaPessoa.getConjuntoSorteioPessoa2().length; k++){
                    for (int l=0; l<numSorteado.getConjuntoSorteioTele2().length; l++){
                        if (teleSenaPessoa.getConjuntoSorteioPessoa2()[k] == numSorteado.getConjuntoSorteioTele2()[l]){
                            acertos++;
                        }
                        if (l > 24){
                            break;
                        }
                    }
                }
        

                if (acertos == 25){
                    vencedores[numPessoasGanhadorasTotal] = pessoa;
                    numPessoasGanhadoras2 ++;
                    numPessoasGanhadorasTotal ++;
                }
            }            
        }
        
        if (numPessoasGanhadoras2 != 0){
            // imprime na tela quantos jogadores ganharam na Tele Sena
            if (numPessoasGanhadoras1 == 1){
                System.out.println();
                System.out.println("Parece que temos "+numPessoasGanhadoras1+" ganhador do 2º conjunto da Tele Sena");

                try{
                    Thread.sleep(5000);
                }catch(Exception e){}
            }
            else if(numPessoasGanhadoras1 > 1){
                System.out.println();
                System.out.println("Parece que temos "+numPessoasGanhadoras1+" ganhadores do 2º conjunto da Tele Sena");
                
                try{
                    Thread.sleep(5000);
                }catch(Exception e){}
            }

        }
        else{
            // Explica que não houve ganhadores e começará a sortear um número de cada
            try{
                Thread.sleep(5000);
            }catch(Exception e){}
            
            System.out.println();
            System.out.println("Infelizmente, ninguém conseguiu acertar os 25 números da Tele Sena");
            System.out.println();

            try{
                Thread.sleep(5000);
            }catch(Exception e){}

            System.out.println("Então vamos sortear um número de cada vez até que alguém consiga os 25 acertos");

            try{
                Thread.sleep(5000);
            }catch(Exception e){}

            for (int n=0; n<25; n++){
                if (numSorteado.getConjuntoSorteioTele2()[n] != 0){
                    numUtilizados2[numSorteado.getConjuntoSorteioTele2()[n]] = true;
                }
            }
            
            for (int m=25; m<numSorteado.getConjuntoSorteioTele2().length; m++){
                
                int num = (int)(Math.random()*60 + 1);
                while(numUtilizados2[num]){
                    num = (int)(Math.random()*60 + 1);
                }
                numSorteado.getConjuntoSorteioTele2()[m] = num;
                numUtilizados2[num] = true;
            
            
                
                for (int i=0; i<pessoas.length; i++){
                    Pessoa pessoa = pessoas[i]; 
        
                    for (int j=0; j<pessoa.getTeleSenasPessoa().length; j++){
                        TeleSena teleSenaPessoa = pessoa.getTeleSenasPessoa()[j]; 
                            acertos = 0;
        
                        for (int k=0; k<teleSenaPessoa.getConjuntoSorteioPessoa2().length; k++){
                            
                            if (acertos == 25){
                                break;
                            }
                            
                            for (int l=0; l<numSorteado.getConjuntoSorteioTele2().length; l++){   
                                if (numSorteado.getConjuntoSorteioTele2()[l] == 0){
                                    break;
                                }
                                if (teleSenaPessoa.getConjuntoSorteioPessoa2()[k] == numSorteado.getConjuntoSorteioTele2()[l]){
                                    acertos++;
                                }
                                if (acertos == 25){
                                    break;
                                }
                                
                            }
                        }
                    
                        if (acertos == 25){
                            vencedores[numPessoasGanhadorasTotal] = pessoa;
                            numPessoasGanhadoras2 ++;
                            numPessoasGanhadorasTotal ++;             
                        }
                    }            
                }

                // Após armazenar todos os ganhadores em "vencedores" serão armazenados em outro array, mas com o espaço para apenas estes ganhadores, a fim de não causar erros na utilização do método calculaPremio().
                if (numPessoasGanhadoras2 != 0){
                    Pessoa[] finalVencedores = new Pessoa[numPessoasGanhadorasTotal];
                    for (int i=0; i<numPessoasGanhadorasTotal; i++){
                        finalVencedores[i] = vencedores[i];
                    }
                    calculaPremio(finalVencedores);

                    // imprime na tela quantos jogadores ganharam na Tele Sena
                    if (numPessoasGanhadoras1 == 1){
                        System.out.println();
                        System.out.println("Parece que temos "+numPessoasGanhadoras1+" ganhador do 2º conjunto da Tele Sena");

                        try{
                            Thread.sleep(5000);
                        }catch(Exception e){}
                    }
                    else if(numPessoasGanhadoras1 > 1){
                        System.out.println();
                        System.out.println("Parece que temos "+numPessoasGanhadoras1+" ganhadores do 2º conjunto da Tele Sena");
                        
                        try{
                            Thread.sleep(5000);
                        }catch(Exception e){}
                    }
                    break;
                }

            }
        }
    }
}