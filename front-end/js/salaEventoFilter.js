var campoFiltroEvento = document.querySelector("#filtrar-tabela");

campoFiltroEvento.addEventListener("input", function () {
    console.log(this.value);
    var eventos = document.querySelectorAll(".evento");
    console.log(eventos);

    if (this.value.length > 0) {
        for (var i = 0; i < eventos.length; i++) 
        {
            var evento = eventos[i];
            var tdNome = evento.querySelector(".info-nomeEvento");
            var nome = tdNome.textContent;
            var expressao = new RegExp(this.value, "i"); 
            

            if (!expressao.test(nome))  {
                evento.classList.add("invisivel");
            } else {
                evento.classList.remove("invisivel");
            }
        }
    } else {
        for (var i = 0; i < eventos.length; i++) 
        {
            var evento = eventos[i];
            evento.classList.remove("invisivel");
        }
    }
});