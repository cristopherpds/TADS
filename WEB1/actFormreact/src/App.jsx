import { useState } from 'react'
import './App.css'

const email = "admin@example.com"
const password = "admin123"

function App() {
  const [formData, setFormData] = useState ({
    email: "",
    password: "",
  })

  const handleChange = (e) => {
    const {name, value} = e.target;
    setFormData((prevState) => ({...prevState, [name]: value}))
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    if (formData.email === email && formData.password === password) {
      window.location.href = "https://www.google.com"
    } else {
      alert("Datos incorrectos")
    }
  }
  return (
    <>
      <div>
        <form action="" onSubmit={handleSubmit}>
          Email: <input type="email" name="email" value={formData.email} id="email" onChange={handleChange} required /><br />
          Password: <input type="password" name="password" value={formData.password} id="password" onChange={handleChange} required /><br />
          <button type="submit"  >Enviar</button>
        </form>
      </div>
    </>
  )
}

export default App
