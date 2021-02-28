const botaoAdicionar = document.querySelector("#btn-cadastrar");

botaoAdicionar.addEventListener("click", function (event) {
    event.preventDefault()



    var id = document.querySelector("#code").value;
    var nome = document.querySelector("#first_name").value;
    var sobreNome = document.querySelector("#last_name").value;

    const pessoa = { id: id, nome: nome, sobrenome: sobreNome };

    var request = new XMLHttpRequest();

    request.open("POST", "http://localhost:8080/pessoa");
    request.setRequestHeader("Content-Type", "application/json");
    request.send(JSON.stringify(pessoa));

    request.onload = function () {
        console.log("Entrou");

        if (request.status == "200") {
            console.log("Deu certo");
        } else {
            console.log("Deu erro");
        }
    };

});