
import './styles/global.css';
import { Navbar } from './components/Navbar';
import { Usuarios } from './views/Usuarios';

function App() {
  return (
    <div className='my-auto'>
      <div>
        <Navbar />
      </div>
      <body>
        <Usuarios />
      </body>
    </div>
  );
}

export default App;