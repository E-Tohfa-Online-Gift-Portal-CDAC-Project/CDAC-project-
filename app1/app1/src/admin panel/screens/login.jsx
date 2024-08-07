import { Link } from "react-router-dom"

function Login(){
  return (
    <div>
        <h2 className='page-Header'>Login</h2>
      
        <div className="row">
            <div className="col-2"></div>
            <div className="col"></div>
            <div className="form">
                <div className="mb-3">
                    <label htmlFor="">Email</label>
                    <input type="email" className="form-control" /> 

                </div>
                <div className="mb-3">
                    <label htmlFor="">password</label>
                    <input type="password" className="form-control" />
                </div>
                
                </div> 
                <div>Don't have  account ? <Link to='/register'>Register here</Link>
                 </div>
                <button className='btn btn -success mt-2'>Login</button>
              </div>
            <div className="col-2"></div>



        </div>
    
  )
}


export default Login 