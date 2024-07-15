import React, { useState } from 'react';

function Encuesta({ pergunta, resposta1, resposta2 }) {
  const [votes1, setVotes1] = useState(0);
  const [votes2, setVotes2] = useState(0);

  return (
    <div>
      <h2>{pergunta}</h2>
      <div>
        <button onClick={() => setVotes1(votes1 + 1)}>
          {resposta1} ({votes1})
        </button>
        <button onClick={() => setVotes2(votes2 + 1)}>
          {resposta2} ({votes2})
        </button>
      </div>
    </div>
  );
}

export default Encuesta;
