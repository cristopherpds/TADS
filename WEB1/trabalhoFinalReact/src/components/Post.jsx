import React from 'react';

function Post({ titulo, linkImagem }) {
  return (
    <div>
      <h3>{titulo}</h3>
      {linkImagem ? (
        <img src={linkImagem} alt={titulo} style={{ width: '100px', height: '100px' }} />
      ) : (
        <p>Imagem não disponível</p>
      )}
    </div>
  );
}

export default Post;

