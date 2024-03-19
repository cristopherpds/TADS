const textArear = document.getElementById("mini-curriculo")

const btn = document.getElementById("btn")

btn.addEventListener("click", (e) => {  
    e.preventDefault()
    console.log(textArear.value)
})