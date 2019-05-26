#Aplicação para cadastro e análise de proposta de crédito

App disponível em: 
https://analisecredito.herokuapp.com

Acesso as informações das API`s do sistema através so Swagger estão disponíveis no endereço: 
https://analisecredito.herokuapp.com/swagger-ui.html

*Frontend Utilizando: angular-1.7.7 e bootstrap
*Backend utilizando: Spring boot 2.1.5.RELEASE, Java 1.8, Banco de Dados H2, Swagger 2.5

*Foi criando uma tela para listagem das propostas, onde é possível reprocessar a análise de crédito;
*Uma tela para cadastro da proposta;
*Criado um Scheduler rodando a cada minuto verificando todas as propostas com resultado EM_FILA_DE_PROCESSAMENTO e enviado so Service de análise para processar a proposta.
