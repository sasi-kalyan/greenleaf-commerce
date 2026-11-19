
import Navbar from './components/Navbar';
import Login from './components/Login'; 
import Footer from './components/Footer';
import Home from './components/Home';
import Admin from './components/Admin';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
function App() {

  return(
    <Router>
      <div className="flex flex-col min-h-screen">
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/admin" element={<Admin />} />
        </Routes>
        <Footer />
      </div>
    </Router>
  )
}

export default App;