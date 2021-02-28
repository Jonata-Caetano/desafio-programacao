var campoFiltroPessoa = document.querySelector("#filtrar-tabela");

campoFiltroPessoa.addEventListener("input", function () {
    console.log(this.value);
    var pessoas = document.querySelectorAll(".pessoa");
    console.log(pessoas);

    if (this.value.length > 0) {
        for (var i = 0; i < pessoas.length; i++) 
        {
            var pessoa = pessoas[i];
            var tdNome = pessoa.querySelector(".info-nome");
            var nome = tdNome.textContent;
            var expressao = new RegExp(this.value, "i"); 
            

            if (!expressao.test(nome))  {
                pessoa.classList.add("invisivel");
            } else {
                pessoa.classList.remove("invisivel");
            }
        }
    } else {
        for (var i = 0; i < pessoas.length; i++) 
        {
            var pessoa = pessoas[i];
            pessoa.classList.remove("invisivel");
        }
    }
});