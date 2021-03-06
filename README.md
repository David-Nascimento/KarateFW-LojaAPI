# Karate Framework API Testing
![alt text](https://software-that-matters.com/wp-content/uploads/2020/10/Karate-Mock-feature-1024x576.png)

"**Karate** é construído em cima do **Cucumber-JVM** , você pode executar testes e gerar relatórios como qualquer projeto Java padrão. Mas em vez de Java — você escreve testes em uma linguagem projetada para lidar com HTTP, JSON ou XML — **simples**".

# Sugestão de estrutura de projeto:
````
├── project
│ ├── src
│ └── test
│    ├── java
│    ├── project-Name
│    │   ├── services
│    │   │   ├── feature\package
│    │   │   ├── feature\package
│    │   │   ├── support
│    │   │   │   ├── config
│    │   │   │   │   └── domain.yaml
│    │   │   │   ├── data
│    │   │   │   │   └── headers.yaml
│    │   │   │   └── javaUtils
│    │   │   │       ├── cucumber
│    │   │   │       │   └── CucumberUtils
│    │   │   │       └── javaUtils
│    │   │   │           └── Utils
│    │   │   └── Runner.java
│    │   └── logback-test.xml
│    └── karate-config.js
└── karate.jar
````

# Arquitetura
A arquitetura da ferramenta utiliza Maven e é desenvolvida em Java. Possui classes (diversas) auxiliares para lidar com JSON, XML, Protocolo HTTP, leitura de arquivos, parametrização, execução paralela, dentre outras funcionalidades.

Assim como projetos que utilizam Cucumber, possui uma camada que expõe suas funções através de steps. As semelhanças com Cucumber param por aqui, uma vez que as versões mais recentes possuem engine própria para interpretar/executar as features.

Na imagem abaixo, temos uma ilustração simplificada da arquitetura:

![alt text](https://miro.medium.com/max/960/1*yNB1wSS_VYBELRCkDpLkSA.png)
