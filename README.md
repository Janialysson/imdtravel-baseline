# IMDTravel - Baseline (Parte 1.1) - Spring Boot

Projeto com 4 microserviços Spring Boot:
- imdtravel (orquestrador) - porta 8084
- airlineshub - porta 8081
- exchange - porta 8082
- fidelity - porta 8083

## Como usar

1. Buildar cada projeto com maven (ou usar uma IDE):
   No meu caso usei o Prompt de Comando do Windows para rodar cada MicroServiço, pois meu computador não tinha recurso suficientes para rodar no Docker.
   Basta seguir o passo a passo:
   ```
   Passo 1
   Precisa execultar o Prompt como administrador.
   '''
   Passo 2
   Precisa indicar o caminho onde está o arquivo por exemplo:

   cd "C:\Users\User\Downloads\imdtravel_baseline_multistage"
   '''
   Passo 3
   Rodar cada comando dos Microserviço separadamente em um terminal:
   
   cd C:\Users\User\Downloads\imdtravel_baseline_multistage\fidelity
   mvn spring-boot:run

   cd C:\Users\User\Downloads\imdtravel_baseline_multistage\exchange
   mvn spring-boot:run
  
   cd C:\Users\User\Downloads\imdtravel_baseline_multistage\imdtravel
   mvn spring-boot:run

   cd C:\Users\User\Downloads\imdtravel_baseline_multistage\airlineshub
   mvn spring-boot:run
   ```
   Para testar basta abrir o navegador e colocar por exemplo:
   
   Serviço de exchange:
   http://localhost:8082/convert?value=100

   Serviço de airlineshub
   http://localhost:8081/flight?flight=LATAM123&day=2025-11-01

   Os demais serviços tem que utilizar o Postmam por exemplo:

   Serviço de imdtravel
   http://localhost:8084/buyTicket

   Corpo
   {
    "flight": "LATAM123",
    "day": "2025-11-01",
    "user": "joao"
   }

   Serviço de fidelity
   http://localhost:8083/sell

   Corpo
   {
    "flight": "LATAM123",
    "user": "joao"
   }
   '''
   
3. Ou usar Docker Compose caso tenha recursos na máquina (requer build dos jars ou imagem build com maven dentro do Dockerfile):
   ```
   docker compose up --build
   ```

4. Teste de compra (exemplo):
   ```
   curl -X POST "http://localhost:8084/api/buyTicket?flight=AB123&day=2025-10-25&user=1"
   ```

## Observações
- Cada serviço tem `application.properties` com a porta configurada.
- O timeout de 1s está aplicado no `RestTemplate` do `imdtravel`.
- Ajuste as versões do Spring Boot / Java no pom.xml conforme necessário.
- Lembre-se de que é necessário gerar os JARs (`mvn package`) para que o Dockerfile consiga copiar o `target/*.jar`.

## Tag para entrega
Após commitar tudo no repo, crie a tag BASELINE:
```
git tag BASELINE
git push origin BASELINE
```


### Versão com Docker Multi-Stage Build
Caso o projeto seja executado **sem precisar do Maven localmente**.
Para rodar tudo:

```
docker compose up --build
```
Isso compila os JARs dentro dos containers automaticamente.
