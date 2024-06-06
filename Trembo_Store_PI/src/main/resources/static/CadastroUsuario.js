$(document).ready(function(){
            var urlParams = new URLSearchParams(window.location.search);
            var userId = urlParams.get('id');

            if (userId) {
                $.ajax({
                    url: "/api/users/" + userId,
                    type: "GET",
                    success: function(user){
                        $("#nome").val(user.nome);
                        $("#email").val(user.email);
                        $("#cpf").val(user.cpf);
                        $("#senha").val(user.senha);
                        $("#confirmarSenha").val(user.confirmarSenha);
                        $("#cargo").val(user.cargo);
                        $("#status").val(user.status);
                    },
                    error: function(error){
                        console.log(error);
                    }
                });
            }

            $("form").on("submit", function(event){
                event.preventDefault();

                var formData = {
                    nome: $("#nome").val(),
                    email: $("#email").val(),
                    cpf: $("#cpf").val(),
                    senha: $("#senha").val(),
                    confirmarSenha: $("#confirmarSenha").val(),
                    cargo: $("#cargo").val(),
                    status: $("#status").val()
                };

                var url = "/api/users";
                var type = "POST";

                if (userId) {
                    url += "/" + userId;
                    type = "PUT";
                }

                $.ajax({
                    url: url,
                    type: type,
                    contentType: "application/json",
                    data: JSON.stringify(formData),
                    success: function(response){
                        console.log(response);
                        window.location.href = "/login.html";
                    },
                    error: function(error){
                        console.log(error);
                    }
                });
            });
        });