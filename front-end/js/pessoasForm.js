var botaoAdicionarPessoa = document.querySelector("#btn-cadastrar");
botaoAdicionarPessoa.addEventListener("click", function (event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona");

    var pessoa = obtemPessoaDoFormulario(form);

    var pessoaTr = montaTr(pessoa);

    var tabela = document.querySelector("#tabelaPessoas");

    tabela.appendChild(pessoaTr);

    form.reset();
});

function obtemPessoaDoFormulario(form) {
    var pessoa = {
        codigo: form.code.value,
        nome: form.first_name.value,
        sobrenome: form.last_name.value,
    }

    return pessoa;
}

function montaTr(pessoa) {
    var pessoaTr = document.createElement("tr");
    pessoaTr.classList.add("pessoa");

    pessoaTr.appendChild(montaTd(pessoa.codigo, "info-codigo"));
    pessoaTr.appendChild(montaTd(pessoa.nome, "info-nome"));
    pessoaTr.appendChild(montaTd(pessoa.sobrenome, "info-sobrenome"));

    return pessoaTr;
}

function montaTd(dado, classe) {
    var td = document.createElement("td");
    td.classList.add(classe);
    td.textContent = dado;

    return td;
}