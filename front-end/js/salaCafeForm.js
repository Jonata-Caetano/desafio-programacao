var botaoAdicionarEspacoCafe = document.querySelector("#btn-cadastrar");
botaoAdicionarEspacoCafe.addEventListener("click", function (event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona");

    var cafe = obtemCafeDoFormulario(form);

    var cafeTr = montaTr(cafe);

    var tabela = document.querySelector("#tabelaCafe");

    tabela.appendChild(cafeTr);

    form.reset();
});

function obtemCafeDoFormulario(form) {
    var cafe = {
        codigo: form.code.value,
        nome: form.name.value,
        lotacao: form.capacity.value,
    }

    return cafe;
}

function montaTr(cafe) {
    var cafeTr = document.createElement("tr");
    cafeTr.classList.add("cafe");

    cafeTr.appendChild(montaTd(cafe.codigo, "info-codigo"));
    cafeTr.appendChild(montaTd(cafe.nome, "info-nome"));
    cafeTr.appendChild(montaTd(cafe.lotacao, "info-lotacao"));

    return cafeTr;
}

function montaTd(dado, classe) {
    var td = document.createElement("td");
    td.classList.add(classe);
    td.textContent = dado;

    return td;
}