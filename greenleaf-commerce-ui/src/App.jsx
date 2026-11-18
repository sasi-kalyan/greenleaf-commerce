
import Navbar from './components/Navbar';
import Login from './components/Login'; 
import Footer from './components/Footer';
function App() {

  return(
    <div className="flex flex-col min-h-screen">
      <Navbar />
      <Login />
      <Footer />
    </div>
  )
}

export default App;