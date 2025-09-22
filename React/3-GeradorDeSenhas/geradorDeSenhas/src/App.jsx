import { useState } from "react";
import "./App.css";

function App() {
  const [senha, setSenha] = useState("");

  const gerarSenha = () => {
    let senha;
    const caracteres =
      "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}|\\:;\"'<>,.?/~`";

    senha = "";

    for (let i = 0; i < 12; i++) {
      senha += caracteres[Math.floor(Math.random() * (caracteres.length - 1))];
      console.log();
    }

    setSenha(senha);
  };
  return (
    <>
      <button onClick={gerarSenha}>Gerar</button>
      <button>Copiar</button>
      <p>{senha}</p>
    </>
  );
}

export default App;
