/**
 * 
 */
alert("holaa");
  const cantidad = document.getElementById("cantidad");

  cantidad.addEventListener("input", function (event) {
    if (cantidad.validity.typeMismatch) {
      cantidad.setCustomValidity("I am expecting an e-mail address!");
    } else {
      cantidad.setCustomValidity("");
    }
  });