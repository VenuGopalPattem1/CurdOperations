import React from 'react'
import Data from './Data';
import { BrowserRouter, Route,Routes } from 'react-router-dom';
import Home from './Home';
import Edit from './Edit';

function Index() {
    return (
        <div className=' mt-4'>
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<Home />}></Route>
                    <Route path='info' element={<Data />}></Route>
                    <Route path='edit/:id' element={<Edit />}></Route>
                </Routes>
            </BrowserRouter>

        </div>
    )
}

export default Index;