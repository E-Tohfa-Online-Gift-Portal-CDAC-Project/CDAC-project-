import { Route, Routes } from "react-router-dom"
import Login from './user panel/screens/login'    
import Register from './user panel/screens/register' 

import { ToastContainer} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Home from "./user panel/screens/home";



function App() {
  return (
    // <div>kkkk{9+2}</div>
    <div className='container'>
      <Routes>
        <Route path='' element={<Login />} />
        <Route path='/register' element={<Register />} /> 
        <Route path='/home' element={<Home />} /> 

      </Routes>
      <ToastContainer />

    </div>
  )
}


export default App