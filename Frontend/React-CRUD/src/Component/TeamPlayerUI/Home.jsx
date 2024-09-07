import React from 'react'
import { Link } from 'react-router-dom'
function Home() {
  return (
    <div>
        <h3 className=' text-danger text-center'>Welcome to the Teamplayer Management Application</h3>
        <div className=' d-flex justify-content-center'>
        <Link to='info'><button className=' btn btn-primary'>You want to see The Data</button></Link>
        </div>
    </div>
  )
}

export default Home