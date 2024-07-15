import { useState } from 'react'
import EncuestaForm from './components/EncuestaForm';
import Encuesta from './components/Encuesta';
import './App.css'
import PostForm from './components/PostForm';
import Post from './components/Post';

function App() {
  const [enquete, setEnquete] = useState(null);
  const [posts, setPosts] = useState([]);

  const handleEnqueteSubmit = (data) => {
    setEnquete(data);
  };

  const handlePostSubmit = (post) => {
    setPosts([...posts, post]);
  };

  return (
    <div>
      <h1>Enquete</h1>
      <EncuestaForm onSubmit={handleEnqueteSubmit} />
      {enquete && (
        <Encuesta 
          pergunta={enquete.pergunta} 
          resposta1={enquete.resposta1} 
          resposta2={enquete.resposta2} 
        />
      )}
      <h1>Posts</h1>
      <PostForm onSubmit={handlePostSubmit} />
      {posts.map((post, index) => (
        <Post key={index} {...post} />
      ))}
    </div>
  );
}

export default App
