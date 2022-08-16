# desafio-Serasa

Este repositorio contem meu codigo de resolucao do desafio para o processo seletivo da Serasa

Importante: Os campos de vendedores e atuacao sao validados, entao será necessário passar os dados da seguinte forma:

Vendedor
{
“nome”: “Fulano de Tal”, (nao pode ser vazio)

“telefone”: “99 99999-9999”, (2 numeros, espaço, 5 numeros, traço, 4 numeros)

“idade”: 99, (entre 1 e 100)

“cidade”: “Cidade de Fulano”, (nao pode ser vazio)

“estado”: “XX”,   (duas letras maiúsculas)

“regiao”: “sudeste”
}


Atuacao
{
“regiao”: “sudeste”, (nao pode ser vazio)

“estados”: [
“SP”,
“RJ”,
“MG”,
“ES”
]
}
