# Este projeto foi realizado para a matéria de Computação Orientada a Serviços da UNITINS

Projeto desenvolvido pelos alunos: Alisson de Oliveira Lima; Michael Silva Sena.

## Projeto

A ideia deste projeto é demonstrar a conexão entre uma API REST e uma gRPC. Para este projeto, foi utilizado o Java com Quarkus para a criação da aplicação REST e foi utilizado Golang para a aplicação gRPC. A aplicação é bem simples, sendo um sistema de cadastro de usuarios em Java + Quarkus com apenas um método POST que chama uma função remota implementada em Golang que vai adicionar o email de um usuario a uma lista de emails, que pode ser utilizada mais tarde como uma lista de emails para envio automatizado de mensagens. Os dados estão sendo salvos em memória.

## Rodar

Para subir a aplicação Java, deve-se acessar a pasta comp-servico no terminal e com o docker iniciado rodar utilizando:
```
./mvnw compile quarkus:dev
```

Para subir a aplicação Golang, deve-se utilizar o seguinte comando dentro da pasta grpc-server:
```
go run .\cmd\
```
ou se estiver no linux:
```
go run ./cmd
```
