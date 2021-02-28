var botaoAdicionarSalaEvento = document.querySelector("#btn-cadastrar");
botaoAdicionarSalaEvento.addEventListener("click", function (event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona");

    var evento = obtemeventoDoFormulario(form);

    var eventoTr = montaTr(evento);

    var tabela = document.querySelector("#tabelaSalaEvento");

    tabela.appendChild(eventoTr);

    form.reset();
});

function obtemeventoDoFormulario(form) {
    var evento = {
        codigo: form.code.value,
        nome: form.name.value,
        lotacao: form.capacity.value,
    }

    return evento;
}

function montaTr(evento) {
    var eventoTr = document.createElement("tr");
    eventoTr.classList.add("evento");

    eventoTr.appendChild(montaTd(evento.codigo, "info-codigo"));
    eventoTr.appendChild(montaTd(evento.nome, "info-nome"));
    eventoTr.appendChild(montaTd(evento.lotacao, "info-lotacao"));

    return eventoTr;
}

function montaTd(dado, classe) {
    var td = document.createElement("td");
    td.classList.add(classe);
    td.textContent = dado;

    return td;
}

