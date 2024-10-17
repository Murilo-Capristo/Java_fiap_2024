<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
<h1>Cadastro de Usuário</h1>
<form action="cadastrar" method="post">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>
    <br>
    <label for="login">Login:</label>
    <input type="text" id="login" name="login" required>
    <br>
    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha" required>
    <br>
    <input type="submit" value="Cadastrar">
</form>
<script>
    document.getElementById('cadastroForm').addEventListener('submit', function(event) {
        event.preventDefault();
        const usuario = {
            nome: document.getElementById('nome').value,
            login: document.getElementById('login').value,
            senha: document.getElementById('senha').value
        };

        fetch('/api/usuario', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuario)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error('Erro ao cadastrar usuário');
            })
            .then(data => {
                console.log('Usuário cadastrado com sucesso:', data);
                alert('Usuário cadastrado com sucesso!');
            })
            .catch(error => {
                console.error('Erro:', error);
            });
    });
</script>
</body>
</html>
