var container = document.querySelector(".pseletivo");

container.innerHTML = "";
var dataProximoProcessoSeletivo = "2024- 11-30";

var proximoProcessoSeletivo = new Date(dataProximoProcessoSeletivo);

var hoje = new Date();

var diferenca = proximoProcessoSeletivo - hoje;

var diasFaltando = Math.ceil(diferenca / (1000 * 60 * 60 * 24));

container.innerHTML += `Faltam <span class="font-bold pseletivo">${diasFaltando} dias</span> para o próximo Processo Seletivo do IFSul.`;



$(document).ready(function() {
    $("#testimonial-carousel").owlCarousel({
        items: 1,
        loop: true,
        autoplay: true,
        autoplayTimeout: 5000,
        autoplayHoverPause: true,
        nav: true,
        navText: ["<i class='fas fa-arrow-left'></i>", "<i class='fas fa-arrow-right'></i>"],
        dots: true
    });
});
