var campoFiltroCafe = document.querySelector("#filtrar-tabela");

campoFiltroCafe.addEventListener("input", function () {
    console.log(this.value);
    var cafes = document.querySelectorAll(".cafe");
    console.log(cafes);

    if (this.value.length > 0) {
        for (var i = 0; i < cafes.length; i++) 
        {
            var cafe = cafes[i];
            var tdNome = cafe.querySelector(".info-nomeCafe");
            var nome = tdNome.textContent;
            var expressao = new RegExp(this.value, "i"); 
            

            if (!expressao.test(nome))  {
                cafe.classList.add("invisivel");
            } else {
                cafe.classList.remove("invisivel");
            }
        }
    } else {
        for (var i = 0; i < cafes.length; i++) 
        {
            var cafe = cafes[i];
            cafe.classList.remove("invisivel");
        }
    }
});