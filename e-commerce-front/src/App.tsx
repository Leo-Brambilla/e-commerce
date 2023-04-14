
import './styles/global.css';
import { Navbar } from './components/Navbar';
import { Usuarios } from './views/Usuarios';
import { Clientes } from './views/Clientes';


function App() {
  return (
    <div className='my-auto'>
      <div>
        <Navbar />
      </div>
      <div className="flex flex-col">
        <Usuarios />
        <Clientes />
       
      </div>
    </div>
  );
}

export default App;