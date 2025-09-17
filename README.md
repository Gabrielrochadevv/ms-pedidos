# Microsserviços de Gestão de Pedidos e Entregas

Este projeto implementa dois microsserviços (Pedidos e Entregas) que se comunicam entre si utilizando Netflix Eureka, Spring Cloud Gateway e OpenFeign, garantindo alta disponibilidade, balanceamento de carga e centralização das requisições.

## Arquitetura
**Microsserviço de Pedidos**

- CRUD de pedidos

- Status inicial: EM_SEPARACAO

- Atributos:

  - Número do pedido

  - Nome do cliente

  -  Data do pedido

  - Valor do pedido

  - Status da entrega

 **Microsserviço de Entregas**
 
url -> https://github.com/Gabrielrochadevv/ms-entregas.git

Gerenciamento das entregas dos pedidos

- Atributos:

  - Número da entrega

  - Número do pedido

  - Nome do entregador

  - Status da entrega

  - Data da entrega

## Tecnologias Utilizadas

- Java 17

- Spring Boot

- Spring Cloud Netflix Eureka (Service Discovery)

- Spring Cloud Gateway (API Gateway + Load Balancer)

- OpenFeign (Comunicação entre microsserviços)

- MySQL (persistência de dados, com bancos separados para cada serviço)

- Docker Desktop (orquestração dos containers)

- HeidiSQL (gerenciamento do banco)

- Postman / Insomnia (requisições HTTP)

## Como Executar
**1. Clonar o projeto**

git clone https://github.com/seu-usuario/seu-repositorio.git

**2. Abrir no IntelliJ**

Importe o projeto como Maven Project.

**3. Subir containers do MySQL**
   
docker run --name mysql-microservices -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql:8


- Foram configurados dois bancos de dados (um para cada microsserviço).

**4. Configurar os bancos no HeidiSQL**

- Banco de Pedidos

- Banco de Entregas

 **5. Subir os microsserviços**

 - Execute cada projeto individualmente pelo IntelliJ.

 **6. Testar as requisições**

 - Use o arquivo JSON com as requisições no Insomnia ou Postman.

## Service Discovery (Eureka)

url -> https://github.com/Gabrielrochadevv/service-discovery.git

- Todos os microsserviços se registram no Eureka Server.

- Os clientes consultam o Eureka para localizar dinamicamente os serviços disponíveis.

## Gateway & Load Balancer

url -> https://github.com/Gabrielrochadevv/gateway.git

- Gateway é o ponto único de entrada para a API.

- Realiza roteamento dinâmico para os microsserviços.

- Permite rodar múltiplas instâncias de um mesmo serviço, garantindo balanceamento de carga e alta disponibilidade.

## OpenFeign

- Simplifica chamadas REST entre os microsserviços.

- O serviço de Pedidos chama automaticamente o serviço de Entregas para atualizar o status.

## Conclusão
Dessa forma, foi usados ferramentas capazes de centralizar as requisições dos clientes, realizando balanceamento de carga entre os servidores de forma automatizada garantindo alta disponibilidade, e facilitar a comunicação entre os microsserviços. Ferramentas como Netflix Eureka, Spring Clouf Gateway e Open Feign São imprecindíveis neste cenário.
