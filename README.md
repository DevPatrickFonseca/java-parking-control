<div align="center">

   <h1> Java - Parking Control 🚗</h1>

</div>


Este é um projeto simples de controle de estacionamento em uma API RESTFull.

---

<div align="center">
  <h2>🧰 Tecnologias, linguagens e ferramentas utilizadas:</h2>
  <p align="center">
    <a href="https://github.com/PFonsecaFV/PFonsecaFV">
    <img src="https://github.com/PFonsecaFV/PFonsecaFV/blob/main/src/icons/ic_java.svg" width="60" fill="none" />
    <img src="https://github.com/PFonsecaFV/PFonsecaFV/blob/main/src/icons/ic_maven.svg" width="60" fill="none" />
    <img src="https://github.com/PFonsecaFV/PFonsecaFV/blob/main/src/icons/ic_spring.svg" width="60" fill="none" />
    <img src="https://github.com/PFonsecaFV/PFonsecaFV/blob/main/src/icons/ic_springboot.svg" width="60" fill="none" />
    <img src="https://github.com/PFonsecaFV/PFonsecaFV/blob/main/src/icons/ic_hibernate.svg" width="60" fill="none" />
    <img src="https://github.com/PFonsecaFV/PFonsecaFV/blob/main/src/icons/ic_postgre.svg" width="60" fill="none" />
    <img src="https://github.com/PFonsecaFV/PFonsecaFV/blob/main/src/icons/ic_postman.svg" width="60" fill="none" />
    <img src="https://github.com/PFonsecaFV/PFonsecaFV/blob/main/src/icons/ic_docker.svg" width="60" fill="none" />
    </a>
  </p>
</div>

- Linguagem: Java 17
- Framework: Spring Boot 3.1.3
- Arquitetura: MSC (Model-Service-Controller)
- Injeção de Dependências
- Spring Web
- Spring Data JPA
- Spring Validation para criação de API com suporte a Pageable
- Banco de Dados: PostgreSQL
- Docker
- Global Custom Date


## <strong>🎯O que foi desenvolvido</strong><br />

O projeto implementa um sistema de controle de estacionamento com as seguintes funcionalidades:

- Cadastro, leitura, atualização e exclusão de veículos estacionados.
- Integração com banco de dados PostgreSQL para armazenamento persistente dos dados.
- API RESTful com suporte a paginação (Pageable) para consultas.

## 📝Orientações para instalar e testar o projeto

Para executar o projeto, certifique-se de ter o Docker instalado em sua máquina. Siga os passos abaixo:

1. Crie um diretório usando o comando mkdir e entre no diretório:
   ```bash
   mkdir patrick-fonseca-projetos-java && cd patrick-fonseca-projetos-java
   ```
2. Clone o repositório e use o comando no terminal:
   ```bash
   git clone git@github.com:PFonsecaFV/java-parking-control.git
   ```
3. Acesse o diretório do projeto e instale suas dependências:
   ```bash
   cd java-parking-control
   ```

4. Utilize o Docker para executar o banco de dados PostgreSQL:


## ✅ Teste de requisições

Na pasta `client_requests` você encontra um arquivo que pode ser importado a um <strong>Client REST</strong> para testar as requisições.
<br>
<br>
Este arquivo vem com exemplos de requisições já preenchidas para se testar.
<br>
<br>
1. Requisições do tipo `POST`


2. Requisições do tipo `GET`


3. Requisições do tipo `DELETE`


4. Requisições do tipo `PUT`


5. Requisições do tipo `GET PAGEABLE`

<br>

<details>
   <summary><b>Exemplo de entrada para cadastro de vaga</b></summary>

   ```json
   {
      "numeroVaga": "205B",
      "carroPlaca": "FUS1975",
      "carroMarca": "Volkswagen",
      "carroModelo": "Fusca 1300",
      "carroCor": "Preto",
      "nomeDoResponsavel": "Patrick Fonseca",
      "apartamento": "205",
      "bloco": "B"
   }
   ```
      
   </details>

<details>
   <summary><b>Alguns exemplos caso queira testar</b></summary>

   ```json
   {
      "numeroVaga": "200A",
      "carroPlaca": "MAV1976",
      "carroMarca": "Ford",
      "carroModelo": "Maverick",
      "carroCor": "Amarelo",
      "nomeDoResponsavel": "Anderson Fonseca",
      "apartamento": "200",
      "bloco": "A"
   },

   {
      "numeroVaga": "150B",
      "carroPlaca": "OPA1978",
      "carroMarca": "Chevrolet",
      "carroModelo": "Opala",
      "carroCor": "Cinza",
      "nomeDoResponsavel": "Patrick Anderson",
      "apartamento": "150",
      "bloco": "B"
   },

   {
      "numeroVaga": "130A",
      "carroPlaca": "CAM2000",
      "carroMarca": "Chevrolet",
      "carroModelo": "Camaro",
      "carroCor": "Amarelo",
      "nomeDoResponsavel": "Vinícios Fonseca",
      "apartamento": "125",
      "bloco": "A"
   },
   
   {
      "numeroVaga": "170A",
      "carroPlaca": "VER1994",
      "carroMarca": "Chevrolet",
      "carroModelo": "Veraneio",
      "carroCor": "Marrom",
      "nomeDoResponsavel": "José Fonseca",
      "apartamento": "120",
      "bloco": "A"
   }
   ```

   </details>

<br>

---

<div align="center">
  <h2>Patrick Fonseca</h2>
	  <a href="https://www.linkedin.com/in/PatrickFonseca/" target="_blank">
      <img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank">
    </a>
</div>
