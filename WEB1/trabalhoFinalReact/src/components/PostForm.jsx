import React, { useState } from 'react';

function PostForm({ onSubmit }) {
  const [titulo, setTitulo] = useState('');
  const [linkImagem, setLinkImagem] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit({ titulo, linkImagem });
    setTitulo('');
    setLinkImagem('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Título:</label>
        <input 
          type="text" 
          value={titulo} 
          onChange={(e) => setTitulo(e.target.value)} 
        />
      </div>
      <div>
        <label>Link da Imagem:</label>
        <input 
          type="text" 
          value={linkImagem} 
          onChange={(e) => setLinkImagem(e.target.value)} 
        />
      </div>
      <button type="submit">Enviar</button>
    </form>
  );
}

export default PostForm;
