
import './styles/global.css';
import { Navbar } from './components/Navbar';
import { Usuarios } from './views/Usuarios';
import { Clientes } from './views/Clientes';
import { Home } from './views/Home';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';



function App() {
  return (
    <div>
      <div>
        <Navbar />
      </div>
      <div>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/clientes" element={<Clientes />} />
          <Route path="/users" element={<Usuarios />} />
        </Routes>
      </Router>
      </div>
    </div>
  );
}

export default App;