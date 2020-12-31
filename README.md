# 🔐Password Validator

Uma API para validar o nível de segurança da senha fornecida pelo usuário. Será considerada uma senha válida aquela que seguir as regras abaixo.

## 📃 Regras

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplos:  

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

## Requisitos

[SDK Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

#### Links úteis
- [Como setar o JAVA_HOME no Windows](https://confluence.atlassian.com/confbr1/configurando-a-variavel-java_home-no-windows-933709538.html)

## 🔨 Como executar

![AppStartup](https://user-images.githubusercontent.com/36551957/103425355-9f01c800-4b90-11eb-8f63-1cce450d3789.gif)

- #### No Windows
Na pasta raiz do projeto, utilize o comando `gradlew bootRun`. A aplicação irá expor o serviço na porta `8085`. Caso tenha problema para execução, ainda na pasta raiz do projeto utilize o comando `gradlew.bat`, e então execute o comando anterior novamente.

- #### No Linux
Na pasta raiz do projeto, utilize o comando `./gradlew bootRun`. A aplicação irá expor o serviço na porta `8080`.
Caso tenha problema de permissionamento para execução, ainda na pasta raiz do projeto utilize o comando `chmod +x gradlew`, e então execute o comando anterior novamente.


## 🖱 Como utilizar

![AppRunning](https://user-images.githubusercontent.com/36551957/103425511-7f1ed400-4b91-11eb-9d88-7fbbc217e9c1.gif)

O seu uso é bem simples, ao iniciar a aplicação é exposta a URN `/v1/password/validate` utilizando o método HTTP POST.

Para realizar a requisição você deve passar o seguinte body (formato: application/JSON):
```
{
	"password":"your_password"
}
```

cURL:
```
curl --request POST \
  --url http://localhost:8085/v1/password/validate \
  --header 'Content-Type: application/json' \
  --data '{
	"password":"asdfg!X1234"
}'
```

## ⁉️ Como funciona

![AppEnum](https://user-images.githubusercontent.com/36551957/103425680-c48fd100-4b92-11eb-9653-bf8b3f77e190.png)

Todas as regras são definidas em um enum chamado `Criteria` e cada critério retorna sua implementação da interface `PasswordRules`, como ambos utilizam a mesma inferface é possível validar a senha dado n critérios. 

Para que a validação seja feita passamos a senha e todas as regras que queremos aplicar:

![AppExample](https://user-images.githubusercontent.com/36551957/103425773-762f0200-4b93-11eb-8361-0ed5de507fce.png)

## 📐 Diagrama e Arquitetura

![AppDiagram_Security](https://user-images.githubusercontent.com/36551957/103426090-9eb7fb80-4b95-11eb-85ec-d17ba7798632.png)

Baseada no DDD e conceitos do Clean Architecture a arquitetura do projeto consiste em uma aplicação própria com sua regra de negócio isolada e abstraida por uma interface, assim possibilitando implementações de novos critérios e reduzindo o acoplamento.

## 💻 Tecnologias e ferramentas utilizadas
- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Java Spring Boot](https://spring.io/projects/spring-boot)
- [REGEX](https://regexr.com)

Made with 🖤 by Vinicius Lima
