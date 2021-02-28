const botaoAdicionarCafe = document.querySelector("#btn-cadastrar");

botaoAdicionarCafe.addEventListener("click", function (event) {
    event.preventDefault()


    var id = document.querySelector("#code").value;
    var nome = document.querySelector("#name").value;
    var lotacao = document.querySelector("#capacity").value;

    const cafe = { id: id, nome: nome, lotacao: lotacao };

    var request = new XMLHttpRequest();

    request.open("POST", "http://localhost:8080/espaco-cafe");
    request.setRequestHeader("Content-Type", "application/json");
    request.send(JSON.stringify(cafe));

    request.onload = function () {
        console.log("Entrou");

        if (request.status == "200") {
            console.log("Deu certo");
        } else {
            console.log("Deu erro");
        }
    };

});

