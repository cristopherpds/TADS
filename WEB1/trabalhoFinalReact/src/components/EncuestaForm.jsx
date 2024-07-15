import React, { useState } from 'react';

function EncuestaForm({ onSubmit }) {
  const [pergunta, setPergunta] = useState('');
  const [resposta1, setResposta1] = useState('');
  const [resposta2, setResposta2] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit({ pergunta, resposta1, resposta2 });
    setPergunta('');
    setResposta1('');
    setResposta2('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Pergunta:</label>
        <input 
          type="text" 
          value={pergunta} 
          onChange={(e) => setPergunta(e.target.value)} 
        />
      </div>
      <div>
        <label>Resposta 1</label>
        <input 
          type="text" 
          value={resposta1} 
          onChange={(e) => setResposta1(e.target.value)} 
        />
      </div>
      <div>
        <label>Resposta 2</label>
        <input 
          type="text" 
          value={resposta2} 
          onChange={(e) => setResposta2(e.target.value)} 
        />
      </div>
      <button type="submit">Enviar</button>
    </form>
  );
}

export default EncuestaForm;
