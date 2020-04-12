#P.I. 2
# P.I. 2
---
## Como criar a branch developer local

A partir do dia 22/09 branch *master* ser� bloqueada para receber *push*, come�aremos a trabalhar com a branch *developer*.
Para criar a branch *developer* basta seguir os passos abaixo.
Dentro da pasta do projeto, abra o terminal e digite o comando `git pull`.
```sh
hygor@debian:~/Projetos/guideDocs/guidedocs$ git pull
From github.com:HygorSousa/guidedocs
 * [new branch]      developer  -> origin/developer
Already up to date.
```
Feito isso, ser� atualizado o projeto trazendo a refer�ncia da branch *developer*, agora precisamos criar a branch.
Execute o comando `git branch -a -v`.
```sh
hygor@debian:~/Projetos/guideDocs/guidedocs$ git branch -a -v
* master                   d9c9d95 Cria��o das classes e atualiza��o do modelo de atualiza��o do controle de acesso para adequa��o ao modelo de classes
  remotes/origin/HEAD      -> origin/master
  remotes/origin/developer d9c9d95 Cria��o das classes e atualiza��o do modelo de atualiza��o do controle de acesso para adequa��o ao modelo de classes
  remotes/origin/master    d9c9d95 Cria��o das classes e atualiza��o do modelo de atualiza��o do controle de acesso para adequa��o ao modelo de classes
```
Para criar a branch, basta executar o comando `git checkout -b developer origin/developer`.
```sh
hygor@debian:~/Projetos/guideDocs/guidedocs$ git checkout -b developer origin/developer
Branch 'developer' set up to track remote branch 'developer' from 'origin'.
Switched to a new branch 'developer'
```
Feito isso est� criada a branch, para conferir basta executar o comando `git branch -a`
```sh
hygor@debian:~/Projetos/guideDocs/guidedocs$ git branch -a
* developer
  master
  remotes/origin/HEAD -> origin/master
  remotes/origin/developer
  remotes/origin/master
```
O __asteristico__ define a branch em uso.